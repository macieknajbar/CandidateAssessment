package com.gmail.najbar.maciek.candidateassessment.pages

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.isDisplayed
import android.support.test.espresso.matcher.ViewMatchers.withText
import com.gmail.najbar.maciek.candidateassessment.domain.CandidateEntity

object MainPage {
    fun confirmDisplayed(candidateEntity: CandidateEntity) {
        onView(withText(candidateEntity.fullName))
                .check(matches(isDisplayed()))
    }
}