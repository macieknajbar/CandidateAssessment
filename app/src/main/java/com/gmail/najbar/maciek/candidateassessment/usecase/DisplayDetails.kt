package com.gmail.najbar.maciek.candidateassessment.usecase

import com.gmail.najbar.maciek.candidateassessment.repository.exception.NoSuchCandidateException
import java.util.UUID

class DisplayDetails(
        private val presenter: Candidate.DisplayDetails.Presenter,
        private val repositoryDisplayDetails: Candidate.DisplayDetails.Repository) : Candidate.DisplayDetails {

    override fun of(candidateId: String) {
        try {
            val candidate = repositoryDisplayDetails.about(candidateId)
            presenter.present(Candidate.DisplayDetails.Candidate.from(candidate))
        } catch (ignored: NoSuchCandidateException) {
            presenter.present(Candidate.DisplayDetails.Candidate(UUID.randomUUID().toString(), "", listOf(), ""))
        }
    }
}