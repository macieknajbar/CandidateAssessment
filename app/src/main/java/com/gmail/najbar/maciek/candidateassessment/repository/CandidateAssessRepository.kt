package com.gmail.najbar.maciek.candidateassessment.repository

import com.gmail.najbar.maciek.candidateassessment.database.MemoryCandidatesDatabase
import com.gmail.najbar.maciek.candidateassessment.usecase.Candidate

class CandidateAssessRepository(private val database: MemoryCandidatesDatabase) : Candidate.Assess.Repository {
    override fun assess(candidateId: String, value: String) {
        val candidate = database.getById(candidateId)
        database.update(candidateId, candidate.copy(grade = value))
    }
}