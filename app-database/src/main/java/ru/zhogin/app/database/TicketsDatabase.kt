package ru.zhogin.app.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import ru.zhogin.app.database.dao.DirectsDao
import ru.zhogin.app.database.dao.MusicflyDao
import ru.zhogin.app.database.dao.TicketsDao
import ru.zhogin.app.database.models.directs.TicketOfferDBO
import ru.zhogin.app.database.models.musicfly.OfferDBO
import ru.zhogin.app.database.models.tickets.TicketDBO
import ru.zhogin.app.database.utils.GsonConverter

class TicketsDatabase internal constructor(private val database: TicketsRoomDatabase) {

    val musicflyDao: MusicflyDao
        get() = database.musicflyDao()
    val directsDao: DirectsDao
        get() = database.directsDao()
    val ticketsDao: TicketsDao
        get() = database.ticketsDao()
}

@Database(
    entities = [
        OfferDBO::class,
        TicketOfferDBO::class,
        TicketDBO::class,
    ],
    version = 1,
    exportSchema = true,
)
@TypeConverters(GsonConverter::class)
internal abstract class TicketsRoomDatabase : RoomDatabase() {
    abstract fun musicflyDao() : MusicflyDao
    abstract fun directsDao() : DirectsDao
    abstract fun ticketsDao() : TicketsDao
}

fun TicketsDatabase(applicationContext: Context) : TicketsDatabase {
    val ticketsRoomDatabase = Room.databaseBuilder(
        checkNotNull(applicationContext.applicationContext),
        TicketsRoomDatabase::class.java,
        "tickets_sales"
    ).build()
    return TicketsDatabase(ticketsRoomDatabase)
}