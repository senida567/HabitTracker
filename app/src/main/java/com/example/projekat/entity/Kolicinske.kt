package com.example.projekat.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE
import androidx.room.PrimaryKey

@Entity(tableName = "kolicinske",
    foreignKeys = arrayOf(
        ForeignKey(entity = MjerneJedinice::class,
            parentColumns = arrayOf("id"),
            childColumns = arrayOf("id_mjerna_jedinica"),
            onDelete = CASCADE),
        ForeignKey(entity = Kategorije::class,
            parentColumns = arrayOf("id"),
            childColumns = arrayOf("id_kategorije"),
            onDelete = CASCADE)
    ))

class Kolicinske(

    @PrimaryKey(autoGenerate = true) val id : Int,

    @ColumnInfo(name = "kolicina") val kolicina : Int,

    @ColumnInfo(name = "id_mjerna_jedinica") val id_mjerna_jedinica : Int,

    @ColumnInfo(name = "id_kategorije") val id_kategorije : Int
)