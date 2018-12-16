package com.gmail.najbar.maciek.candidateassessment

import com.gmail.najbar.maciek.candidateassessment.domain.CandidateEntity
import com.gmail.najbar.maciek.candidateassessment.domain.PhoneNumberEntity
import com.gmail.najbar.maciek.candidateassessment.repository.mapper.Database

class MemoryCandidatesDatabase: Database<CandidateEntity> {
    private val candidateTable = mutableMapOf<String, Map<String, String?>>()
    private val phoneNumberTable = mutableMapOf<String, List<String>>()

    override fun getAll(): Collection<CandidateEntity> {
        return candidateTable.flatMap {
            listOf(CandidateEntity(it.key, it.value[COL_NAME]!!, (phoneNumberTable[it.key] as List<String>).map { no -> PhoneNumberEntity(no) }, it.value[COL_GRADE] ?: ""))
        }
    }

    override fun update(id: String, candidate: CandidateEntity) {
        candidateTable[id] = mapOf(COL_NAME to candidate.fullName, COL_GRADE to candidate.grade)
        phoneNumberTable[id] = candidate.contactNumbers.map { it.phoneNumber }
    }

    override fun getById(candidateId: String): CandidateEntity =
            CandidateEntity(
                    candidateId,
                    candidateTable[candidateId]!![COL_NAME]!!,
                    (phoneNumberTable[candidateId] as List<String>).map { PhoneNumberEntity(it) },
                    candidateTable[candidateId]!![COL_GRADE] ?: "")

    companion object {
        private const val COL_NAME = "name"
        private const val COL_GRADE = "grade"
    }
}