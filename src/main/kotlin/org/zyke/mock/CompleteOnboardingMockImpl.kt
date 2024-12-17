package org.zyke.mock

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.zyke.workflow.activity.CompleteOnboardingActivity

class CompleteOnboardingMockImpl : CompleteOnboardingActivity {

    private val logger: Logger = LoggerFactory.getLogger(CompleteOnboardingMockImpl::class.java)

    override fun completeOnboarding() {

        logger.info("Onboarding complete, sent mock event to messaging queue!")
    }
}