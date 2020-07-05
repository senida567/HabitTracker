package com.example.projekat.service

import com.example.projekat.DAO.KategorijeDAO
import com.example.projekat.entity.Kategorije

class KategorijeService {

    private var kategorijeDAO: KategorijeDAO? = null

    constructor(kategorijeDAO: KategorijeDAO?) { this.kategorijeDAO = kategorijeDAO }

    fun getAll(): List<Kategorije>? { return kategorijeDAO?.getAll() }
    fun saveKategorija(kategorije: Kategorije) { kategorijeDAO?.insert(kategorije) }

    private fun updateKategorije(kategorije: Kategorije) { kategorijeDAO?.update(kategorije) }

    fun saveOrUpdate(kategorije: Kategorije) {
        try {
            saveKategorija(kategorije)
        } catch (e: Exception) {
            updateKategorije(kategorije)
        }
    }

    suspend fun delete(kategorije: Kategorije) { kategorijeDAO?.deleteId(kategorije.id) }

    suspend fun deleteAll() { kategorijeDAO?.deleteAll() }

    fun getKategorijeDao(): KategorijeDAO? { return kategorijeDAO }

    fun setKategorijeDao(kategorijeDAO: KategorijeDAO) { this.kategorijeDAO = kategorijeDAO }
}
