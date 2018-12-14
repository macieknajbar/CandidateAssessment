package com.gmail.najbar.maciek.candidateassessment.domain

import com.gmail.najbar.maciek.candidateassessment.domain.exceptions.IncorrectPhoneNumberException
import com.gmail.najbar.maciek.candidateassessment.domain.exceptions.NotFullNameException
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Assert.fail
import org.junit.Test

class CandidateTest {

    @Test fun `requires full name`() {
        try {
            CandidateFactory.from("1", "Maciej", "+48123456789")
        } catch (ignored: NotFullNameException) {
            return
        }

        fail("Should throw NotFullNameException!")
    }

    @Test fun `requires phone number`() {
        try {
            CandidateFactory.from("1", "Maciej Najbar", "")
        } catch (ignored: IncorrectPhoneNumberException) {
            return
        }

        fail("Should throw PhoneNumberMissingException")
    }

    @Test fun `adds phone number to contact numbers list`() {
        val phoneNumber = "+48123456789"
        val candidate = CandidateFactory.from("1", "Maciej Najbar", phoneNumber)

        assertTrue(candidate.contactNumbers.contains(PhoneNumberEntity(phoneNumber)))
    }

    @Test fun `adds additional numbers to contact list`() {
        val candidate = CandidateFactory.from("1", "Maciej Najbar", "+48123456789")
        val contactNumber = PhoneNumberEntity("+48123123123")

        candidate.addContactNumber(contactNumber)

        assertTrue(candidate.contactNumbers.contains(contactNumber))
    }

    @Test fun `equals same`() {
        val candidate1 = CandidateFactory.from("1", "Maciej Najbar", "+48123123123")
        val candidate2 = CandidateFactory.from("1", "Maciej Najbar", "+48123123123")

        assertEquals(candidate1, candidate2)
    }
}