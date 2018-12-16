package com.gmail.najbar.maciek.candidateassessment.app

import com.gmail.najbar.maciek.candidateassessment.usecase.Candidate

class DisplayCandidatesPresenter(
        private val view: View) : Candidate.DisplayCandidates.Presenter {
    override fun present(candidates: Collection<Candidate.DisplayCandidates.Candidate>) {
        view.displayCandidates(candidates.map { it.name })
    }

    interface View {
        fun displayCandidates(names: Collection<String>)
    }
}