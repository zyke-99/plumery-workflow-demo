package org.zyke.mock

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.zyke.workflow.activity.SelfieValidationActivity
import org.zyke.workflow.activity.request.SelfieValidationActivityRequest
import org.zyke.workflow.activity.response.SelfieValidationActivityResponse

class SelfieValidationActivityMockImpl : SelfieValidationActivity {

    private val logger: Logger = LoggerFactory.getLogger(SelfieValidationActivityMockImpl::class.java)

    override fun validateSelfie(validateSelfieValidationActivityRequest: SelfieValidationActivityRequest): SelfieValidationActivityResponse {

        logger.info("Validating selfie with resource {}", validateSelfieValidationActivityRequest.selfie)
        Thread.sleep(1000)
        logger.info("Successfully validated selfie with resource {}", validateSelfieValidationActivityRequest.selfie)
        return SelfieValidationActivityResponse(true)
    }
}