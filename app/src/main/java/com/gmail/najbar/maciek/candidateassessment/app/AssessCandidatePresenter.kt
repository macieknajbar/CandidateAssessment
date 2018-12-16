package com.gmail.najbar.maciek.candidateassessment.app

import com.gmail.najbar.maciek.candidateassessment.usecase.Candidate

class AssessCandidatePresenter(
        private val view: View) : Candidate.Assess.Presenter {

    override fun present(value: String) {
        view.changeGrade(value)
    }

    interface View {
        fun changeGrade(value: String)
    }
}