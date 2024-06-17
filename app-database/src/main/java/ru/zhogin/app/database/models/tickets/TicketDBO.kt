package ru.zhogin.app.database.models.tickets

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tickets")
data class TicketDBO(

    @Embedded("-")
    val arrival: ArrivalDBO,
    @ColumnInfo("badge")
    val badge: String? = null,
    @ColumnInfo("company")
    val company: String,

    @Embedded("-")
    val departure: DepartureDBO,

    @Embedded("-")
    val handLuggage: HandLuggageDBO,
    @ColumnInfo("has_transfer")
    val hasTransfer: Boolean,
    @ColumnInfo("has_visa_transfer")
    val hasVisaTransfer: Boolean,
    @PrimaryKey
    val id: Int,
    @ColumnInfo("is_exchangable")
    val isExchangable: Boolean,
    @ColumnInfo("is_returnable")
    val isReturnable: Boolean,
    @Embedded("-")

    val luggage: LuggageDBO,
    @Embedded("-")

    val price: PriceXDBO,
    @ColumnInfo("provider_name")
    val providerName: String
)
data class ArrivalDBO(
    @ColumnInfo("arrival_airport")
    val airport: String,
    @ColumnInfo("arrival_date")
    val date: String,
    @ColumnInfo("arrival_town")
    val town: String
)

data class DepartureDBO(
    @ColumnInfo("departure_airport")
    val airport: String,
    @ColumnInfo("departure_date")
    val date: String,
    @ColumnInfo("departure_town")
    val town: String
)
data class HandLuggageDBO(
    @ColumnInfo("has_hand_luggage")
    val hasHandLuggage: Boolean,
    @ColumnInfo("size")
    val size: String? = null,
)
data class LuggageDBO(
    @ColumnInfo("has_luggage")
    val hasLuggage: Boolean,
    @Embedded("-")
    val price: PriceXDBO? = null,
)

data class PriceXDBO(
    @ColumnInfo("value")
    val value: Int
)
