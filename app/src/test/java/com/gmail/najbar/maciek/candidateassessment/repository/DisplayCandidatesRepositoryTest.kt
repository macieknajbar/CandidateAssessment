package com.gmail.najbar.maciek.candidateassessment.repository

import com.gmail.najbar.maciek.candidateassessment.domain.Assessment
import com.gmail.najbar.maciek.candidateassessment.domain.CandidateEntity
import com.gmail.najbar.maciek.candidateassessment.domain.PhoneNumberEntity
import com.gmail.najbar.maciek.candidateassessment.domain.factory.CandidateFactory
import com.gmail.najbar.maciek.candidateassessment.repository.mapper.MemoryCandidatesDatabase
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class DisplayCandidatesRepositoryTest {

    private val memoryCandidatesDatabase = MemoryCandidatesDatabase()

    @Before fun setUp() {
        memoryCandidatesDatabase.update("1", CandidateEntity("1", "Monica Geller", listOf(PhoneNumberEntity("+48111222333")), Assessment.A))
        memoryCandidatesDatabase.update("2", CandidateEntity("2", "Rachel Green", listOf(PhoneNumberEntity("+48444555666")), Assessment.D))
    }

    @Test fun `retrieves all candidates`() {
        val repository = MemoryRepositoryOfDisplayCandidates(memoryCandidatesDatabase)

        val expected = listOf(
                CandidateEntity("1", "Monica Geller", listOf(PhoneNumberEntity("+48111222333")), Assessment.A),
                CandidateEntity("2", "Rachel Green", listOf(PhoneNumberEntity("+48444555666")), Assessment.D))

        assertEquals(expected, repository.findByName(""))
    }
}