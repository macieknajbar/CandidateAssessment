package com.gmail.najbar.maciek.candidateassessment.repository

import com.gmail.najbar.maciek.candidateassessment.database.MemoryCandidatesDatabase
import com.gmail.najbar.maciek.candidateassessment.domain.CandidateEntity
import com.gmail.najbar.maciek.candidateassessment.domain.PhoneNumberEntity
import com.gmail.najbar.maciek.candidateassessment.repository.exception.NoSuchCandidateException
import com.gmail.najbar.maciek.candidateassessment.usecase.Candidate

class DisplayCandidateDetailsMemoryRepository(private val database: MemoryCandidatesDatabase) : Candidate.DisplayDetails.Repository {
    override fun about(candidateId: String): CandidateEntity =
            try {
                val candidate = database.getById(candidateId)
                CandidateEntity(candidate.id, candidate.name, candidate.phoneNumbers.map { PhoneNumberEntity(it) })
            } catch (ignored: NullPointerException) {
                throw NoSuchCandidateException()
            }
}