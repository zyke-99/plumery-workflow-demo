package org.zyke.workflow

import io.temporal.activity.ActivityOptions
import io.temporal.common.RetryOptions
import io.temporal.workflow.Workflow
import org.zyke.workflow.activity.*
import org.zyke.workflow.activity.request.*
import java.time.Duration


class OnboardingWorkflowImpl : OnboardingWorkflow {

    private var isPhoneOtpVerified = false

    // TODO: email is same as phone so no need
    private var isEmailOtpVerified = true

    private var isSelfieVerified = false

    private val options: ActivityOptions = ActivityOptions.newBuilder()
        .setStartToCloseTimeout(Duration.ofMinutes(1))
        .setRetryOptions(
            RetryOptions.newBuilder()
                .setInitialInterval(Duration.ofSeconds(5))
                .setBackoffCoefficient(1.0)
                .setMaximumAttempts(10)
                .build()
        )
        .build()

    private val phoneOtpActivity: PhoneOtpActivity =
        Workflow.newActivityStub(PhoneOtpActivity::class.java, options)

    private val emailOtpActivity: EmailOtpActivity =
        Workflow.newActivityStub(EmailOtpActivity::class.java, options)

    private val livenessCheckActivity: LivenessCheckActivity =
        Workflow.newActivityStub(LivenessCheckActivity::class.java, options)

    private val taxResidenceCheckActivity: TaxResidenceCheckActivity =
        Workflow.newActivityStub(TaxResidenceCheckActivity::class.java, options)

    private val selfieValidationActivity: SelfieValidationActivity =
        Workflow.newActivityStub(SelfieValidationActivity::class.java, options)

    private val completeOnboardingActivity: CompleteOnboardingActivity =
        Workflow.newActivityStub(CompleteOnboardingActivity::class.java, options)

    override fun startOnboarding(onboardingWorkflowRequest: OnboardingWorkflowRequest) {

        val onboardingId = onboardingWorkflowRequest.onboardingId

        // Phone validation
        phoneOtpActivity.sendPhoneOtp(
            PhoneOtpActivityRequest(
                onboardingId,
                onboardingWorkflowRequest.phoneNumber
            )
        )
        Workflow.await(Duration.ofHours(1)) {
            isPhoneOtpVerified
        }

        // Email validation
        emailOtpActivity.sendEmailOtp(
            EmailOtpActivityRequest(
                onboardingId,
                onboardingWorkflowRequest.email
            )
        )
        Workflow.await(Duration.ofHours(1)) {
            isEmailOtpVerified
        }

        // Liveness check
        livenessCheckActivity.checkLiveness(
            LivenessCheckActivityRequest(
                onboardingId,
                onboardingWorkflowRequest.passportInformation
            )
        )

        // Tax and Residence check
        taxResidenceCheckActivity.checkTaxResidence(
            TaxResidenceCheckActivityRequest(
                onboardingId,
                onboardingWorkflowRequest.taxId,
                onboardingWorkflowRequest.residenceAddress
            )
        )

        // Selfie validation
        selfieValidationActivity.validateSelfie(
            SelfieValidationActivityRequest(
                onboardingId,
                onboardingWorkflowRequest.selfie
            )
        )
        Workflow.await(Duration.ofHours(1)) {
            isSelfieVerified
        }

        completeOnboardingActivity.completeOnboarding()
    }

    override fun phoneOtpComplete() {
        this.isPhoneOtpVerified = true
    }

    override fun emailOtpComplete() {
        this.isEmailOtpVerified = true
    }

    override fun selfieVerificationComplete() {
        this.isSelfieVerified = true
    }
}