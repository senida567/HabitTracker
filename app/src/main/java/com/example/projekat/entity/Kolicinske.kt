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
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(entity = Kategorije::class,
            parentColumns = arrayOf("id"),
            childColumns = arrayOf("id_kategorije"),
            onDelete = ForeignKey.CASCADE
        )
    ))

class Kolicinske(

    @PrimaryKey(autoGenerate = true) val id : Int,

    @ColumnInfo(name = "naziv") val naziv : String,

    @ColumnInfo(name = "kolicina") val kolicina : Int,

    @ColumnInfo(name = "id_mjerna_jedinica", index = true) val id_mjerna_jedinica : Int,

    @ColumnInfo(name = "id_kategorije", index = true) val id_kategorije : Int
)