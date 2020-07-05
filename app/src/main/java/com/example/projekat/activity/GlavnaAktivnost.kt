package com.example.projekat.activity

import android.app.ListActivity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.example.projekat.AppDatabase
import com.example.projekat.R
import com.example.projekat.adapter.KategorijeAdapter
import com.example.projekat.entity.Kategorije
import kotlin.random.Random.Default.Companion

class GlavnaAktivnost : AppCompatActivity() {
    private lateinit var kategorijeList: List<Kategorije>
    private lateinit var recyclerView: RecyclerView
    private var adapter: KategorijeAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setMyDatabase(java.lang.String.valueOf(R.string.kategorije_service))
        setUpMyRecyclerView()
    }

    fun openDodajKategorijuAktivnost(view: View) {
        startActivity(Intent(view.context, DodajKategorijuAktivnost::class.java))
    }

    private fun setMyDatabase(serviceName: String) {
        appDatabase = Room.databaseBuilder(
            this, AppDatabase::class.java,
            java.lang.String.valueOf(R.string.db_name)
        ).allowMainThreadQueries().build()
        appDatabase = appDatabase?.getInstanceByContextAndService(this, serviceName)
    }

    private fun setUpMyRecyclerView() {
        val kategorija = Kategorije(1, "Dnevna aktivnost", 2, true)
        val kategorija2 = Kategorije(2, "Školske aktivnosti", 1, true)
        appDatabase?.getKategorijeService()?.saveOrUpdate(kategorija)
        appDatabase?.getKategorijeService()?.saveOrUpdate(kategorija2)
        kategorijeList = appDatabase?.getKategorijeService()?.getAll()!!
        recyclerView = findViewById(R.id.recyclerView)
        adapter = KategorijeAdapter(kategorijeList)
        recyclerView.setAdapter(adapter)
        recyclerView.setLayoutManager(LinearLayoutManager(this))
    }

    override fun onPointerCaptureChanged(hasCapture: Boolean) {}

    companion object {
        var appDatabase: AppDatabase? = null
    }
}
