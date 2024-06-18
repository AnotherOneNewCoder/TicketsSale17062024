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
import ru.zhogin.app.api.TicketsApi
import ru.zhogin.app.api.models.tickets.TicketDTO
import ru.zhogin.app.database.TicketsDatabase
import ru.zhogin.app.database.models.tickets.TicketDBO
import ru.zhogin.app_data.models.tickets.Ticket
import ru.zhogin.app_data.models.tickets.Tickets
import javax.inject.Inject

class TicketsRepository @Inject constructor(
    private val database: TicketsDatabase,
    private val ticketsApi: TicketsApi,
    ) {
    @OptIn(ExperimentalCoroutinesApi::class)
    fun getTickets(
        mergeStrategy: MergeStrategy<RequestResult<Tickets>> = DefaultRequestResponseMereStrategy()
    ) : Flow<RequestResult<Tickets>> {
        val cachedTickets = getTicketsFromDatabase()
        val remoteTickets = getTicketsFromServer()

        return cachedTickets.combine(remoteTickets, mergeStrategy::merge)
            .flatMapLatest { result ->
                if (result is RequestResult.Success) {
                    database.ticketsDao.observeAllOffers()
                        .map { dbos ->
                            dbos.map { it.toTicket() }
                        }
                        .map { list -> list.toTickets() }
                        .map { RequestResult.Success(it) }
                } else {
                    flowOf(result)
                }
            }
    }

    private fun getTicketsFromServer() : Flow<RequestResult<Tickets>> {
        val apiTickets : Flow<RequestResult<Tickets>> = flow { emit(ticketsApi.getTickets()) }
            .onEach { result ->
                if (result.isSuccess) {
                    saveNetTicketsToCache(result.getOrThrow().tickets)
                }
            }
            .map { it.toRequestResult() }
            .map { it.map { ticketsDTO ->
                ticketsDTO.toTickets()
            } }
        val start = flowOf<RequestResult<Tickets>>(RequestResult.InProgress())
        return merge(apiTickets, start)
    }

    private suspend fun saveNetTicketsToCache(tickets: List<TicketDTO>) {
        val dbos = tickets.map { it.toTicketDBO() }
        database.ticketsDao.insertOffer(dbos)
    }

    private fun getTicketsFromDatabase() : Flow<RequestResult<Tickets>> {
        val dbRequest = database.ticketsDao::getAllOffers.asFlow()
            .map<List<TicketDBO>, RequestResult<List<TicketDBO>>> { RequestResult.Success(it) }
        val start = flowOf<RequestResult<List<TicketDBO>>>(RequestResult.InProgress())
        return merge(start, dbRequest)
            .map { result ->
                result.map { ticketDBOS ->
                    ticketDBOS.map { it.toTicket() }
                }
            }
            .map { result ->
                result.map { it.toTickets() }
            }
    }
}

private fun List<Ticket>.toTickets() : Tickets {
    return Tickets(tickets = this)
}