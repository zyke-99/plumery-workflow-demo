package org.zyke.resource

import jakarta.inject.Inject
import jakarta.ws.rs.Consumes
import jakarta.ws.rs.POST
import jakarta.ws.rs.Path
import jakarta.ws.rs.core.MediaType
import org.zyke.resource.request.SelfieVerificationRequest
import org.zyke.service.OnboardingService

@Path("/selfie")
class SelfieVerificationCallbackResource {

    @Inject
    lateinit var onboardingService: OnboardingService

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    fun verify(selfieVerificationRequest: SelfieVerificationRequest) {

        onboardingService.completeSelfieVerification(selfieVerificationRequest)
    }
}