package com.example.projekat.ui.categories

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.projekat.R
import com.example.projekat.activity.GlavnaAktivnost
import com.example.projekat.adapter.KategorijeAdapter
import com.example.projekat.entity.Kategorije
import com.example.projekat.service.KategorijeService
import kotlinx.android.synthetic.main.fragment_dodaj_kategoriju.*


class DodajKategorijuFragment : Fragment() {

    private lateinit var btn : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true

    }

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.fragment_dodaj_kategoriju, container, false)

    // populate the views now that the layout has been inflated
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn = view.findViewById(R.id.novaKategorija)
        btn.setOnClickListener {

            var naziv = view.findViewById<EditText>(R.id.naziv).getText().toString()
            if(TextUtils.isEmpty(naziv)) {

                Toast.makeText(requireActivity(), "plz enter your name ", Toast.LENGTH_SHORT).show();
                return@setOnClickListener;

            } else {

                var db = GlavnaAktivnost.appDatabase
                var broj = db?.getKategorijeDao()?.getLastId()
                var lastId: Int
                if (broj != null) lastId = broj + 1
                else lastId = 1
                var novaKategorija = Kategorije(lastId, naziv, 2, true)
                db?.getKategorijeService()?.saveOrUpdate(novaKategorija)
                var fr = getFragmentManager()?.beginTransaction()
                fr?.replace(R.id.fragment_container, KategorijeFragment())
                fr?.addToBackStack(null)
                fr?.commit()
            }
        }

    }
}