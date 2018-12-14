package com.gmail.najbar.maciek.candidateassessment.repository

import com.gmail.najbar.maciek.candidateassessment.database.MemoryCandidatesDatabase
import com.gmail.najbar.maciek.candidateassessment.domain.CandidateFactory
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class DisplayCandidatesRepositoryTest {

    private val memoryCandidatesDatabase = MemoryCandidatesDatabase()

    @Before fun setUp() {
        memoryCandidatesDatabase.update("1", MemoryCandidatesDatabase.DbCandidate("1", "Monica Geller", listOf("+48111222333")))
        memoryCandidatesDatabase.update("2", MemoryCandidatesDatabase.DbCandidate("2", "Rachel Green", listOf("+48444555666")))
    }

    @Test fun `retrieves all candidates`() {
        val repository = MemoryRepositoryOfDisplayCandidates(memoryCandidatesDatabase)

        val expected = listOf(
                CandidateFactory.from("1", "Monica Geller", "+48111222333"),
                CandidateFactory.from("2", "Rachel Green", "+48444555666"))

        assertEquals(expected, repository.findByName(""))
    }
}