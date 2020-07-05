package com.example.projekat.DAO

import androidx.room.*
import com.example.projekat.entity.Inkrementalne
import com.example.projekat.entity.Vremenske

@Dao
interface VremenskeDAO {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(vremenske: Vremenske)

    @Query("SELECT * FROM vremenske")
    fun getAll() : List<Vremenske>

    @Query("SELECT * FROM vremenske WHERE id_kategorije = :id_K")
    fun getVremenskeKategorije(id_K: Int) : List<Vremenske> //mozda tip liste nije uredu??

    @Query("DELETE FROM vremenske")
    suspend fun deleteAll()

    @Query("DELETE FROM vremenske WHERE id = :id_V")
    suspend fun deleteId(id_V : Int)

    @Update
    fun update(vremenske: Vremenske?)

}