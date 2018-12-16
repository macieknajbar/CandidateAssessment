package com.gmail.najbar.maciek.candidateassessment.usecase

import com.gmail.najbar.maciek.candidateassessment.domain.CandidateFactory
import com.gmail.najbar.maciek.candidateassessment.repository.CandidateAssessRepository
import com.gmail.najbar.maciek.candidateassessment.repository.mapper.MemoryCandidatesDatabase
import org.junit.Assert.assertEquals
import org.junit.Test

class AssessCandidateTest {

    private val memoryCandidatesDatabase = MemoryCandidatesDatabase()

    @Test fun `assesses a candidate`() {
        val assessmentValue = "A"

        val presenter = object : Candidate.Assess.Presenter {
            override fun present(value: String) {
                assertEquals(assessmentValue, value)
            }
        }
        val repository = object : Candidate.Assess.Repository {
            override fun assess(candidateId: String, value: String) {}
        }

        AssessCandidate(presenter, repository)
                .value("some_id", assessmentValue)
    }

    @Test fun `candidate's assessment is saved in repo`() {
        val candidateId = "candidateId"
        val assessmentValue = "B"
        memoryCandidatesDatabase.update(candidateId, CandidateFactory.from(candidateId, "Monica Bing", "+48123123123"))

        val presenter = object : Candidate.Assess.Presenter {
            override fun present(value: String) {}
        }

        AssessCandidate(presenter, CandidateAssessRepository(memoryCandidatesDatabase))
                .value(candidateId, assessmentValue)

        assertEquals(assessmentValue, memoryCandidatesDatabase.getById(candidateId).grade)
    }

    @Test fun `presents no-value if repository saving failed`() {
        val assessmentValue = "B"

        val presenter = object : Candidate.Assess.Presenter {
            override fun present(value: String) {
                if (assessmentValue != value) {
                    assertEquals("", value)
                }
            }
        }

        AssessCandidate(presenter, CandidateAssessRepository(memoryCandidatesDatabase))
                .value("candidateId", assessmentValue)
    }
}