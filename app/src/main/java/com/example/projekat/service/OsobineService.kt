package com.example.projekat.service

import com.example.projekat.DAO.OsobineDAO
import com.example.projekat.entity.Osobine

class OsobineService {

    private var osobineDAO : OsobineDAO? = null

    constructor(osobineDAO: OsobineDAO?) { this.osobineDAO = osobineDAO }

    fun getAll(): List<Osobine?>? { return osobineDAO?.getAll() }
    private fun saveOsobine(osobine: Osobine) { osobineDAO?.insert(osobine) }

    private fun updateOsobine(osobine: Osobine) { osobineDAO?.update(osobine) }

    fun saveOrUpdate(osobine: Osobine) {
        try {
            saveOsobine(osobine)
        } catch (e: Exception) {
            updateOsobine(osobine)
        }
    }

    suspend fun delete(osobine: Osobine) { osobineDAO?.deleteId(osobine.id) }

    suspend fun deleteAll() { osobineDAO?.deleteAll() }

    fun getOsobineDao(): OsobineDAO? { return osobineDAO }

    fun setOsobineDao(osobineDAO: OsobineDAO) { this.osobineDAO = osobineDAO }
}
