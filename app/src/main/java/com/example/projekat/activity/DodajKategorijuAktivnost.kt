package com.example.projekat.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.projekat.R
import com.example.projekat.entity.Kategorije

class DodajKategorijuAktivnost : AppCompatActivity() {
    private var btn: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dodaj_kategoriju)
        btn = findViewById(R.id.buttonAdd)
        btn!!.setOnClickListener {
            dodajKategoriju()
            openMainActivity()
        }
    }

    private fun dodajKategoriju() {

        var naziv: EditText = findViewById(R.id.editText1)
        var osobine : EditText = findViewById(R.id.editText2)
        var k = Kategorije(0, naziv.text.toString(), 2, osobine.text.toString().toBoolean())
        GlavnaAktivnost.appDatabase?.getKategorijeService()?.saveOrUpdate(k)
    }

    fun openMainActivity() {
        val intent = Intent(this, GlavnaAktivnost::class.java)
        startActivity(intent)
    }
}