package com.gmail.najbar.maciek.candidateassessment.domain

import com.gmail.najbar.maciek.candidateassessment.domain.exceptions.IncorrectPhoneNumberException
import org.junit.Assert.assertEquals
import org.junit.Assert.fail
import org.junit.Test

class PhoneNumberTest {

    @Test fun `throws an exception on incorrect number`() {
        try {
            PhoneNumber("123456789")
        } catch (ignored: IncorrectPhoneNumberException) {
            return
        }

        fail("Should throw IncorrectPhoneNumberException")
    }

    @Test fun `confirms number is correct`() {
        val phoneNumber = "+48123456789"

        assertEquals(phoneNumber, PhoneNumber(phoneNumber).phoneNumber)
    }
}