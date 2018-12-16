package com.gmail.najbar.maciek.candidateassessment

import com.gmail.najbar.maciek.candidateassessment.domain.factory.CandidateFactory
import com.gmail.najbar.maciek.candidateassessment.repository.mapper.MemoryCandidatesDatabase

object MemoryDatabase {
    val memoryCandidatesDatabase = MemoryCandidatesDatabase()

    init {
        memoryCandidatesDatabase.update("1", CandidateFactory.from("1", "Monica Geller", "+48123456789"))
        memoryCandidatesDatabase.update("2", CandidateFactory.from("2", "Rachel Green", "+48123123123"))
        memoryCandidatesDatabase.update("3", CandidateFactory.from("3", "Phoebe Buffet", "+48111111111"))
    }
}