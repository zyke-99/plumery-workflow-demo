package org.zyke.workflow.activity

import io.temporal.activity.ActivityInterface
import io.temporal.activity.ActivityMethod
import org.zyke.workflow.activity.request.SelfieValidationActivityRequest
import org.zyke.workflow.activity.response.SelfieValidationActivityResponse

@ActivityInterface
interface SelfieValidationActivity {

    @ActivityMethod
    fun validateSelfie(validateSelfieValidationActivityRequest: SelfieValidationActivityRequest): SelfieValidationActivityResponse
}