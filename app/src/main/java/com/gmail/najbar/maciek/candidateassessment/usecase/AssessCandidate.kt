package com.gmail.najbar.maciek.candidateassessment.usecase

class AssessCandidate(
        private val presenter: Candidate.Assess.Presenter,
        private val repository: Candidate.Assess.Repository) : Candidate.Assess {

    override fun value(candidateId: String, value: String) {
        presenter.present(value)
        repository.assess(candidateId, value)
    }
}