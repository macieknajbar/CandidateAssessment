package com.gmail.najbar.maciek.candidateassessment.repository

import com.gmail.najbar.maciek.candidateassessment.domain.CandidateEntity
import com.gmail.najbar.maciek.candidateassessment.domain.PhoneNumberEntity
import com.gmail.najbar.maciek.candidateassessment.repository.exception.NoSuchCandidateException
import com.gmail.najbar.maciek.candidateassessment.repository.mapper.Database
import com.gmail.najbar.maciek.candidateassessment.usecase.Candidate

class DisplayCandidateDetailsMemoryRepository(private val database: Database<CandidateEntity>) : Candidate.DisplayDetails.Repository {
    override fun about(candidateId: String): CandidateEntity =
            try {
                database.getById(candidateId)
            } catch (ignored: NullPointerException) {
                throw NoSuchCandidateException()
            }
}