package org.zyke.workflow

import io.temporal.workflow.SignalMethod
import io.temporal.workflow.WorkflowInterface
import io.temporal.workflow.WorkflowMethod

@WorkflowInterface
interface OnboardingWorkflow {

    @WorkflowMethod
    fun startOnboarding(onboardingWorkflowRequest: OnboardingWorkflowRequest)

    @SignalMethod
    fun phoneOtpComplete()

    @SignalMethod
    fun emailOtpComplete()

    @SignalMethod
    fun selfieVerificationComplete()
}