package com.gmail.najbar.maciek.candidateassessment

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
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

    override fun displayCandidates(names: Collection<String>) {
        val candidates = findViewById<ListView>(R.id.candidates)
        candidates.adapter = CandidatesAdapter(names)
    }
}
