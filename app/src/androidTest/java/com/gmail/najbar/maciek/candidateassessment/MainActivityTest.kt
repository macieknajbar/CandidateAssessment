package com.gmail.najbar.maciek.candidateassessment

import android.content.Intent
import android.support.test.rule.ActivityTestRule
import com.gmail.najbar.maciek.candidateassessment.domain.Assessment
import com.gmail.najbar.maciek.candidateassessment.domain.CandidateEntity
import com.gmail.najbar.maciek.candidateassessment.domain.PhoneNumberEntity
import com.gmail.najbar.maciek.candidateassessment.domain.factory.CandidateFactory
import com.gmail.najbar.maciek.candidateassessment.pages.DetailsPage
import com.gmail.najbar.maciek.candidateassessment.pages.MainPage
import org.junit.Rule
import org.junit.Test

class MainActivityTest {

    @get:Rule val rule = ActivityTestRule<MainActivity>(MainActivity::class.java, false, false)

    @Test fun displaysListOfUsers() {
        val chandlerBing = CandidateFactory.from("chandlerBing", "Chandler Bing", "+48111111111")
        val rossGeller = CandidateFactory.from("rossGeller", "Ross Geller", "+48123123123")
        val joeyTribbiani = CandidateFactory.from("joeyTribbiani", "Joey Tribbiani", "+48123456789")
        MemoryDatabase.memoryCandidatesDatabase.update(chandlerBing.id, chandlerBing)
        MemoryDatabase.memoryCandidatesDatabase.update(rossGeller.id, rossGeller)
        MemoryDatabase.memoryCandidatesDatabase.update(joeyTribbiani.id, joeyTribbiani)

        rule.launchActivity(Intent())

        MainPage.confirmDisplayed(chandlerBing)
        MainPage.confirmDisplayed(rossGeller)
        MainPage.confirmDisplayed(joeyTribbiani)
    }

    @Test fun goesToCandidateDetails() {
        val chandlerBing = CandidateEntity("chandlerBing", "Chandler Bing", listOf(PhoneNumberEntity("+48111111111")), Assessment.D)
        MemoryDatabase.memoryCandidatesDatabase.update(chandlerBing.id, chandlerBing)

        rule.launchActivity(Intent())

        MainPage.goToDetailsOf(chandlerBing)
        DetailsPage.confirmDisplayed(chandlerBing)
    }
}