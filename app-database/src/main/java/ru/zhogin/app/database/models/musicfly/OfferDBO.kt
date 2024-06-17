package ru.zhogin.app.database.models.musicfly

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import ru.zhogin.app.database.models.PriceDBO

@Entity(tableName = "music_fly")
data class OfferDBO(
    @PrimaryKey
    val id: Int,
    @Embedded
    val price: PriceDBO,
    @ColumnInfo("title")
    val title: String,
    @ColumnInfo("town")
    val town: String
)
