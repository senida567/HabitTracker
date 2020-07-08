package com.example.projekat.DAO

import androidx.room.*
import com.example.projekat.entity.Inkrementalne
import com.example.projekat.entity.Kategorije

@Dao
interface InkrementalneDAO {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(inkrementalne: Inkrementalne)

    @Query("SELECT * FROM inkrementalne")
    fun getAll() : List<Inkrementalne>

    @Query("SELECT * FROM inkrementalne WHERE id_kategorije = :id_K")
    fun getInkrementalneKategorije(id_K: Int) : List<Inkrementalne>

    @Query("DELETE FROM inkrementalne")
    suspend fun deleteAll()

    @Query("DELETE FROM inkrementalne WHERE id = :id_I")
    suspend fun deleteId(id_I : Int)

    @Update
    fun update(inkrementalne: Inkrementalne?)
}