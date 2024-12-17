package org.zyke.resource

import jakarta.inject.Inject
import jakarta.ws.rs.Consumes
import jakarta.ws.rs.POST
import jakarta.ws.rs.Path
import jakarta.ws.rs.core.MediaType
import org.zyke.resource.request.PhoneOtpVerificationRequest
import org.zyke.service.OnboardingService

@Path("/phone")
class PhoneOtpVerificationCallbackResource {

    @Inject
    lateinit var onboardingService: OnboardingService

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    fun verify(phoneOtpVerificationRequest: PhoneOtpVerificationRequest) {

        onboardingService.completePhoneOtpVerification(phoneOtpVerificationRequest);
    }
}