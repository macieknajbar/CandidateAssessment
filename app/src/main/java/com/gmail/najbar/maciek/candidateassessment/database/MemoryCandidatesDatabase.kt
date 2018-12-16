package com.gmail.najbar.maciek.candidateassessment.database

class MemoryCandidatesDatabase {
    private val candidateTable = mutableMapOf<String, String>()
    private val phoneNumberTable = mutableMapOf<String, List<String>>()

    data class DbCandidate(val id: String, val name: String, val phoneNumbers: List<String>, val grade: String? = null)

    fun getAll(): Collection<DbCandidate> {
        return candidateTable.flatMap {
            listOf(DbCandidate(it.key, it.value, phoneNumberTable[it.key] as List<String>))
        }
    }

    fun update(id: String, candidate: DbCandidate) {
        candidateTable[id] = candidate.name
        phoneNumberTable[id] = candidate.phoneNumbers
    }

    fun getById(candidateId: String): DbCandidate =
            DbCandidate(candidateId, candidateTable[candidateId]!!, phoneNumberTable[candidateId] as List<String>)
}