package com.gmail.najbar.maciek.candidateassessment.app

import com.gmail.najbar.maciek.candidateassessment.usecase.Candidate

class OpenDetailsScreenPresenter(
        private val view: View) : Candidate.OpenDetailsScreen.Presenter {

    override fun present(candidateId: String) {
        view.showDetailsFor(candidateId)
    }

    /**
     * Shows candidate's details.
     */
    interface View {

        /**
         * Shows candidate's details.
         *
         * @param   candidateId Candidate's ID.
         */
        fun showDetailsFor(candidateId: String)
    }
}