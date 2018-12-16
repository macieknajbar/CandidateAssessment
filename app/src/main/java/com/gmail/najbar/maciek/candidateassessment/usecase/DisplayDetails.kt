package com.gmail.najbar.maciek.candidateassessment.usecase

class DisplayDetails(
        private val presenter: Candidate.DisplayDetails.Presenter,
        private val repository: Candidate.DisplayDetails.Repository) : Candidate.DisplayDetails {

    override fun of(candidateId: String) {
        presenter.present(Candidate.DisplayDetails.Candidate("", "", listOf()))
    }
}