package com.gmail.najbar.maciek.candidateassessment.domain

import com.gmail.najbar.maciek.candidateassessment.domain.exceptions.NotFullNameException

data class Candidate(val fullName: String, val contactNumbers: Collection<PhoneNumber> = mutableListOf()) {

    init {
        if (fullName.split(' ').size < 2) throw NotFullNameException()
    }

    fun addContactNumber(contactNumber: PhoneNumber) {
        (contactNumbers as MutableCollection).add(contactNumber)
    }
}