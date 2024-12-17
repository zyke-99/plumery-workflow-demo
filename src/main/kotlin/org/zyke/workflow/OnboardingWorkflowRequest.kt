package org.zyke.workflow

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty

data class OnboardingWorkflowRequest @JsonCreator constructor(
    @JsonProperty("onboardingId") val onboardingId: String,
    @JsonProperty("email") val email: String,
    @JsonProperty("phoneNumber") val phoneNumber: String,
    @JsonProperty("firstName") val firstName: String,
    @JsonProperty("lastName") val lastName: String,
    @JsonProperty("passportInformation") val passportInformation: String,
    @JsonProperty("taxId") val taxId: String,
    @JsonProperty("residenceAddress") val residenceAddress: String,
    @JsonProperty("selfie") val selfie: String
)