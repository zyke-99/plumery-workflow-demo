package org.zyke.workflow.activity

import io.temporal.activity.ActivityInterface
import io.temporal.activity.ActivityMethod
import org.zyke.workflow.activity.request.PhoneOtpActivityRequest
import org.zyke.workflow.activity.response.PhoneOtpActivityResponse

@ActivityInterface
interface PhoneOtpActivity {

    @ActivityMethod
    fun sendPhoneOtp(phoneOtpActivityRequest: PhoneOtpActivityRequest): PhoneOtpActivityResponse
}