package com.gmail.najbar.maciek.candidateassessment.database

import org.junit.Assert.assertEquals
import org.junit.Test

class MemoryCandidatesDatabaseTest {

    private val memoryCandidateDatabase = MemoryCandidatesDatabase()

    @Test fun `gets all candidates`() {
        val chandlerBing = MemoryCandidatesDatabase.DbCandidate("1", "Chandler Bing", listOf("+48123123123", "+48321321321"))
        val rossGeller = MemoryCandidatesDatabase.DbCandidate("2", "Ross Geller", listOf("+48123456789"))
        memoryCandidateDatabase.update(chandlerBing.id, chandlerBing)
        memoryCandidateDatabase.update(rossGeller.id, rossGeller)

        assertEquals(listOf(chandlerBing, rossGeller), memoryCandidateDatabase.getAll())
    }

    @Test fun `updates candidate that is already saved`() {
        val joeyTribbiani = MemoryCandidatesDatabase.DbCandidate("1", "Joey Tribbiani", listOf("+48111111111"))
        memoryCandidateDatabase.update(joeyTribbiani.id, joeyTribbiani)

        val updatedJoey = MemoryCandidatesDatabase.DbCandidate("1", "Joseph Tribbiani", listOf("+48222222222"), "B")
        memoryCandidateDatabase.update(updatedJoey.id, updatedJoey)

        assertEquals(listOf(updatedJoey), memoryCandidateDatabase.getAll())
    }

    @Test fun `gets candidate id`() {
        val candidateId = "Some_id"
        val phoebeBuffet = MemoryCandidatesDatabase.DbCandidate(candidateId, "Phoebe Buffet", listOf("+48987654321"))
        memoryCandidateDatabase.update(phoebeBuffet.id, phoebeBuffet)

        assertEquals(phoebeBuffet, memoryCandidateDatabase.getById(candidateId))
    }
}