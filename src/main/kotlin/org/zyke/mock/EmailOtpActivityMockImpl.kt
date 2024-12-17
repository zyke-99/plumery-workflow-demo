package org.zyke.mock

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.zyke.workflow.activity.EmailOtpActivity
import org.zyke.workflow.activity.request.EmailOtpActivityRequest
import org.zyke.workflow.activity.response.EmailOtpActivityResponse

class EmailOtpActivityMockImpl : EmailOtpActivity {

    private val logger: Logger = LoggerFactory.getLogger(EmailOtpActivityMockImpl::class.java)

    override fun sendEmailOtp(emailOtpActivityRequest: EmailOtpActivityRequest): EmailOtpActivityResponse {

        logger.info("Sending OTP to email {}", emailOtpActivityRequest.email)
        Thread.sleep(10000)
        logger.info("Successfully sent OTP to email {}", emailOtpActivityRequest.email)
        return EmailOtpActivityResponse(true)
    }
}