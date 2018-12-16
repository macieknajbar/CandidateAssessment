package com.gmail.najbar.maciek.candidateassessment.repository

import com.gmail.najbar.maciek.candidateassessment.database.MemoryCandidatesDatabase
import com.gmail.najbar.maciek.candidateassessment.domain.CandidateEntity
import com.gmail.najbar.maciek.candidateassessment.domain.PhoneNumberEntity
import com.gmail.najbar.maciek.candidateassessment.usecase.Candidate

class DisplayCandidateDetailsMemoryRepository(private val database: MemoryCandidatesDatabase) : Candidate.DisplayDetails.Repository {
    override fun about(candidateId: String): CandidateEntity {
        val candidate = database.getById(candidateId)
        return CandidateEntity(candidate.id, candidate.name, candidate.phoneNumbers.map { PhoneNumberEntity(it) })
    }
}