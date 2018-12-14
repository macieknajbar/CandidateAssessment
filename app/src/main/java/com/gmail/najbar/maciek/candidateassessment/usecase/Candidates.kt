package com.gmail.najbar.maciek.candidateassessment.usecase

import com.gmail.najbar.maciek.candidateassessment.domain.Candidate

/**
 * Wrapping interface for list of candidates use cases.
 */
interface Candidates {

    /**
     * Displays list of candidates.
     */
    interface DisplayCandidates {

        /**
         * Displays all candidates.
         */
        fun all()

        /**
         * Presents results.
         */
        interface Presenter {

            fun present(candidates: Collection<Candidate>)
        }

        /**
         * Retrieves candidates.
         */
        interface Repository {

            /**
             * Finds by full name.
             */
            fun findByName(name: String) : Collection<Candidate>
        }
    }
}