package com.gmail.najbar.maciek.candidateassessment.usecase

interface CandidateDetails {

    /**
     * Displays candidates details.
     */
    interface DisplayDetails {

        /**
         * Displays details of candidate with specified id.
         *
         * @param   candidateId Candidate ID.
         */
        fun of(candidateId: String)

        /**
         * Presents candidate's details.
         */
        interface Presenter {

            fun present()
        }
    }
}