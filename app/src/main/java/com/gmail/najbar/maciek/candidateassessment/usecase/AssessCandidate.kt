package com.gmail.najbar.maciek.candidateassessment.usecase

class AssessCandidate(
        private val presenter: Candidate.Assess.Presenter) : Candidate.Assess {

    override fun value(value: String) {
        presenter.present("")
    }
}