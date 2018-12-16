package com.gmail.najbar.maciek.candidateassessment.usecase

import com.gmail.najbar.maciek.candidateassessment.MemoryCandidatesDatabase
import com.gmail.najbar.maciek.candidateassessment.domain.Assessment
import com.gmail.najbar.maciek.candidateassessment.domain.CandidateEntity
import com.gmail.najbar.maciek.candidateassessment.domain.PhoneNumberEntity
import com.gmail.najbar.maciek.candidateassessment.repository.DisplayCandidateDetailsMemoryRepository
import org.junit.Assert.assertEquals
import org.junit.Test

class DisplayDetailsTest {

    private val memoryCandidatesDatabase = MemoryCandidatesDatabase()

    @Test fun `displays candidate details`() {
        val candidateId = "candidateId"
        val name = "Some Guy"
        val phones = listOf("+48123123123", "+48123456789")
        val grade = "D"
        memoryCandidatesDatabase.update(candidateId, CandidateEntity(candidateId, name, phones.map { no -> PhoneNumberEntity(no) }, Assessment.valueOf(grade)))

        val presenter = object : Candidate.DisplayDetails.Presenter {
            override fun present(candidate: Candidate.DisplayDetails.Candidate) {
                assertEquals(candidateId, candidate.id)
                assertEquals(name, candidate.fullName)
                assertEquals(phones, candidate.phoneNumbers)
                assertEquals(grade, candidate.grade)
            }
        }

        DisplayDetails(presenter, DisplayCandidateDetailsMemoryRepository(memoryCandidatesDatabase))
                .of(candidateId)
    }
}