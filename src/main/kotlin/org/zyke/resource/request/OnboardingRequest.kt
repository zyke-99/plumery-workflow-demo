package org.zyke.resource.request

data class OnboardingRequest(
    val email: String,
    val phoneNumber: String,
    val firstName: String,
    val lastName: String,
    val passportInformation: String,
    val taxId: String,
    val residenceAddress: String,
    val selfie: String
)
