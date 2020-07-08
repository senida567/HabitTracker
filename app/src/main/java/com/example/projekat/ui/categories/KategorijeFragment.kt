package com.example.projekat.ui.categories

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.projekat.R
import com.example.projekat.activity.GlavnaAktivnost
import com.example.projekat.adapter.KategorijeAdapter
import com.example.projekat.entity.Kategorije
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.kategorije_fragment.*

class KategorijeFragment : Fragment() {

    private lateinit var kategorijeList : List<Kategorije>
    private lateinit var btn : FloatingActionButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true

    }

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.kategorije_fragment, container, false)

    // populate the views now that the layout has been inflated
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // RecyclerView node initialized here

        kategorijeList = (GlavnaAktivnost.appDatabase!!.getKategorijeService())?.getAll()!!

        recyclerView.apply {
            // set a LinearLayoutManager to handle Android
            // RecyclerView behavior
            layoutManager = LinearLayoutManager(activity)
            // set the custom adapter to the RecyclerView
            adapter = KategorijeAdapter(kategorijeList)
        }


    }

    companion object {
        fun newInstance(): KategorijeFragment = KategorijeFragment()
    }

}