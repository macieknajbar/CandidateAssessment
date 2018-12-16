package com.gmail.najbar.maciek.candidateassessment.app

import com.gmail.najbar.maciek.candidateassessment.usecase.Candidate

class DisplayDetailsPresenter(
        private val view: View) : Candidate.DisplayDetails.Presenter {

    override fun present(candidate: Candidate.DisplayDetails.Candidate) {
        view.displayName(candidate.fullName)
        view.displayPhoneNumbers(candidate.phoneNumbers)
        view.displayAssessment(candidate.grade)
    }

    interface View {
        fun displayName(name: String)
        fun displayPhoneNumbers(contactNumbers: Collection<String>)
        fun displayAssessment(value: String)
    }
}