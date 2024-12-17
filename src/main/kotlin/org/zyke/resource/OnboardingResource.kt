package org.zyke.resource

import jakarta.inject.Inject
import jakarta.ws.rs.POST
import jakarta.ws.rs.Path
import jakarta.ws.rs.Produces
import jakarta.ws.rs.core.MediaType
import org.zyke.resource.request.OnboardingRequest
import org.zyke.service.OnboardingService

@Path("/onboarding")
class OnboardingResource {

    @Inject
    lateinit var onboardingService: OnboardingService

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    fun startOnboarding(onboardingRequest: OnboardingRequest): String {

        val onboardingId = onboardingService.startOnboarding(onboardingRequest)
        return "Started onboarding process with id %s".format(onboardingId)
    }
}