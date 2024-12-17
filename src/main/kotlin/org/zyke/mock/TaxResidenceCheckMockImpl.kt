package org.zyke.mock

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.zyke.workflow.activity.TaxResidenceCheckActivity
import org.zyke.workflow.activity.request.TaxResidenceCheckActivityRequest
import org.zyke.workflow.activity.response.TaxResidenceCheckActivityResponse

class TaxResidenceCheckMockImpl : TaxResidenceCheckActivity {

    private val logger: Logger = LoggerFactory.getLogger(TaxResidenceCheckMockImpl::class.java)

    override fun checkTaxResidence(taxResidenceCheckActivityRequest: TaxResidenceCheckActivityRequest): TaxResidenceCheckActivityResponse {

        logger.info(
            "Checking tax and residence for tax id {} and address {}",
            taxResidenceCheckActivityRequest.taxId,
            taxResidenceCheckActivityRequest.address
        )
        Thread.sleep(1000)
        logger.info(
            "Successfully checked tax and residence for tax id {} and address {}",
            taxResidenceCheckActivityRequest.taxId,
            taxResidenceCheckActivityRequest.address
        )
        return TaxResidenceCheckActivityResponse(true)
    }
}