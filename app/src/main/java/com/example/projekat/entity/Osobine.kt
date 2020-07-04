package com.example.projekat.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE
import androidx.room.PrimaryKey

@Entity(tableName = "osobine",
        foreignKeys = arrayOf(
            ForeignKey(entity = Kategorije::class,
                parentColumns = arrayOf("id"),
                childColumns = arrayOf("id_kategorija"),
                onDelete = CASCADE)))
class Osobine (

    @PrimaryKey(autoGenerate = true) val id : Int,

    @ColumnInfo(name = "opis") val opis : String,

    @ColumnInfo(name = "id_kategorija") val id_kategorija : Int

)