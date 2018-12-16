package com.gmail.najbar.maciek.candidateassessment.app

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.gmail.najbar.maciek.candidateassessment.R

class CandidatesAdapter(private val candidates: Map<String, String>) : BaseAdapter() {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view = convertView
                ?: LayoutInflater.from(parent!!.context).inflate(R.layout.item_candidate, parent, false)

        view.tag = candidates.entries.elementAt(position).key
        (view as TextView).text = getItem(position)

        return view
    }

    override fun getItem(position: Int): String = candidates.entries.elementAt(position).value
    override fun getItemId(position: Int): Long = 0
    override fun getCount(): Int = candidates.size
}