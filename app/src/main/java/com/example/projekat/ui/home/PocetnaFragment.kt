package com.example.projekat.ui.home

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.example.projekat.AppDatabase
import com.example.projekat.R
import com.example.projekat.activity.GlavnaAktivnost
import com.example.projekat.activity.GlavnaAktivnost.Companion.appDatabase
import com.example.projekat.adapter.InkrementalneAdapter
import com.example.projekat.adapter.KategorijeAdapter
import com.example.projekat.entity.Inkrementalne
import com.example.projekat.entity.Kolicinske
import com.example.projekat.entity.Vremenske
import com.google.android.material.floatingactionbutton.FloatingActionButton

class PocetnaFragment : Fragment() {

    lateinit private var inkrementalneList : List<Inkrementalne>
    lateinit private var kolicinskeList : List<Kolicinske>
    lateinit private var vremenskeList : List<Vremenske>

    lateinit private var recyclerView : RecyclerView
    lateinit private var inkrementalneAdapter : InkrementalneAdapter
    // todo: lateinit private var vremenskeAdapter : VremenskeAdapter
    // todo: lateinit private var kolicinskeAdapter : KolicinskeAdapter

    lateinit var fabPocetna : FloatingActionButton
    lateinit var dugmeUnos : Button
    lateinit var dugmePlus : Button
    lateinit var dugmeMinus : Button
    lateinit var dugmeUkloni : Button

    companion object {
        fun newInstance() = PocetnaFragment()
    }

    private lateinit var viewModel: PocetnaViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view : View = inflater.inflate(R.layout.pocetna_fragment, container, false)

/*        dugmePlus = view.findViewById(R.id.plus_btn)
        dugmeMinus = view.findViewById(R.id.minus_btn)
        dugmeUnos = view.findViewById(R.id.unos_btn)
        dugmeUkloni = view.findViewById(R.id.ukloni_aktivnost)
        fabPocetna = view.findViewById(R.id.fabPocetna)

        dugmePlus.setOnClickListener {
            povecajInkrement(view)
        }

        dugmeMinus.setOnClickListener {
            smanjiInkrement(view)
        }

        dugmeUnos.setOnClickListener {
            dodajUnos(view)
        }

        dugmeUkloni.setOnClickListener {
            ukloniAktivnost(view)
        }

        fabPocetna.setOnClickListener {
            dodajAktivnost(view)
        }*/

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(PocetnaViewModel::class.java)
        // TODO: Use the ViewModel

        //setUpMyRecyclerView()
    }

    private fun povecajInkrement(view: View) {

    }

    private fun smanjiInkrement(view: View) {

    }

    private fun dodajUnos(view : View) {

    }

    private fun dodajAktivnost(view : View) {
        /* todo: korisniku se prikaze lista vec postojecih aktivnosti u bazi
        *   aktivnost koju odabere se dodaje na pocetnu stranicu */
    }

    private fun ukloniAktivnost(view : View) {
        /* todo: odgovarajuca aktivnost se uklanja s pocetne strane
        *   ne uklanja se iz baze */
    }

    private fun setUpMyRecyclerView() {

        if (appDatabase?.getInkrementalneService()?.getAll()!!.isEmpty() ||
            appDatabase?.getKolicinskeService()?.getAll()!!.isEmpty() ||
            appDatabase?.getVremenskeService()?.getAll()!!.isEmpty()) {

            val aktivnost_1 : Inkrementalne =
                Inkrementalne(0,"Voda", 0, 1, 1, 0)
            appDatabase!!.getInkrementalneService()?.saveOrUpdate(aktivnost_1)

            val aktivnost_2 : Kolicinske =
                Kolicinske(0, "Kalorije", 1400, 2, 1)
            appDatabase!!.getKolicinskeService()?.saveOrUpdate(aktivnost_2)

            val aktivnost_3 : Vremenske =
                Vremenske(0, "Trčanje", "start", "stop", 3)
            appDatabase!!.getVremenskeService()?.saveOrUpdate(aktivnost_3)
        }

        inkrementalneList = appDatabase!!.getInkrementalneService()?.getAll() as List<Inkrementalne>
        kolicinskeList = appDatabase!!.getKolicinskeService()?.getAll() as List<Kolicinske>
        vremenskeList = appDatabase!!.getInkrementalneService()?.getAll() as List<Vremenske>

        recyclerView = getView()?.findViewById(R.id.recyclerViewPocetna)!!

        inkrementalneAdapter = InkrementalneAdapter(inkrementalneList)
        // todo: uraditi i za vremenske i kolicinske aktivnosti

        recyclerView.adapter = inkrementalneAdapter
        recyclerView.layoutManager = LinearLayoutManager(context)
    }

}