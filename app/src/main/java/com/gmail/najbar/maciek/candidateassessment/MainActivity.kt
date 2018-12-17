package com.gmail.najbar.maciek.candidateassessment

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.AdapterView
import android.widget.ListView
import com.gmail.najbar.maciek.candidateassessment.app.CandidatesAdapter
import com.gmail.najbar.maciek.candidateassessment.app.DisplayCandidatesPresenter
import com.gmail.najbar.maciek.candidateassessment.app.OpenDetailsScreenPresenter
import com.gmail.najbar.maciek.candidateassessment.repository.MemoryRepositoryOfDisplayCandidates
import com.gmail.najbar.maciek.candidateassessment.usecase.DisplayCandidates
import com.gmail.najbar.maciek.candidateassessment.usecase.OpenDetailsScreen

class MainActivity : AppCompatActivity(),
        DisplayCandidatesPresenter.View,
        OpenDetailsScreenPresenter.View {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        DisplayCandidates(DisplayCandidatesPresenter(this), MemoryRepositoryOfDisplayCandidates(MemoryDatabase.memoryCandidatesDatabase))
                .all()

        findViewById<View>(R.id.newCandidate)
                .setOnClickListener {
                    startActivity(Intent(this, CandidateDetailsActivity::class.java)
                            .putExtra(CandidateDetailsActivity.EXTRA_CANDIDATE_ID, ""))
                }
    }

    override fun displayCandidates(names: Map<String, String>) {
        val candidates = findViewById<ListView>(R.id.candidates)
        candidates.adapter = CandidatesAdapter(names)
        candidates.onItemClickListener = AdapterView.OnItemClickListener { _, view, _, _ ->
            OpenDetailsScreen(OpenDetailsScreenPresenter(this))
                    .go(view.tag as String)
        }
    }

    override fun showDetailsFor(candidateId: String) {
        startActivity(Intent(this, CandidateDetailsActivity::class.java).putExtra(
                CandidateDetailsActivity.EXTRA_CANDIDATE_ID,
                candidateId))
    }
}
