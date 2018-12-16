package com.gmail.najbar.maciek.candidateassessment.repository

import com.gmail.najbar.maciek.candidateassessment.repository.mapper.MemoryCandidatesDatabase
import com.gmail.najbar.maciek.candidateassessment.repository.exception.NoSuchCandidateException
import com.gmail.najbar.maciek.candidateassessment.usecase.Candidate

class CandidateAssessRepository(private val database: MemoryCandidatesDatabase) : Candidate.Assess.Repository {
    override fun assess(candidateId: String, value: String) =
            try {
                val candidate = database.getById(candidateId)
                database.update(candidateId, candidate.copy(grade = value))
            } catch (ignored: NullPointerException) {
                throw NoSuchCandidateException()
            }
}