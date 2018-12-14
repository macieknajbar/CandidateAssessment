package com.gmail.najbar.maciek.candidateassessment.domain

import com.gmail.najbar.maciek.candidateassessment.domain.exceptions.NotFullNameException

data class CandidateEntity(val id: String, val fullName: String, val contactNumbers: Collection<PhoneNumberEntity> = mutableListOf()) {

    init {
        if (fullName.split(' ').size < 2) throw NotFullNameException()
    }

    fun addContactNumber(contactNumber: PhoneNumberEntity) {
        (contactNumbers as MutableCollection).add(contactNumber)
    }
}