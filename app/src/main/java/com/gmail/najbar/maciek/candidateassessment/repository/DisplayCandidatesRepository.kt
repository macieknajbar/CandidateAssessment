package com.gmail.najbar.maciek.candidateassessment.repository

import com.gmail.najbar.maciek.candidateassessment.domain.Candidate
import com.gmail.najbar.maciek.candidateassessment.usecase.Candidates

class DisplayCandidatesRepository : Candidates.DisplayCandidates.Repository {

    override fun findByName(name: String): Collection<Candidate> {
        TODO()
    }
}