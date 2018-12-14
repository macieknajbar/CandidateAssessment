package com.gmail.najbar.maciek.candidateassessment.repository

import com.gmail.najbar.maciek.candidateassessment.database.MemoryCandidatesDatabase
import com.gmail.najbar.maciek.candidateassessment.domain.Candidate
import com.gmail.najbar.maciek.candidateassessment.domain.PhoneNumber
import com.gmail.najbar.maciek.candidateassessment.usecase.Candidates

class MemoryRepositoryOfDisplayCandidates : Candidates.DisplayCandidates.Repository {

    companion object {
        val db = MemoryCandidatesDatabase()
    }

    override fun findByName(name: String): Collection<Candidate> {
        val dbCandidates = db.getAll()
        return dbCandidates
                .flatMap {
                    listOf(Candidate(it.name, it.phoneNumbers
                            .flatMap {
                                phoneNumber -> listOf(PhoneNumber(phoneNumber))
                            }))
                }
    }
}