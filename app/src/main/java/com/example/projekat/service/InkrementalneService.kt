package com.example.projekat.service

import com.example.projekat.DAO.InkrementalneDAO
import com.example.projekat.entity.Inkrementalne

class InkrementalneService {

    private var inkrementalneDAO: InkrementalneDAO? = null

    constructor(inkrementalneDAO: InkrementalneDAO?) { this.inkrementalneDAO = inkrementalneDAO } //) InkrementalneService

    fun getAll(): List<Inkrementalne?>? { return inkrementalneDAO?.getAll() }

    private suspend fun saveInkrementalne(inkrementalne: Inkrementalne) { inkrementalneDAO?.insert(inkrementalne) }

    private fun updateInkrementalne(inkrementalne: Inkrementalne) { inkrementalneDAO?.update(inkrementalne) }

    suspend fun saveOrUpdate(inkrementalne: Inkrementalne) {
        try {
            saveInkrementalne(inkrementalne)
        } catch (e: Exception) {
            updateInkrementalne(inkrementalne)
        }
    }

    suspend fun delete(inkrementalne: Inkrementalne) { inkrementalneDAO?.deleteId(inkrementalne.id) }

    suspend fun deleteAll() { inkrementalneDAO?.deleteAll() }

    fun getInkrementalneDao(): InkrementalneDAO? { return inkrementalneDAO }

    fun setInkrementalneDao(inkrementalneDAO: InkrementalneDAO) { this.inkrementalneDAO = inkrementalneDAO }

}