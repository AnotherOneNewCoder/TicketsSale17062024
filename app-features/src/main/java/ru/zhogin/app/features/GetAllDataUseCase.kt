package ru.zhogin.app.features

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import ru.zhogin.app.features.models.directs.TicketOffersUI
import ru.zhogin.app.features.models.musicfly.OffersUI
import ru.zhogin.app.features.models.tickets.TicketsUI
import ru.zhogin.app_data.DirectsRepository
import ru.zhogin.app_data.MusicflyRepository
import ru.zhogin.app_data.RequestResult
import ru.zhogin.app_data.TicketsRepository
import ru.zhogin.app_data.map
import javax.inject.Inject

class GetAllDataUseCase @Inject constructor(
    private val musicflyRepository: MusicflyRepository,
    private val directsRepository: DirectsRepository,
    private val ticketsRepository: TicketsRepository,
) {
    fun invokeMusicfly() : Flow<RequestResult<OffersUI>> {
        return musicflyRepository.getMusicfly()
            .map { requestResult ->
                requestResult.map { offers ->
                    offers.toOffersUI()
                }
            }
    }

    fun invokeDirects() : Flow<RequestResult<TicketOffersUI>> {
        return directsRepository.getDirects()
            .map { requestResult ->
                requestResult.map { ticketOffers ->
                    ticketOffers.toTicketOffersUI()
                }
            }
    }
    fun invokeTickets() : Flow<RequestResult<TicketsUI>> {
        return ticketsRepository.getTickets()
            .map { requestResult ->
                requestResult.map { tickets ->
                    tickets.toTicketsUI()
                }
            }
    }
}