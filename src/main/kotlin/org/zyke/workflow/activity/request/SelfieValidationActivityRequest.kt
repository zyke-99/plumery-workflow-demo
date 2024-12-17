package org.zyke.workflow.activity.request

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty

data class SelfieValidationActivityRequest @JsonCreator constructor(
    @JsonProperty("onboardingId") val onboardingId: String,
    @JsonProperty("selfie") val selfie: String
)
