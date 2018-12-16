package com.gmail.najbar.maciek.candidateassessment.repository

import com.gmail.najbar.maciek.candidateassessment.database.MemoryCandidatesDatabase
import com.gmail.najbar.maciek.candidateassessment.usecase.Candidate

class CandidateAssessRepository(database: MemoryCandidatesDatabase) : Candidate.Assess.Repository {
    override fun assess(candidateId: String, value: String) {

    }
}