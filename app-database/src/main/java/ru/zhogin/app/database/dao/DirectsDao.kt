package ru.zhogin.app.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import ru.zhogin.app.database.models.directs.TicketOfferDBO

@Dao
interface DirectsDao {
    @Query("SELECT * FROM directs")
    suspend fun getAllDirects() : List<TicketOfferDBO>

    @Query("SELECT * FROM directs")
    fun observeAllDirects() : Flow<List<TicketOfferDBO>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDirect(offerDbo: List<TicketOfferDBO>)

    @Query("DELETE FROM directs")
    suspend fun clearDirects()
}