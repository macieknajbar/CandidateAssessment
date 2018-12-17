package com.gmail.najbar.maciek.candidateassessment.usecase

class OpenDetailsScreen(
        private val presenter: Candidate.OpenDetailsScreen.Presenter) : Candidate.OpenDetailsScreen {

    override fun go(candidateId: String) {
        presenter.present(candidateId)
    }
}