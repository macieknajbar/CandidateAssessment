package com.gmail.najbar.maciek.candidateassessment.usecase

import com.gmail.najbar.maciek.candidateassessment.repository.exception.NoSuchCandidateException

class AssessCandidate(
        private val presenter: Candidate.Assess.Presenter,
        private val repository: Candidate.Assess.Repository) : Candidate.Assess {

    override fun value(candidateId: String, value: String) {
        presenter.present(value)
        try {
            repository.assess(candidateId, value)
        } catch (ignored: NoSuchCandidateException) {
            presenter.present("")
        }
    }
}