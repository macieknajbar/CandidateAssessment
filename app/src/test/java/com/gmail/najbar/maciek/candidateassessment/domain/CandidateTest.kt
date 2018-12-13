package com.gmail.najbar.maciek.candidateassessment.domain

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
        } catch (ignored: PhoneNumberMissingException) {
            return
        }

        fail("Should throw PhoneNumberMissingException")
    }
}