package com.gmail.najbar.maciek.candidateassessment.domain

import com.gmail.najbar.maciek.candidateassessment.domain.exceptions.IncorrectPhoneNumberException
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNotEquals
import org.junit.Assert.assertTrue
import org.junit.Assert.fail
import org.junit.Test

class PhoneNumberTest {

    private val phone1 = PhoneNumber("+48123456789")
    private val phone2 = PhoneNumber("+48123456789")
    private val phone3 = PhoneNumber("+48123123123")

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

    @Test fun `differs from null`() {
        assertFalse(phone1.equals(null))
    }

    @Test fun `equals itself`() {
        assertTrue(phone1.equals(phone1))
    }

    @Test fun `equals same`() {
        val phone = PhoneNumber(phone1.phoneNumber)
        assertTrue(phone1 == phone2)
        assertTrue(phone2 == phone1)

        assertTrue(phone2 == phone)
        assertTrue(phone1 == phone)
        assertEquals(phone1.hashCode(), phone2.hashCode())
        assertEquals(phone1.hashCode(), phone.hashCode())
    }

    @Test fun `differs phones`() {
        assertFalse(phone1 == phone3)
        assertNotEquals(phone1.hashCode(), phone3.hashCode())
    }
}