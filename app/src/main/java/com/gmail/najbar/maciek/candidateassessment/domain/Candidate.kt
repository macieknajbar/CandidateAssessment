package com.gmail.najbar.maciek.candidateassessment.domain

class Candidate(val fullName: String) {

    init {
        if (fullName.split(' ').size < 2) throw NotFullNameException()
    }
}