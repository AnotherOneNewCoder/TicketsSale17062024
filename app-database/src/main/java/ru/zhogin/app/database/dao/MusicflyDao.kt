package ru.zhogin.app.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import ru.zhogin.app.database.models.musicfly.OfferDBO

@Dao
interface MusicflyDao {

    @Query("SELECT * FROM music_fly")
    suspend fun getAllOffers() : List<OfferDBO>

    @Query("SELECT * FROM music_fly")
    fun observeAllOffers() : Flow<List<OfferDBO>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOffer(offerDbo: List<OfferDBO>)

    @Query("DELETE FROM music_fly")
    suspend fun clearOffers()
}