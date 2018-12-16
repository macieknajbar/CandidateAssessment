package com.gmail.najbar.maciek.candidateassessment.domain

object CandidateFactory {

    fun from(id: String, fullName: String, phoneNumber: String) = CandidateEntity(id, fullName, mutableListOf(PhoneNumberEntity(phoneNumber)), "")
}