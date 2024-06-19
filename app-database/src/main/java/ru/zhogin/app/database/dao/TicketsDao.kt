package ru.zhogin.app.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import ru.zhogin.app.database.models.tickets.TicketDBO
@Dao
interface TicketsDao {
    @Query("SELECT * FROM tickets")
    suspend fun getAllOffers() : List<TicketDBO>

    @Query("SELECT * FROM tickets")
    fun observeAllOffers() : Flow<List<TicketDBO>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOffer(ticketDbo: List<TicketDBO>)

    @Query("DELETE FROM tickets")
    suspend fun clearOffers()
}