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
import ru.zhogin.app.api.DirectsApi
import ru.zhogin.app.api.models.directs.TicketOfferDTO
import ru.zhogin.app.database.TicketsDatabase
import ru.zhogin.app.database.models.directs.TicketOfferDBO
import ru.zhogin.app_data.models.directs.TicketOffer
import ru.zhogin.app_data.models.directs.TicketOffers
import javax.inject.Inject

class DirectsRepository @Inject constructor(
    private val database: TicketsDatabase,
    private val directsApi: DirectsApi,
    ) {
    @OptIn(ExperimentalCoroutinesApi::class)
    fun getDirects(
        mergeStrategy: MergeStrategy<RequestResult<TicketOffers>> = DefaultRequestResponseMereStrategy()
    ) : Flow<RequestResult<TicketOffers>> {
        val cachedDirects = getDirectsFromDatabase()
        val remoteDirects = getDirectsFromServer()

        return cachedDirects.combine(remoteDirects, mergeStrategy::merge)
            .flatMapLatest { result ->
                if (result is RequestResult.Success) {
                    database.directsDao.observeAllDirects()
                        .map { dbos -> dbos.map { it.toTicketOffer() } }
                        .map { list -> list.toTicketsOffers() }
                        .map { RequestResult.Success(it) }
                } else {
                    flowOf(result)
                }
            }
    }
    private fun getDirectsFromServer() : Flow<RequestResult<TicketOffers>> {
        val apiDirectsRequest : Flow<RequestResult<TicketOffers>> = flow { emit(directsApi.getDirects()) }
            .onEach { result ->
                if (result.isSuccess) {
                    saveNetDirectsToCache(result.getOrThrow().ticketOffer)
                }
            }
            .map { it.toRequestResult() }
            .map { it.map { ticketOffersDTO -> ticketOffersDTO.toTicketOffers() } }
        val start = flowOf<RequestResult<TicketOffers>>(RequestResult.InProgress())
        return merge(apiDirectsRequest, start)
    }

    private suspend fun saveNetDirectsToCache(ticketOffers: List<TicketOfferDTO>) {
        val dbos = ticketOffers.map { it.toTicketOfferDBO() }
        database.directsDao.insertDirect(dbos)
    }

    private fun getDirectsFromDatabase() : Flow<RequestResult<TicketOffers>> {
        val dbRequest = database.directsDao::getAllDirects.asFlow()
            .map<List<TicketOfferDBO>, RequestResult<List<TicketOfferDBO>>> { RequestResult.Success(it) }
        val start = flowOf<RequestResult<List<TicketOfferDBO>>>(RequestResult.InProgress())
        return merge(start, dbRequest)
            .map { result ->
                result.map { ticketOfferDBOS ->
                    ticketOfferDBOS.map { it.toTicketOffer() }
                }
            }
            .map { result ->
                result.map { it.toTicketsOffers() }
            }
    }
}
private fun List<TicketOffer>.toTicketsOffers() : TicketOffers {
    return TicketOffers(ticketsOffers = this)
}