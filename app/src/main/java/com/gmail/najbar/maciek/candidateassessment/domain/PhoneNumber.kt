package com.gmail.najbar.maciek.candidateassessment.domain

import com.gmail.najbar.maciek.candidateassessment.domain.exceptions.IncorrectPhoneNumberException

class PhoneNumber(val phoneNumber: String) {
    init {
        if (phoneNumber.matches(Regex("^\\+\\d{11}\$")).not())
            throw IncorrectPhoneNumberException()
    }

    override fun hashCode(): Int {
        return phoneNumber.hashCode()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }
        if (other is PhoneNumber) {
            return phoneNumber == other.phoneNumber
        }
        return false
    }
}