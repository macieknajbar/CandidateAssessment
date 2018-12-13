package com.gmail.najbar.maciek.candidateassessment.domain

import com.gmail.najbar.maciek.candidateassessment.domain.exceptions.IncorrectPhoneNumberException
import org.junit.Assert.fail
import org.junit.Test

class PhoneNumberTest {

    @Test fun `confirms correct number number`() {
        try {
            PhoneNumber("")
        } catch (ignored: IncorrectPhoneNumberException) {
            return
        }

        fail("Should throw IncorrectPhoneNumberException")
    }
}