package com.gmail.najbar.maciek.candidateassessment.repository.mapper

import com.gmail.najbar.maciek.candidateassessment.domain.CandidateEntity
import com.gmail.najbar.maciek.candidateassessment.domain.PhoneNumberEntity
import com.gmail.najbar.maciek.candidateassessment.repository.mapper.MemoryCandidatesDatabase
import org.junit.Assert.assertEquals
import org.junit.Test

class MemoryCandidatesDatabaseTest {

    private val memoryCandidateDatabase = MemoryCandidatesDatabase()

    @Test fun `gets all candidates`() {
        val chandlerBing = CandidateEntity("1", "Chandler Bing", listOf(PhoneNumberEntity("+48123123123"), PhoneNumberEntity("+48321321321")), "")
        val rossGeller = CandidateEntity("2", "Ross Geller", listOf(PhoneNumberEntity("+48123456789")), "")
        memoryCandidateDatabase.update(chandlerBing.id, chandlerBing)
        memoryCandidateDatabase.update(rossGeller.id, rossGeller)

        assertEquals(listOf(chandlerBing, rossGeller), memoryCandidateDatabase.getAll())
    }

    @Test fun `updates candidate that is already saved`() {
        val joeyTribbiani = CandidateEntity("1", "Joey Tribbiani", listOf(PhoneNumberEntity("+48111111111")), "")
        memoryCandidateDatabase.update(joeyTribbiani.id, joeyTribbiani)

        val updatedJoey = CandidateEntity("1", "Joseph Tribbiani", listOf(PhoneNumberEntity("+48222222222")), "B")
        memoryCandidateDatabase.update(updatedJoey.id, updatedJoey)

        assertEquals(listOf(updatedJoey), memoryCandidateDatabase.getAll())
    }

    @Test fun `gets candidate id`() {
        val candidateId = "Some_id"
        val phoebeBuffet = CandidateEntity(candidateId, "Phoebe Buffet", listOf(PhoneNumberEntity("+48987654321")), "")
        memoryCandidateDatabase.update(phoebeBuffet.id, phoebeBuffet)

        assertEquals(phoebeBuffet, memoryCandidateDatabase.getById(candidateId))
    }
}