package org.zyke.workflow.activity.request

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty

data class LivenessCheckActivityRequest @JsonCreator constructor(
    @JsonProperty("onboardingId") val onboardingId: String,
    @JsonProperty("passportInformation") val passportInformation: String
)
