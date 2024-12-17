package org.zyke.workflow.activity.request

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty

data class PhoneOtpActivityRequest @JsonCreator constructor(
    @JsonProperty("onboardingId") var onboardingId: String?,
    @JsonProperty("phoneNumber") var phoneNumer: String?
)
