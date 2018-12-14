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
         * Displays candidates filtered by name.
         *
         * @param   name Part of the name.
         */
        fun withName(name: String)

        /**
         * Presents results.
         */
        interface Presenter {

            /**
             * Presents collection of candidates.
             *
             * @param   candidates Collection of candidates.
             */
            fun present(candidates: Collection<Candidate>)
        }

        /**
         * Retrieves candidates.
         */
        interface Repository {

            /**
             * Finds by full name.
             *
             * @param   name Searching phrase.
             *
             * @return Filtered collection of candidates.
             */
            fun findByName(name: String) : Collection<Candidate>
        }
    }
}