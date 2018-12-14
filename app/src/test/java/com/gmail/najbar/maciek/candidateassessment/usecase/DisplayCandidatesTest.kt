package com.gmail.najbar.maciek.candidateassessment.usecase

import com.gmail.najbar.maciek.candidateassessment.domain.Candidate
import com.gmail.najbar.maciek.candidateassessment.domain.CandidateFactory
import com.gmail.najbar.maciek.candidateassessment.repository.DisplayCandidatesRepository
import org.junit.Assert.assertEquals
import org.junit.Test

class DisplayCandidatesTest {

    @Test fun `displays all candidates displayed from repository`() {
        val listOfAllCandidates = listOf(
                CandidateFactory.from("Chandler Bing", "+48123456789"),
                CandidateFactory.from("Ross Geller", "+48123123123"),
                CandidateFactory.from("Joey Tribbiani", "+48111111111"))

        val presenter = object : Candidates.DisplayCandidates.Presenter {
            override fun present(candidates: Collection<Candidate>) {
                assertEquals(listOfAllCandidates, candidates)
            }
        }

        DisplayCandidates(presenter, DisplayCandidatesRepository())
                .all()
    }
}