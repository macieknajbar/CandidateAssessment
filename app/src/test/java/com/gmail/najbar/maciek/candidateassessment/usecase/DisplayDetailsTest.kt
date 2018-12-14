package com.gmail.najbar.maciek.candidateassessment.usecase

import org.junit.Test

class DisplayDetailsTest {

    @Test fun `displays candidate details`() {
        val presenter = object : CandidateDetails.DisplayDetails.Presenter {
            override fun present() {

            }
        }

        DisplayDetails()
                .of("candidateId")
    }
}