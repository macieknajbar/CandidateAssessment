package com.gmail.najbar.maciek.candidateassessment.usecase

import org.junit.Assert.assertEquals
import org.junit.Test

class AssessCandidateTest {

    @Test fun `assesses a candidate`() {
        val assessmentValue = "A"

        val presenter = object : Candidate.Assess.Presenter {
            override fun present(value: String) {
                assertEquals(assessmentValue, value)
            }
        }

        AssessCandidate(presenter)
                .value(assessmentValue)
    }
}