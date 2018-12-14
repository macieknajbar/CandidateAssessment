package com.gmail.najbar.maciek.candidateassessment.usecase

class DisplayCandidates(
        private val presenter: Candidates.DisplayCandidates.Presenter,
        private val repository: Candidates.DisplayCandidates.Repository) : Candidates.DisplayCandidates {

    override fun all() {
        presenter.present(listOf())
    }
}