package org.zyke.workflow.activity

import io.temporal.activity.ActivityInterface
import io.temporal.activity.ActivityMethod
import org.zyke.workflow.activity.request.TaxResidenceCheckActivityRequest
import org.zyke.workflow.activity.response.TaxResidenceCheckActivityResponse

@ActivityInterface
interface TaxResidenceCheckActivity {

    @ActivityMethod
    fun checkTaxResidence(taxResidenceCheckActivityRequest: TaxResidenceCheckActivityRequest): TaxResidenceCheckActivityResponse
}