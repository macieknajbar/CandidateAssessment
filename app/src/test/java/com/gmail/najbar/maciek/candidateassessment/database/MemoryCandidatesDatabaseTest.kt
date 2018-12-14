package com.gmail.najbar.maciek.candidateassessment.database

import org.junit.Assert.assertEquals
import org.junit.Test

class MemoryCandidatesDatabaseTest {

    private val memoryCandidateDatabase = MemoryCandidatesDatabase()

    @Test fun `gets all candidates`() {
        val chandlerBing = MemoryCandidatesDatabase.DbCandidate("Chandler Bing", listOf("+48123123123", "+48321321321"))
        val rossGeller = MemoryCandidatesDatabase.DbCandidate("Ross Geller", listOf("+48123456789"))
        memoryCandidateDatabase
                .update(chandlerBing.name, chandlerBing.phoneNumbers[0], chandlerBing.phoneNumbers[1])
        memoryCandidateDatabase
                .update(rossGeller.name, rossGeller.phoneNumbers[0])

        assertEquals(listOf(chandlerBing, rossGeller), memoryCandidateDatabase.getAll())
    }

    @Test fun `updates candidate that is already saved`() {
        val joeyTribbiani = MemoryCandidatesDatabase.DbCandidate("Joey Tribbiani", listOf("+48111111111"))
        memoryCandidateDatabase.update(joeyTribbiani.name, joeyTribbiani.phoneNumbers[0])

        val updatedJoey = MemoryCandidatesDatabase.DbCandidate(joeyTribbiani.name, listOf("+48222222222"))
        memoryCandidateDatabase.update(updatedJoey.name, updatedJoey.phoneNumbers[0])

        assertEquals(listOf(updatedJoey), memoryCandidateDatabase.getAll())
    }
}