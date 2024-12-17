package org.zyke.workflow.activity.request

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty

data class TaxResidenceCheckActivityRequest @JsonCreator constructor(
    @JsonProperty("onboardingId") val onboardingId: String,
    @JsonProperty("taxId") val taxId: String,
    @JsonProperty("address") val address: String
)
