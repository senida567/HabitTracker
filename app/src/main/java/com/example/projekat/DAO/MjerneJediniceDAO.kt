package com.example.projekat.DAO

import androidx.room.*
import com.example.projekat.entity.Inkrementalne
import com.example.projekat.entity.MjerneJedinice

@Dao
interface MjerneJediniceDAO {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(mjerneJedinice: MjerneJedinice)

    @Query("SELECT * FROM mjerne_jedinice")
    fun getAll() : List<MjerneJedinice>

    @Query("DELETE FROM mjerne_jedinice")
    suspend fun deleteAll()

    @Query("DELETE FROM mjerne_jedinice WHERE id = :id_MJ")
    suspend fun deleteId(id_MJ : Int)

    @Update
    fun update(mjerneJedinice: MjerneJedinice?)

}