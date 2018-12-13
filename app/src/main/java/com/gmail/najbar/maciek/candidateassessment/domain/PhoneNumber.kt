package com.gmail.najbar.maciek.candidateassessment.domain

import com.gmail.najbar.maciek.candidateassessment.domain.exceptions.IncorrectPhoneNumberException

class PhoneNumber(val phoneNumber: String) {
    init {
        if (phoneNumber.matches(Regex("^\\+\\d{11}\$")).not())
            throw IncorrectPhoneNumberException()
    }
}