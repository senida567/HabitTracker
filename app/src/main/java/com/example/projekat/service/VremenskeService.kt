package com.example.projekat.service

import com.example.projekat.DAO.VremenskeDAO
import com.example.projekat.entity.Vremenske

class VremenskeService {

    private var vremenskeDAO : VremenskeDAO? = null

    constructor(vremenskeDAO: VremenskeDAO?) { this.vremenskeDAO = vremenskeDAO }

    fun getAll(): List<Vremenske?>? { return vremenskeDAO?.getAll() }
    private fun saveVremenske(vremenske: Vremenske) { vremenskeDAO?.insert(vremenske) }

    private fun updateVremenske(vremenske: Vremenske) { vremenskeDAO?.update(vremenske) }

    fun saveOrUpdate(vremenske: Vremenske) {
        try {
            saveVremenske(vremenske)
        } catch (e: Exception) {
            updateVremenske(vremenske)
        }
    }

    suspend fun delete(vremenske: Vremenske) { vremenskeDAO?.deleteId(vremenske.id) }

    suspend fun deleteAll() { vremenskeDAO?.deleteAll() }

    fun getVremenskeDao(): VremenskeDAO? { return vremenskeDAO }

    fun setVremenskeDao(vremenske: Vremenske) { this.vremenskeDAO = vremenskeDAO }
}
