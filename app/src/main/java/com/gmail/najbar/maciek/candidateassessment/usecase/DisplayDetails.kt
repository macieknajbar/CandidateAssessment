package com.gmail.najbar.maciek.candidateassessment.usecase

class DisplayDetails(
        private val presenter: Candidate.DisplayDetails.Presenter,
        private val repositoryDisplayDetails: Candidate.DisplayDetails.Repository) : Candidate.DisplayDetails {

    override fun of(candidateId: String) {
        val candidate = repositoryDisplayDetails.about(candidateId)
        presenter.present(Candidate.DisplayDetails.Candidate.from(candidate))
    }
}