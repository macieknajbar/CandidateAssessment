package com.gmail.najbar.maciek.candidateassessment.usecase

import org.junit.Assert.assertEquals
import org.junit.Test

class OpenDetailsScreenTest {

    @Test fun `goes to details`() {
        val phoebeBuffet = "phoebeBuffet"

        val presenter = object : Candidate.OpenDetailsScreen.Presenter {
            override fun present(candidateId: String) {
                assertEquals(phoebeBuffet, candidateId)
            }
        }

        OpenDetailsScreen(presenter)
                .go(phoebeBuffet)
    }
}