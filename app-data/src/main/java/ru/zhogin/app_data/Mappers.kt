package ru.zhogin.app_data

import ru.zhogin.app.api.models.directs.TicketOfferDTO
import ru.zhogin.app.api.models.directs.TicketOffersDTO
import ru.zhogin.app.api.models.musicfly.OfferDTO
import ru.zhogin.app.api.models.musicfly.OffersDTO
import ru.zhogin.app.api.models.musicfly.PriceDTO
import ru.zhogin.app.api.models.tickets.ArrivalDTO
import ru.zhogin.app.api.models.tickets.DepartureDTO
import ru.zhogin.app.api.models.tickets.HandLuggageDTO
import ru.zhogin.app.api.models.tickets.LuggageDTO
import ru.zhogin.app.api.models.tickets.PriceXDTO
import ru.zhogin.app.api.models.tickets.TicketDTO
import ru.zhogin.app.api.models.tickets.TicketsDTO
import ru.zhogin.app.database.models.PriceDBO
import ru.zhogin.app.database.models.directs.TicketOfferDBO
import ru.zhogin.app.database.models.musicfly.OfferDBO
import ru.zhogin.app.database.models.tickets.ArrivalDBO
import ru.zhogin.app.database.models.tickets.DepartureDBO
import ru.zhogin.app.database.models.tickets.HandLuggageDBO
import ru.zhogin.app.database.models.tickets.LuggageDBO
import ru.zhogin.app.database.models.tickets.PriceXDBO
import ru.zhogin.app.database.models.tickets.TicketDBO
import ru.zhogin.app.database.utils.GsonConverter.toJson
import ru.zhogin.app.database.utils.GsonConverter.toType
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

internal fun OffersDTO.toOffers() : Offers {
    return Offers(
        offers = offers.map { it.toOffer() }
    )
}

internal fun OfferDTO.toOffer() : Offer {
    return Offer(
        id = id,
        price = price.toPrice(),
        title = title,
        town = town,
    )
}

internal fun TicketOffersDTO.toTicketOffers() : TicketOffers {
    return TicketOffers(
        ticketsOffers = ticketOffer.map { it.toTicketOffer() }
    )
}

internal fun TicketOfferDTO.toTicketOffer() : TicketOffer {
    return TicketOffer(
        id = id,
        price = price.toPrice(),
        timeRange = timeRange,
        title = title,
    )
}

private fun PriceDTO.toPrice() : Price {
    return Price(
        value = value
    )
}

internal fun TicketsDTO.toTickets() : Tickets {
    return Tickets(
        tickets = tickets.map { it.toTicket() }
    )
}

internal fun TicketDTO.toTicket() : Ticket {
    return Ticket(
        arrival = arrival.toArrival(),
        badge = badge,
        company = company,
        departure = departure.toDeparture(),
        handLuggage = handLuggage.toHandLuggage(),
        hasTransfer = hasTransfer,
        hasVisaTransfer = hasVisaTransfer,
        id = id,
        isExchangable = isExchangable,
        isReturnable = isReturnable,
        luggage = luggage.toLuggage(),
        price = price.toPriceX(),
        providerName = providerName,
    )
}

private fun ArrivalDTO.toArrival() : Arrival {
    return Arrival(
        airport = airport,
        date = date,
        town = town,
    )
}

private fun DepartureDTO.toDeparture() : Departure {
    return Departure(
        airport = airport,
        date = date,
        town = town,
    )
}

private fun HandLuggageDTO.toHandLuggage() : HandLuggage {
    return HandLuggage(
        hasHandLuggage = hasHandLuggage,
        size = size,
    )
}

private fun LuggageDTO.toLuggage() : Luggage {
    return Luggage(
        hasLuggage = hasLuggage,
        price = price?.toPriceX()
    )
}

private fun PriceXDTO.toPriceX() : PriceX {
    return PriceX(
        value = value
    )
}

internal fun TicketDTO.toTicketDBO() : TicketDBO {
    return TicketDBO(
        arrival = arrival.toArrivalDBO(),
        badge = badge,
        company = company,
        departure = departure.toDepartureDBO(),
        handLuggage = handLuggage.toHandLuggageDBO(),
        hasTransfer = hasTransfer,
        hasVisaTransfer = hasVisaTransfer,
        id = id,
        isExchangable = isExchangable,
        isReturnable = isReturnable,
        luggage = luggage.toLuggageDBO(),
        price = price.toPriceXDBO(),
        providerName = providerName,
    )
}

private fun ArrivalDTO.toArrivalDBO() : ArrivalDBO {
    return ArrivalDBO(
        airport = airport,
        date = date,
        town = town,
    )
}

private fun DepartureDTO.toDepartureDBO() : DepartureDBO {
    return DepartureDBO(
        airport = airport,
        date = date,
        town = town,
    )
}

private fun HandLuggageDTO.toHandLuggageDBO() : HandLuggageDBO {
    return HandLuggageDBO(
        hasHandLuggage = hasHandLuggage,
        size = size,
    )
}

private fun LuggageDTO.toLuggageDBO() : LuggageDBO {
    return LuggageDBO(
        hasLuggage = hasLuggage,
        price = price?.toPriceXDBO()
    )
}

private fun PriceXDTO.toPriceXDBO() : PriceXDBO {
    return PriceXDBO(
        value = value
    )
}

internal fun TicketOfferDTO.toTicketOfferDBO() : TicketOfferDBO {
    return TicketOfferDBO(
        id = id,
        price = price.toPriceDBO(),
        timeRange = timeRange.toJson(),
        title = title,
    )
}

internal fun OfferDTO.toOfferDBO() : OfferDBO {
    return OfferDBO(
        id = id,
        price = price.toPriceDBO(),
        title = title,
        town = town
    )
}

private fun PriceDTO.toPriceDBO() : PriceDBO {
    return PriceDBO(
        value = value
    )
}

internal fun TicketDBO.toTicket() : Ticket {
    return Ticket(
        arrival = arrival.toArrival(),
        badge = badge,
        company = company,
        departure = departure.toDeparture(),
        handLuggage = handLuggage.toHandLuggage(),
        hasTransfer = hasTransfer,
        hasVisaTransfer = hasVisaTransfer,
        id = id,
        isExchangable = isExchangable,
        isReturnable = isReturnable,
        luggage = luggage.toLuggage(),
        price = price.toPriceX(),
        providerName = providerName,
    )
}
private fun PriceXDBO.toPriceX() : PriceX {
    return PriceX(
        value = value
    )
}

private fun LuggageDBO.toLuggage() : Luggage {
    return Luggage(
        hasLuggage = hasLuggage,
        price = price?.toPriceX()
    )
}

private fun HandLuggageDBO.toHandLuggage() : HandLuggage {
    return HandLuggage(
        hasHandLuggage = hasHandLuggage,
        size = size,
    )
}

private fun DepartureDBO.toDeparture() : Departure {
    return Departure(
        airport = airport,
        date = date,
        town = town,
    )
}

private fun ArrivalDBO.toArrival() : Arrival {
    return Arrival(
        airport = airport,
        date = date,
        town = town,
    )
}

internal fun TicketOfferDBO.toTicketOffer() : TicketOffer {
    return TicketOffer(
        id = id,
        price = price.toPrice(),
        timeRange = timeRange.toType(),
        title = title,
    )
}

internal fun OfferDBO.toOffer() : Offer {
    return Offer(
        id = id,
        price = price.toPrice(),
        title = title,
        town = town,
    )
}

private fun PriceDBO.toPrice() : Price {
    return Price(
        value = value
    )
}