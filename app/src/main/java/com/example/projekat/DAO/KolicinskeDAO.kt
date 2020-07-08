package com.example.projekat.DAO

import androidx.room.*
import com.example.projekat.entity.Inkrementalne
import com.example.projekat.entity.Kolicinske

@Dao
interface KolicinskeDAO {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(kolicinske: Kolicinske)

    @Query("SELECT * FROM kolicinske")
    fun getAll() : List<Kolicinske>

    @Query("SELECT * FROM kolicinske WHERE id_kategorije = :id_K")
    fun getKolicinskeKategorije(id_K: Int) : List<Kolicinske>

    @Query("DELETE FROM kolicinske")
    suspend fun deleteAll()

    @Query("DELETE FROM kolicinske WHERE id = :id_K")
    suspend fun deleteId(id_K : Int)

    @Update
    fun update(kolicinske: Kolicinske?)
}