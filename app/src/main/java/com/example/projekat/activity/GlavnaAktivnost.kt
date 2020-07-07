package com.example.projekat.activity

import android.app.ListActivity
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.example.projekat.AppDatabase
import com.example.projekat.R
import com.example.projekat.adapter.KategorijeAdapter
import com.example.projekat.entity.Kategorije
import com.example.projekat.ui.achievements.PostignucaFragment
import com.example.projekat.ui.categories.KategorijeFragment
import com.example.projekat.ui.home.PocetnaFragment
import com.example.projekat.ui.notes.NapomeneFragment
import com.example.projekat.ui.profile.ProfilFragment
import com.example.projekat.ui.settings.PostavkeFragment
import com.google.android.material.bottomnavigation.BottomNavigationMenu
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random.Default.Companion

class GlavnaAktivnost : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var drawer : DrawerLayout
    private lateinit var bottomNavView: BottomNavigationView

    private lateinit var kategorijeList: List<Kategorije>
    private lateinit var recyclerView: RecyclerView
    private var adapter: KategorijeAdapter? = null

    companion object {
        var appDatabase: AppDatabase? = null
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar)) // postavljanje toolbara
        setMyDatabase(java.lang.String.valueOf(R.string.kategorije_service))
        //setUpMyRecyclerView()

        drawer = findViewById(R.id.drawer_layout)
        bottomNavView = findViewById(R.id.bottom_menu);
        bottomNavView.setOnNavigationItemSelectedListener(myListener);

        // ActionBarDrawerToggle prikazuje hamburger ikonu u toolbar-u
        val drawerToggle = ActionBarDrawerToggle(this, drawer, R.string.otvori, R.string.zatvori)
        // dodajem toggle kao listener u DrawerLayout da ga mogu animirati prilikom otvaranja i zatvaranja drawera
        drawer.addDrawerListener(drawerToggle)
        // sinhronizujem toggle tako da zna kad treba prebaciti na hamburger a kad na back ikonu
        drawerToggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        loadFragment(PocetnaFragment());
        navigation_view.setNavigationItemSelectedListener(this)
    }

    private fun loadFragment(fragment : Fragment){
        val transaction : FragmentTransaction = getSupportFragmentManager().beginTransaction()
        transaction.replace(R.id.fragment_container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    /*
    * kad je drawer otvoren i pritisnemo back button citava app se zatvori umjesto samo navigation drawer
    * to popravljamo pomocu metode onBackPressed() */
    override fun onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    // listener za drawer
    // onOptionsItemSelected() sluzi za handlanje bilo kakvih akcija implementiranih u toolbaru
    // posto ja imam samo jednu akciju (navigation drawer), pozivamo je kroz unaprijed definicsan itemId od android.R.id.home
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                drawer.openDrawer(GravityCompat.START)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(menuItem: MenuItem) : Boolean {
        when (menuItem.itemId) {
            R.id.nav_pocetna -> {
                title = "Početna stranica"
                loadFragment(PocetnaFragment())
                drawer.closeDrawer(GravityCompat.START)
                return true
            }
            R.id.nav_postignuca -> {
                title = "Postignuća"
                loadFragment(PostignucaFragment())
                drawer.closeDrawer(GravityCompat.START)
                return true
            }
            R.id.nav_napomene -> {
                title = "Napomene"
                loadFragment(NapomeneFragment())
                drawer.closeDrawer(GravityCompat.START)
                return true
            }
            R.id.nav_postavke -> {
                title = "Postavke"
                loadFragment(PostavkeFragment())
                drawer.closeDrawer(GravityCompat.START)
                return true
            }
            R.id.nav_podijeli -> {
                title = "Podijeli"
                loadFragment(PocetnaFragment())
                drawer.closeDrawer(GravityCompat.START)
                return true
            }
        }

        drawer.closeDrawer(GravityCompat.START)
        return true
    }

    private val myListener =
        BottomNavigationView.OnNavigationItemSelectedListener {item ->
            item.setChecked(true)
            when (item.itemId) {
                R.id.bottom_pocetna -> {
                    title = "Početna stranica"
                    loadFragment(PocetnaFragment())
                }
                R.id.bottom_kategorije -> {
                    title = "Kategorije"
                    loadFragment(KategorijeFragment())
                }
                R.id.bottom_profil -> {
                    title = "Profil"
                    loadFragment(ProfilFragment())
                }
            }
            false
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
}
