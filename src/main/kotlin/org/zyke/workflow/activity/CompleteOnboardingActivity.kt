package org.zyke.workflow.activity

import io.temporal.activity.ActivityInterface
import io.temporal.activity.ActivityMethod

@ActivityInterface
interface CompleteOnboardingActivity {

    @ActivityMethod
    fun completeOnboarding()
}