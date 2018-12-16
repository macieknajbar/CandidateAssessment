package com.gmail.najbar.maciek.candidateassessment.repository

import com.gmail.najbar.maciek.candidateassessment.database.MemoryCandidatesDatabase
import com.gmail.najbar.maciek.candidateassessment.domain.CandidateEntity
import com.gmail.najbar.maciek.candidateassessment.domain.PhoneNumberEntity
import com.gmail.najbar.maciek.candidateassessment.usecase.Candidate

class MemoryRepositoryOfDisplayCandidates(
        private val database: MemoryCandidatesDatabase) : Candidate.DisplayCandidates.Repository {

    override fun findByName(name: String): Collection<CandidateEntity> {
        val dbCandidates = database.getAll()
        return dbCandidates
                .flatMap {
                    listOf(CandidateEntity(it.id, it.name, it.phoneNumbers
                            .flatMap {
                                phoneNumber -> listOf(PhoneNumberEntity(phoneNumber))
                            }))
                }
                .filter { it.fullName.contains(name) }
    }
}