package com.gmail.najbar.maciek.candidateassessment

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.AdapterView
import android.widget.ListView
import com.gmail.najbar.maciek.candidateassessment.app.CandidatesAdapter
import com.gmail.najbar.maciek.candidateassessment.app.DisplayCandidatesPresenter
import com.gmail.najbar.maciek.candidateassessment.repository.MemoryRepositoryOfDisplayCandidates
import com.gmail.najbar.maciek.candidateassessment.usecase.DisplayCandidates

class MainActivity : AppCompatActivity(),
        DisplayCandidatesPresenter.View {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        DisplayCandidates(DisplayCandidatesPresenter(this), MemoryRepositoryOfDisplayCandidates(MemoryDatabase.memoryCandidatesDatabase))
                .all()
    }

    override fun displayCandidates(names: Map<String, String>) {
        val candidates = findViewById<ListView>(R.id.candidates)
        candidates.adapter = CandidatesAdapter(names)
        candidates.onItemClickListener = AdapterView.OnItemClickListener { _, view, _, _ ->
            // TODO: New use case.
            startActivity(Intent(this, CandidateDetailsActivity::class.java).putExtra(
                    CandidateDetailsActivity.EXTRA_CANDIDATE_ID,
                    view.tag as String))
        }
    }
}
