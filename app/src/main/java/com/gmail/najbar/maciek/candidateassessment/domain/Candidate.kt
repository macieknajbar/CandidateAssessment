package com.gmail.najbar.maciek.candidateassessment.domain

class Candidate(val fullName: String, val phoneNumber: String) {

    val contactNumbers: Collection<String> = mutableListOf()

    init {
        if (fullName.split(' ').size < 2) throw NotFullNameException()
        if (phoneNumber.matches(Regex("\\d{9}")).not()) throw PhoneNumberMissingException()
    }

}