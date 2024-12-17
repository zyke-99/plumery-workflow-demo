package org.zyke.mock

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.zyke.workflow.activity.PhoneOtpActivity
import org.zyke.workflow.activity.request.PhoneOtpActivityRequest
import org.zyke.workflow.activity.response.PhoneOtpActivityResponse

class PhoneOtpActivityMockImpl : PhoneOtpActivity {

    private val logger: Logger = LoggerFactory.getLogger(PhoneOtpActivityMockImpl::class.java)

    override fun sendPhoneOtp(phoneOtpActivityRequest: PhoneOtpActivityRequest): PhoneOtpActivityResponse {

        logger.info("Sending OTP to phone number {}", phoneOtpActivityRequest.phoneNumer)
        Thread.sleep(5000)
        logger.info("Sent OTP to phone number {}", phoneOtpActivityRequest.phoneNumer)
        return PhoneOtpActivityResponse(true)
    }
}