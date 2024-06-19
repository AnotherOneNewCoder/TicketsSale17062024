package ru.zhogin.app.features

import ru.zhogin.app.features.models.PriceUI
import ru.zhogin.app.features.models.directs.TicketOfferUI
import ru.zhogin.app.features.models.directs.TicketOffersUI
import ru.zhogin.app.features.models.musicfly.OfferUI
import ru.zhogin.app.features.models.musicfly.OffersUI
import ru.zhogin.app.features.models.tickets.ArrivalUI
import ru.zhogin.app.features.models.tickets.DepartureUI
import ru.zhogin.app.features.models.tickets.HandLuggageUI
import ru.zhogin.app.features.models.tickets.LuggageUI
import ru.zhogin.app.features.models.tickets.PriceXUI
import ru.zhogin.app.features.models.tickets.TicketUI
import ru.zhogin.app.features.models.tickets.TicketsUI
import ru.zhogin.app_data.models.Price
import ru.zhogin.app_data.models.directs.TicketOffer
import ru.zhogin.app_data.models.directs.TicketOffers
import ru.zhogin.app_data.models.musicfly.Offer
import ru.zhogin.app_data.models.musicfly.Offers
import ru.zhogin.app_data.models.tickets.Arrival
import ru.zhogin.app_data.models.tickets.Departure
import ru.zhogin.app_data.models.tickets.HandLuggage
import ru.zhogin.app_data.models.tickets.Luggage
import ru.zhogin.app_data.models.tickets.PriceX
import ru.zhogin.app_data.models.tickets.Ticket
import ru.zhogin.app_data.models.tickets.Tickets

internal fun Tickets.toTicketsUI() : TicketsUI {
    return TicketsUI(
        tickets = tickets.map {
            it.toTicketUI()
        }
    )
}

private fun Ticket.toTicketUI() : TicketUI {
    return TicketUI(
        arrival = arrival.toArrivalUI(),
        badge = badge,
        company = company,
        departure = departure.toDepartureUI(),
        handLuggage = handLuggage.toHandLuggageUI(),
        hasTransfer = hasTransfer,
        hasVisaTransfer = hasVisaTransfer,
        id = id,
        isExchangable = isExchangable,
        isReturnable = isReturnable,
        luggage = luggage.toLuggageUI(),
        price = price.toPriceXUI(),
        providerName = providerName,
    )
}

private fun Arrival.toArrivalUI() : ArrivalUI {
    return ArrivalUI(
        airport = airport,
        date = date,
        town = town,
    )
}

private fun Departure.toDepartureUI() : DepartureUI {
    return DepartureUI(
        airport = airport,
        date = date,
        town = town,
    )
}

private fun HandLuggage.toHandLuggageUI() : HandLuggageUI {
    return HandLuggageUI(
        hasHandLuggage = hasHandLuggage,
        size = size
    )
}

private fun Luggage.toLuggageUI() : LuggageUI {
    return LuggageUI(
        hasLuggage = hasLuggage,
        price = price?.toPriceXUI()
    )
}

private fun PriceX.toPriceXUI() : PriceXUI {
    return PriceXUI(
        value = value
    )
}

internal fun Offers.toOffersUI() : OffersUI {
    return OffersUI(
        offers = offers.map { it.toOfferUI() }
    )
}

private fun Offer.toOfferUI() : OfferUI {
    return OfferUI(
        id = id,
        price = price.toPriceUI(),
        title = title,
        town = town
    )
}

internal fun TicketOffers.toTicketOffersUI() : TicketOffersUI {
    return TicketOffersUI(
        ticketsOffers = ticketsOffers.map {
            it.toTicketOfferUI()
        }
    )
}

private fun TicketOffer.toTicketOfferUI() : TicketOfferUI {
    return TicketOfferUI(
        id = id,
        price = price.toPriceUI(),
        timeRange = timeRange,
        title = title,
    )
}

private fun Price.toPriceUI() : PriceUI {
    return PriceUI(
        value = value
    )
}
