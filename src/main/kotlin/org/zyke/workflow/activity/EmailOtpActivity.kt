package org.zyke.workflow.activity

import io.temporal.activity.ActivityInterface
import io.temporal.activity.ActivityMethod
import org.zyke.workflow.activity.request.EmailOtpActivityRequest
import org.zyke.workflow.activity.response.EmailOtpActivityResponse

@ActivityInterface
interface EmailOtpActivity {

    @ActivityMethod
    fun sendEmailOtp(emailOtpActivityRequest: EmailOtpActivityRequest): EmailOtpActivityResponse
}