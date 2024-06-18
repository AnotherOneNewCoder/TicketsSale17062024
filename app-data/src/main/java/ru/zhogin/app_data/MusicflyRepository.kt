package ru.zhogin.app_data

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.merge
import kotlinx.coroutines.flow.onEach
import ru.zhogin.app.api.MusicflyApi
import ru.zhogin.app.api.models.musicfly.OfferDTO
import ru.zhogin.app.database.TicketsDatabase
import ru.zhogin.app.database.models.musicfly.OfferDBO
import ru.zhogin.app_data.models.musicfly.Offer
import ru.zhogin.app_data.models.musicfly.Offers
import javax.inject.Inject

class MusicflyRepository @Inject constructor(
    private val database: TicketsDatabase,
    private val musicflyApi: MusicflyApi,
) {
    @OptIn(ExperimentalCoroutinesApi::class)
    fun getMusicfly(
        mergeStrategy: MergeStrategy<RequestResult<Offers>> = DefaultRequestResponseMereStrategy()
    ): Flow<RequestResult<Offers>> {
        val cachedMusicfly = getMusicflyFromDatabase()
        val remoteMusicfly = getMusicflyFromServer()

        return cachedMusicfly.combine(remoteMusicfly, mergeStrategy::merge)
            .flatMapLatest { result ->
                if (result is RequestResult.Success) {
                    database.musicflyDao.observeAllOffers()
                        .map { dbos -> dbos.map { it.toOffer() } }
                        .map { list -> list.toOffer() }
                        .map { RequestResult.Success(it) }
                } else {
                    flowOf(result)
                }
            }
    }

    private fun getMusicflyFromServer(): Flow<RequestResult<Offers>> {
        val apiRequest : Flow<RequestResult<Offers>> = flow { emit(musicflyApi.getMusicFly()) }
            .onEach { result ->
                if (result.isSuccess) {
                    saveNetMusicflyToCache(result.getOrThrow().offers)
                }
            }
            .map { it.toRequestResult() }
            .map { it.map { offersDTO -> offersDTO.toOffers() } }
        val start = flowOf<RequestResult<Offers>>(RequestResult.InProgress())
        return merge(apiRequest, start)

    }

    private suspend fun saveNetMusicflyToCache(offers: List<OfferDTO>) {
        val dbos = offers.map { offer -> offer.toOfferDBO() }
        database.musicflyDao.insertOffer(dbos)
    }

    private fun getMusicflyFromDatabase(): Flow<RequestResult<Offers>> {
        val dbRequest = database.musicflyDao::getAllOffers.asFlow()
            .map<List<OfferDBO>, RequestResult<List<OfferDBO>>> { RequestResult.Success(it) }
        val start = flowOf<RequestResult<List<OfferDBO>>>(RequestResult.InProgress())
        return merge(start, dbRequest)
            .map { result ->
                result.map { offerDBOs->
                    offerDBOs.map { it.toOffer() }
                }
            }
            .map { result ->
                result.map { list ->
                    list.toOffer()
                }
            }
    }
}
private fun List<Offer>.toOffer() : Offers {
    return Offers(offers = this)
}