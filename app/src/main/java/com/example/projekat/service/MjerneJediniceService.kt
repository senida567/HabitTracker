package com.example.projekat.service

import com.example.projekat.DAO.MjerneJediniceDAO
import com.example.projekat.DAO.VremenskeDAO
import com.example.projekat.entity.MjerneJedinice
import com.example.projekat.entity.Vremenske

class MjerneJediniceService {

    private var mjerneJediniceDAO : MjerneJediniceDAO? = null

    constructor(mjerneJediniceDAO: MjerneJediniceDAO?) { this.mjerneJediniceDAO = mjerneJediniceDAO }

    fun getAll(): List<MjerneJedinice?>? { return mjerneJediniceDAO?.getAll() }
    private fun saveMjerneJedinice(mjerneJedinice: MjerneJedinice) { mjerneJediniceDAO?.insert(mjerneJedinice) }

    private fun updateMjerneJedinice(mjerneJedinice: MjerneJedinice) { mjerneJediniceDAO?.update(mjerneJedinice) }

    fun saveOrUpdate(mjerneJedinice: MjerneJedinice) {
        try {
            saveMjerneJedinice(mjerneJedinice)
        } catch (e: Exception) {
            updateMjerneJedinice(mjerneJedinice)
        }
    }

    suspend fun delete(mjerneJedinice: MjerneJedinice) { mjerneJediniceDAO?.deleteId(mjerneJedinice.id) }

    suspend fun deleteAll() { mjerneJediniceDAO?.deleteAll() }

    fun getMjerneJediniceDao(): MjerneJediniceDAO? { return mjerneJediniceDAO }

    fun setMjerneJediniceDao(mjerneJedinice: MjerneJedinice) { this.mjerneJediniceDAO = mjerneJediniceDAO }
}
