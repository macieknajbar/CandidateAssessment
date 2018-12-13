package com.gmail.najbar.maciek.candidateassessment.domain

object CandidateFactory {

    fun from(fullName: String, phoneNumber: String) = Candidate(fullName, PhoneNumber(phoneNumber))
}