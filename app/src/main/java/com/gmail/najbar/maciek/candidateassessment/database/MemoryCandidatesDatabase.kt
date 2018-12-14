package com.gmail.najbar.maciek.candidateassessment.database

object MemoryCandidatesDatabase {
    private val candidateTable = mutableMapOf<String, String>()
    private val phoneNumberTable = mutableMapOf<String, List<String>>()

    data class DbCandidate(val name: String, val phoneNumbers: List<String>)

    fun getAll(): Collection<DbCandidate> {
        TODO()
    }

    fun update(name: String, vararg phoneNumbers: String) {

    }
}