package com.gmail.najbar.maciek.candidateassessment.repository

import com.gmail.najbar.maciek.candidateassessment.domain.CandidateFactory
import org.junit.Assert.assertEquals
import org.junit.Test

class DisplayCandidatesRepositoryTest {

    init {
        MemoryRepositoryOfDisplayCandidates.db
                .update("Monica Geller", "+48111222333")
        MemoryRepositoryOfDisplayCandidates.db
                .update("Rachel Green", "+48444555666")
    }

    @Test fun `retrieves all candidates`() {
        val repository = MemoryRepositoryOfDisplayCandidates()

        val expected = listOf(
                CandidateFactory.from("Monica Geller", "+48111222333"),
                CandidateFactory.from("Rachel Green", "+48444555666"))

        assertEquals(expected, repository.findByName(""))
    }
}