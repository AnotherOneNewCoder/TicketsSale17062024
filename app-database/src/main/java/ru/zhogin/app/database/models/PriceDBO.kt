package ru.zhogin.app.database.models

import androidx.room.ColumnInfo

data class PriceDBO(
    @ColumnInfo("value")
    val value: Int
)
