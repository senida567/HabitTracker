package com.example.projekat.service

import com.example.projekat.DAO.KategorijeDAO
import com.example.projekat.DAO.KolicinskeDAO
import com.example.projekat.entity.Kategorije
import com.example.projekat.entity.Kolicinske

class KolicinskeService {

    private var kolicinskeDAO : KolicinskeDAO? = null

    constructor(kolicinskeDAO: KolicinskeDAO?) { this.kolicinskeDAO = kolicinskeDAO }

    fun getAll(): List<Kolicinske?>? { return kolicinskeDAO?.getAll() }
    private fun saveKolicinske(kolicinske: Kolicinske) { kolicinskeDAO?.insert(kolicinske) }

    private fun updateKolicinske(kolicinske: Kolicinske) { kolicinskeDAO?.update(kolicinske) }

    fun saveOrUpdate(kolicinske: Kolicinske) {
        try {
            saveKolicinske(kolicinske)
        } catch (e: Exception) {
            updateKolicinske(kolicinske)
        }
    }

    suspend fun delete(kolicinske: Kolicinske) { kolicinskeDAO?.deleteId(kolicinske.id) }

    suspend fun deleteAll() { kolicinskeDAO?.deleteAll() }

    fun getKolicinskeDao(): KolicinskeDAO? { return kolicinskeDAO }

    fun setKolicinskeDao(kolicinskeDAO: KolicinskeDAO) { this.kolicinskeDAO = kolicinskeDAO }
}
