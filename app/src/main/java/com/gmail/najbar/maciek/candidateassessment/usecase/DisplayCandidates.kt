package com.gmail.najbar.maciek.candidateassessment.usecase

class DisplayCandidates(
        private val presenter: Candidate.DisplayCandidates.Presenter,
        private val repository: Candidate.DisplayCandidates.Repository) : Candidate.DisplayCandidates {

    override fun all() {
        presenter.present(repository.findByName("").map { Candidate.DisplayCandidates.Candidate.from(it) })
    }

    override fun withName(name: String) {
        presenter.present(repository.findByName(name).map { Candidate.DisplayCandidates.Candidate.from(it) })
    }
}