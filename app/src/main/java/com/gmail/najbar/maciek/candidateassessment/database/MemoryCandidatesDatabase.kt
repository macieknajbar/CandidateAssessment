package com.gmail.najbar.maciek.candidateassessment.database

class MemoryCandidatesDatabase {
    private val candidateTable = mutableMapOf<String, Map<String, String?>>()
    private val phoneNumberTable = mutableMapOf<String, List<String>>()

    data class DbCandidate(val id: String, val name: String, val phoneNumbers: List<String>, val grade: String? = null)

    fun getAll(): Collection<DbCandidate> {
        return candidateTable.flatMap {
            listOf(DbCandidate(it.key, it.value[COL_NAME]!!, phoneNumberTable[it.key] as List<String>, it.value[COL_GRADE]))
        }
    }

    fun update(id: String, candidate: DbCandidate) {
        candidateTable[id] = mapOf(COL_NAME to candidate.name, COL_GRADE to candidate.grade)
        phoneNumberTable[id] = candidate.phoneNumbers
    }

    fun getById(candidateId: String): DbCandidate =
            DbCandidate(candidateId, candidateTable[candidateId]!![COL_NAME]!!, phoneNumberTable[candidateId] as List<String>, candidateTable[candidateId]!![COL_GRADE])

    companion object {
        private const val COL_NAME = "name"
        private const val COL_GRADE = "grade"
    }
}