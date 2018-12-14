package com.gmail.najbar.maciek.candidateassessment.database

import org.junit.Assert.assertEquals
import org.junit.Test

class MemoryCandidatesDatabaseTest {

    @Test fun `gets all candidates`() {
        val chandlerBing = MemoryCandidatesDatabase.DbCandidate("Chandler Bing", listOf("+48123123123", "+48321321321"))
        val rossGeller = MemoryCandidatesDatabase.DbCandidate("Ross Geller", listOf("+48123456789"))
        MemoryCandidatesDatabase
                .update(chandlerBing.name, chandlerBing.phoneNumbers[0], chandlerBing.phoneNumbers[1])
        MemoryCandidatesDatabase
                .update(rossGeller.name, rossGeller.phoneNumbers[0])

        assertEquals(listOf(chandlerBing, rossGeller), MemoryCandidatesDatabase.getAll())
    }
}