package ru.zhogin.app.features.states

import ru.zhogin.app.features.models.tickets.TicketsUI

sealed class StateTickets(val tickets: TicketsUI?) {
    data object None : StateTickets(tickets = null)
    class Loading(tickets: TicketsUI? = null) : StateTickets(tickets)
    class Error(tickets: TicketsUI? = null) : StateTickets(tickets)
    class Success(tickets: TicketsUI) : StateTickets(tickets)
}