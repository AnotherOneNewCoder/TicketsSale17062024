package ru.zhogin.app.features.states

import ru.zhogin.app.features.models.directs.TicketOffersUI

sealed class StateDirects(val ticketsOffers: TicketOffersUI?) {
    data object None : StateDirects(ticketsOffers = null)
    class Loading(ticketsOffers: TicketOffersUI? = null) : StateDirects(ticketsOffers)
    class Error(ticketsOffers: TicketOffersUI? = null) : StateDirects(ticketsOffers)
    class Success(ticketsOffers: TicketOffersUI) : StateDirects(ticketsOffers)
}