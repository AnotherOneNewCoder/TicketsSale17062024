package ru.zhogin.app.database.models.directs

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import ru.zhogin.app.database.models.PriceDBO

@Entity("directs")
data class TicketOfferDBO(
    @PrimaryKey
    val id: Int,
    @Embedded
    val price: PriceDBO,
    @ColumnInfo("time_range")
    val timeRange: String,
    @ColumnInfo("title")
    val title: String
)

