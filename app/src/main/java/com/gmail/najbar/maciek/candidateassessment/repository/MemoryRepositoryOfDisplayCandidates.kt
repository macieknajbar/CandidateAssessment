package com.gmail.najbar.maciek.candidateassessment.repository

import com.gmail.najbar.maciek.candidateassessment.repository.mapper.MemoryCandidatesDatabase
import com.gmail.najbar.maciek.candidateassessment.domain.CandidateEntity
import com.gmail.najbar.maciek.candidateassessment.domain.PhoneNumberEntity
import com.gmail.najbar.maciek.candidateassessment.usecase.Candidate

class MemoryRepositoryOfDisplayCandidates(
        private val database: MemoryCandidatesDatabase) : Candidate.DisplayCandidates.Repository {

    override fun findByName(name: String): Collection<CandidateEntity> {
        val dbCandidates = database.getAll()
        return dbCandidates
                .filter { it.fullName.contains(name) }
    }
}