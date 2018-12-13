package com.gmail.najbar.maciek.candidateassessment.domain

import com.gmail.najbar.maciek.candidateassessment.domain.exceptions.IncorrectPhoneNumberException
import com.gmail.najbar.maciek.candidateassessment.domain.exceptions.NotFullNameException
import org.junit.Assert.assertTrue
import org.junit.Assert.fail
import org.junit.Test

class CandidateTest {

    @Test fun `requires full name`() {
        try {
            Candidate("Maciej", PhoneNumber("+48123456789"))
        } catch (ignored: NotFullNameException) {
            return
        }

        fail("Should throw NotFullNameException!")
    }

    @Test fun `requires phone number`() {
        try {
            Candidate("Maciej Najbar", PhoneNumber(""))
        } catch (ignored: IncorrectPhoneNumberException) {
            return
        }

        fail("Should throw PhoneNumberMissingException")
    }

    @Test fun `adds phone number to contact numbers list`() {
        val phoneNumber = PhoneNumber("+48123456789")
        val candidate = Candidate("Maciej Najbar", phoneNumber)

        assertTrue(candidate.contactNumbers.contains(phoneNumber))
    }

    @Test fun `adds additional numbers to contact list`() {
        val phoneNumber = PhoneNumber("+48123456789")
        val contactNumber = PhoneNumber("+48123123123")
        val candidate = Candidate("Maciej Najbar", phoneNumber)

        candidate.addContactNumber(contactNumber)

        assertTrue(candidate.contactNumbers.contains(contactNumber))
    }
}