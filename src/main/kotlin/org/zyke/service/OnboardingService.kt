package org.zyke.service

import io.temporal.api.enums.v1.WorkflowIdReusePolicy
import io.temporal.client.WorkflowClient
import io.temporal.client.WorkflowOptions
import jakarta.enterprise.context.ApplicationScoped
import jakarta.inject.Inject
import org.zyke.resource.request.OnboardingRequest
import org.zyke.resource.request.PhoneOtpVerificationRequest
import org.zyke.resource.request.SelfieVerificationRequest
import org.zyke.workflow.OnboardingWorkflow
import org.zyke.workflow.OnboardingWorkflowRequest
import java.security.MessageDigest


@ApplicationScoped
class OnboardingService {

    @Inject
    lateinit var client: WorkflowClient

    fun startOnboarding(onboardingRequest: OnboardingRequest): String {

        val onboardingId = generateOnboardingId(onboardingRequest)

        val options = WorkflowOptions.newBuilder()
            .setWorkflowId(onboardingId)
            .setTaskQueue("<default>")
            .setWorkflowIdReusePolicy(WorkflowIdReusePolicy.WORKFLOW_ID_REUSE_POLICY_ALLOW_DUPLICATE_FAILED_ONLY)
            .build()

        val workflow: OnboardingWorkflow = client.newWorkflowStub(OnboardingWorkflow::class.java, options)

        val onboardingWorkflowRequest = OnboardingWorkflowRequest(
            onboardingId,
            onboardingRequest.email, onboardingRequest.phoneNumber, onboardingRequest.firstName,
            onboardingRequest.lastName, onboardingRequest.passportInformation, onboardingRequest.taxId,
            onboardingRequest.residenceAddress, onboardingRequest.selfie
        )

        WorkflowClient.start(workflow::startOnboarding, onboardingWorkflowRequest)
        return onboardingId
    }

    fun completePhoneOtpVerification(phoneOtpVerificationRequest: PhoneOtpVerificationRequest) {

        // TODO: in real world this would call an OTP service to validate, hardcoding it now
        if (phoneOtpVerificationRequest.code.equals("1111")) {

            throw RuntimeException("Incorrect phone number")
        }

        getWorkflowStub(phoneOtpVerificationRequest.onboardingId).phoneOtpComplete()
    }

    fun completeSelfieVerification(selfieVerificationRequest: SelfieVerificationRequest) {

        // TODO: in real world this would call an OTP service to validate, hardcoding it now
        if (!selfieVerificationRequest.isSuccess) {

            throw RuntimeException("Selfie verification failed")
        }

        getWorkflowStub(selfieVerificationRequest.onboardingId).selfieVerificationComplete()
    }

    private fun generateOnboardingId(onboardingRequest: OnboardingRequest): String {

        val bytes = onboardingRequest.email.toByteArray(Charsets.UTF_8)

        // Using this, since default hash is 32 bits, collisions more likely
        val digest = MessageDigest.getInstance("SHA-256")
        val hashBytes = digest.digest(bytes)

        return hashBytes.joinToString("") { "%02x".format(it) }
    }

    private fun getWorkflowStub(onboardingId: String): OnboardingWorkflow {

        return client.newWorkflowStub(
            OnboardingWorkflow::class.java,
            onboardingId
        )
    }
}