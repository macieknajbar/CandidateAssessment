package com.gmail.najbar.maciek.candidateassessment

import android.content.Intent
import android.support.test.rule.ActivityTestRule
import com.gmail.najbar.maciek.candidateassessment.domain.factory.CandidateFactory
import com.gmail.najbar.maciek.candidateassessment.pages.MainPage
import org.junit.Rule
import org.junit.Test

class MainActivityTest {

    @get:Rule val rule = ActivityTestRule<MainActivity>(MainActivity::class.java)

    @Test fun displaysListOfUsers() {
        val chandlerBing = CandidateFactory.from("chandlerBing", "Chandler Bing", "+48111111111")
        val rossGeller = CandidateFactory.from("rossGeller", "Chandler Bing", "+48111111111")
        val joeyTribbiani = CandidateFactory.from("joeyTribbiani", "Chandler Bing", "+48111111111")
        MemoryDatabase.memoryCandidatesDatabase.update("candidate_0", chandlerBing)
        MemoryDatabase.memoryCandidatesDatabase.update("candidate_0", rossGeller)
        MemoryDatabase.memoryCandidatesDatabase.update("candidate_0", joeyTribbiani)

        rule.launchActivity(Intent())

        MainPage.confirmDisplayed(chandlerBing)
        MainPage.confirmDisplayed(rossGeller)
        MainPage.confirmDisplayed(joeyTribbiani)
    }
}