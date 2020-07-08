package com.example.projekat.ui.categories

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.projekat.R

class KategorijeViewModel(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.kategorije_element, parent, false)) {
    private var mTitleView: TextView? = null
    private var mYearView: TextView? = null


    init {
        // mTitleView = itemView.findViewById(R.id.list_title)
        // mYearView = itemView.findViewById(R.id.list_description)
    }

    fun bind(){//movie: Movie) {
    }

}