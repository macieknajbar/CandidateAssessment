package com.gmail.najbar.maciek.candidateassessment.repository.mapper

interface Database<T> {

    fun getAll(): Collection<T>

    fun update(id: String, candidate: T)

    fun getById(candidateId: String): T
}