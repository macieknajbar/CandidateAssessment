package com.gmail.najbar.maciek.candidateassessment.usecase

import com.gmail.najbar.maciek.candidateassessment.domain.Assessment
import com.gmail.najbar.maciek.candidateassessment.domain.CandidateEntity
import com.gmail.najbar.maciek.candidateassessment.repository.exception.NoSuchCandidateException

/**
 * Wrapping interface for list of candidates use cases.
 */
interface Candidate {

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

        data class Candidate(val id: String, val name: String, val phoneNumbers: Collection<String>) {
            internal companion object {
                fun from(candidate: CandidateEntity) = Candidate(candidate.id, candidate.fullName, candidate.contactNumbers.map { it.phoneNumber })
            }
        }

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
            fun findByName(name: String) : Collection<CandidateEntity>
        }
    }

    /**
     * Opens candidate's details screen.
     */
    interface OpenDetailsScreen {

        /**
         * Goes to details screen.
         *
         * @param   candidateId Candidate's ID.
         */
        fun go(candidateId: String)

        /**
         * Presents candidate's details screen.
         */
        interface Presenter {

            /**
             * Presents screen for specified candidate.
             *
             * @param   candidateId Candidate's ID.
             */
            fun present(candidateId: String)
        }
    }

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

        data class Candidate(val id: String, val fullName: String, val phoneNumbers: Collection<String>, val grade: String) {
            companion object {
                fun from(candidateEntity: CandidateEntity) = Candidate(candidateEntity.id, candidateEntity.fullName, candidateEntity.contactNumbers.map { it.phoneNumber }, candidateEntity.grade?.name ?: "")
            }
        }

        /**
         * Presents candidate's details.
         */
        interface Presenter {

            /**
             * Presents details of candidates.
             */
            fun present(candidate: Candidate)
        }

        /**
         * Retrieves candidate's details from database.
         */
        interface Repository {

            /**
             * Retrieves information about a candidate.
             *
             * @param   candidateId Candidate's ID.
             *
             * @throws  NoSuchCandidateException if there's no candidate with provided id.
             *
             * @return Candidate's details information.
             */
            @Throws(NoSuchCandidateException::class)
            fun about(candidateId: String) : CandidateEntity
        }
    }

    /**
     * Assesses candidates.
     */
    interface Assess {

        /**
         * Values assessment for a candidate.
         *
         * @param   candidateId Candidate's id.
         * @param   value Assessment value.
         */
        fun value(candidateId: String, value: String)

        /**
         * Presents assessed value.
         */
        interface Presenter {

            /**
             * Presents assessment.
             *
             * @param   value Assessment value.
             */
            fun present(value: String)
        }

        /**
         * Saves assessment in repository.
         */
        interface Repository {

            /**
             * Saves assessment value in database.
             *
             * @param   candidateId Candidate's ID.
             * @param   value Candidate's rate.
             */
            @Throws(NoSuchCandidateException::class)
            fun assess(candidateId: String, value: String)
        }
    }
}