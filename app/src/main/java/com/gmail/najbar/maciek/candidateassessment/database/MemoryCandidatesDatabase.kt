package com.gmail.najbar.maciek.candidateassessment.database

import java.util.UUID

class MemoryCandidatesDatabase {
    private val candidateTable = mutableMapOf<String, String>()
    private val phoneNumberTable = mutableMapOf<String, List<String>>()

    data class DbCandidate(val name: String, val phoneNumbers: List<String>)

    fun getAll(): Collection<DbCandidate> {
        return candidateTable.flatMap {
            listOf(DbCandidate(it.value, phoneNumberTable[it.key] as List<String>))
        }
    }

    fun update(name: String, vararg phoneNumbers: String) {
        val candidate = candidateTable.filter { it.value == name }
        val id = when (candidate.isEmpty()) {
            true -> UUID.randomUUID().toString()
            false -> candidate.keys.first()
        }
        candidateTable[id] = name
        phoneNumberTable[id] = phoneNumbers.toList()
    }
}