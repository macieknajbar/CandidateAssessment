package com.gmail.najbar.maciek.candidateassessment.usecase

import com.gmail.najbar.maciek.candidateassessment.database.MemoryCandidatesDatabase
import com.gmail.najbar.maciek.candidateassessment.domain.CandidateEntity
import com.gmail.najbar.maciek.candidateassessment.domain.CandidateFactory
import com.gmail.najbar.maciek.candidateassessment.repository.MemoryRepositoryOfDisplayCandidates
import org.junit.Assert.assertEquals
import org.junit.Test

class DisplayCandidatesTest {

    @Test fun `displays all candidates from repository`() {
        val memoryCandidateDatabase = MemoryCandidatesDatabase()
        val listOfAllCandidates = listOf(
                Candidates.DisplayCandidates.Candidate("1", "Chandler Bing", listOf("+48123456789")),
                Candidates.DisplayCandidates.Candidate("2", "Ross Geller", listOf("+48123123123")),
                Candidates.DisplayCandidates.Candidate("3", "Joey Tribbiani", listOf("+48111111111")))
        listOfAllCandidates.forEach {
            memoryCandidateDatabase.update(it.id, MemoryCandidatesDatabase.DbCandidate(it.id, it.name, it.phoneNumbers.toList()))
        }

        val presenter = object : Candidates.DisplayCandidates.Presenter {
            override fun present(candidates: Collection<Candidates.DisplayCandidates.Candidate>) {
                assertEquals(listOfAllCandidates, candidates)
            }
        }

        DisplayCandidates(presenter, MemoryRepositoryOfDisplayCandidates(memoryCandidateDatabase))
                .all()
    }

    @Test fun `displays filtered candidates  by name`() {
        val memoryCandidateDatabase = MemoryCandidatesDatabase()
        val listOfAllCandidates = listOf(
                Candidates.DisplayCandidates.Candidate("1", "Monica Geller", listOf("+48123456789")),
                Candidates.DisplayCandidates.Candidate("2", "Monica Bing", listOf("+48123123123")),
                Candidates.DisplayCandidates.Candidate("3", "Rachel Green", listOf("+48111111111")))
        listOfAllCandidates.forEach {
            memoryCandidateDatabase.update(it.id, MemoryCandidatesDatabase.DbCandidate(it.id, it.name, it.phoneNumbers.toList()))
        }

        val presenter = object : Candidates.DisplayCandidates.Presenter {
            override fun present(candidates: Collection<Candidates.DisplayCandidates.Candidate>) {
                val expected = listOf(
                        Candidates.DisplayCandidates.Candidate("1", "Monica Geller", listOf("+48123456789")),
                        Candidates.DisplayCandidates.Candidate("2", "Monica Bing", listOf("+48123123123")))
                assertEquals(expected, candidates)
            }
        }

        DisplayCandidates(presenter, MemoryRepositoryOfDisplayCandidates(memoryCandidateDatabase))
                .withName("Monica")
    }
}