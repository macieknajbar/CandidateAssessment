package com.gmail.najbar.maciek.candidateassessment.domain.factory

import com.gmail.najbar.maciek.candidateassessment.domain.CandidateEntity
import com.gmail.najbar.maciek.candidateassessment.domain.PhoneNumberEntity

object CandidateFactory {

    fun from(id: String, fullName: String, phoneNumber: String) = CandidateEntity(id, fullName, mutableListOf(PhoneNumberEntity(phoneNumber)), "")
}