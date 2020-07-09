package com.example.projekat.DAO

import androidx.room.*
import com.example.projekat.entity.Kategorije

@Dao
interface KategorijeDAO {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(kategorije: Kategorije) //suspend

    @Query("SELECT * FROM kategorije")
    fun getAll() : List<Kategorije>

    @Query("DELETE FROM kategorije")
    suspend fun deleteAll()

    @Query("DELETE FROM kategorije WHERE id = :id_K")
    suspend fun deleteId(id_K : Int)

    @Update
    fun update(kategorije: Kategorije?)

    @Query("SELECT id FROM kategorije ORDER BY id DESC LIMIT 1")
    fun getLastId() : Int
}