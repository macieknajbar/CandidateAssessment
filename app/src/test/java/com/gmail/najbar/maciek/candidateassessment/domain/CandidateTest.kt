package com.gmail.najbar.maciek.candidateassessment.domain

import org.junit.Assert.assertTrue
import org.junit.Assert.fail
import org.junit.Test

class CandidateTest {

    @Test fun `requires full name`() {
        try {
            Candidate("Maciej", "")
        } catch (ignored: NotFullNameException) {
            return
        }

        fail("Should throw NotFullNameException!")
    }

    @Test fun `requires phone number`() {
        try {
            Candidate("Maciej Najbar", "")
        } catch (ignored: IncorrectPhoneNumberException) {
            return
        }

        fail("Should throw PhoneNumberMissingException")
    }

    @Test fun `adds phone number to contact numbers list`() {
        val phoneNumber = "123456789"
        val candidate = Candidate("Maciej Najbar", phoneNumber)

        assertTrue(candidate.contactNumbers.contains(phoneNumber))
    }

    @Test fun `adds additional numbers to contact list`() {
        val phoneNumber = "123456789"
        val contactNumber = "123123123"
        val candidate = Candidate("Maciej Najbar", phoneNumber)

        candidate.addContactNumber(contactNumber)

        assertTrue(candidate.contactNumbers.contains(contactNumber))
    }

    @Test fun `confirms any added phone number is correct`() {
        try {
            Candidate("Maciej Najbar", "123456789")
                    .addContactNumber("12312")
        } catch (ignored: IncorrectPhoneNumberException) {
            return
        }

        fail("Should throw IncorrectPhoneNumberException")
    }
}