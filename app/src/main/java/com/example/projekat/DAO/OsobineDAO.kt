package com.example.projekat.DAO

import androidx.room.*
import com.example.projekat.entity.Inkrementalne
import com.example.projekat.entity.Osobine

@Dao
interface OsobineDAO {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(osobine: Osobine)

    @Query("SELECT * FROM osobine")
    fun getAll() : List<Osobine>

    //osobine koje pripadaju kategoriji sa id-om id_K
    @Query("SELECT opis FROM osobine WHERE id_kategorije = :id_K")
    fun getOsobineKategorije(id_K: Int) : List<String>

    @Query("DELETE FROM osobine")
    suspend fun deleteAll()

    @Query("DELETE FROM osobine WHERE id = :id_O")
    suspend fun deleteId(id_O : Int)

    @Update
    fun update(osobine: Osobine?)
}