package com.gmail.najbar.maciek.candidateassessment.pages

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.isChecked
import android.support.test.espresso.matcher.ViewMatchers.isDisplayed
import android.support.test.espresso.matcher.ViewMatchers.withText
import com.gmail.najbar.maciek.candidateassessment.domain.CandidateEntity

object DetailsPage {
    fun confirmDisplayed(candidateEntity: CandidateEntity) {
        onView(withText(candidateEntity.fullName))
                .check(matches(isDisplayed()))

        candidateEntity.contactNumbers.forEach {
            onView(withText(it.phoneNumber))
                    .check(matches(isDisplayed()))
        }

        if (candidateEntity.grade?.name != null) {
            onView(withText(candidateEntity.grade!!.name))
                    .check(matches(isChecked()))
        }
    }
}