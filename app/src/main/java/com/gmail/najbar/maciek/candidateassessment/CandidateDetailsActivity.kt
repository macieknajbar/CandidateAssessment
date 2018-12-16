package com.gmail.najbar.maciek.candidateassessment

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.RadioGroup
import android.widget.TextView
import com.gmail.najbar.maciek.candidateassessment.app.DisplayDetailsPresenter
import com.gmail.najbar.maciek.candidateassessment.repository.DisplayCandidateDetailsMemoryRepository
import com.gmail.najbar.maciek.candidateassessment.usecase.DisplayDetails

class CandidateDetailsActivity : AppCompatActivity(), DisplayDetailsPresenter.View {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_candidate_details)

        DisplayDetails(DisplayDetailsPresenter(this), DisplayCandidateDetailsMemoryRepository(MemoryDatabase.memoryCandidatesDatabase))
                .of(intent.getStringExtra(EXTRA_CANDIDATE_ID))
    }

    override fun displayName(name: String) {
        findViewById<TextView>(R.id.fullName).text = name
    }

    override fun displayPhoneNumbers(contactNumbers: Collection<String>) {
        val phoneNumbers = findViewById<LinearLayout>(R.id.phoneNumbers)
        phoneNumbers.removeAllViews()
        contactNumbers.forEach {
            val phone = LayoutInflater.from(this).inflate(R.layout.item_phone, phoneNumbers, false) as TextView
            phone.text = it
            phoneNumbers.addView(phone)
        }
    }

    override fun displayAssessment(value: String) {
        val assessmentGroup = findViewById<RadioGroup>(R.id.assessment)
        val assessmentId = when (value) {
            "A" -> R.id.a
            "B" -> R.id.b
            "C" -> R.id.c
            "D" -> R.id.d
            "E" -> R.id.e
            "F" -> R.id.f
            else -> null
        }

        assessmentId?.let { assessmentGroup.check(it) }
                ?: assessmentGroup.clearCheck()
    }

    companion object {
        const val EXTRA_CANDIDATE_ID = "EXTRA_CANDIDATE_ID"
    }
}