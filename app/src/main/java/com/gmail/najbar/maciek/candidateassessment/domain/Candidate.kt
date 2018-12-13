package com.gmail.najbar.maciek.candidateassessment.domain

import com.gmail.najbar.maciek.candidateassessment.domain.exceptions.NotFullNameException

class Candidate(val fullName: String, val phoneNumber: PhoneNumber) {

    val contactNumbers: Collection<PhoneNumber> = mutableListOf()

    init {
        if (fullName.split(' ').size < 2) throw NotFullNameException()
        addContactNumber(phoneNumber)
    }

    fun addContactNumber(contactNumber: PhoneNumber) {
        (contactNumbers as MutableCollection).add(contactNumber)
    }
}