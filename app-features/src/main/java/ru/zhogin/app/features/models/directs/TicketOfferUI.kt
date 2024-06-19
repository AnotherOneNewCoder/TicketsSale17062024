package ru.zhogin.app.features.models.directs

import ru.zhogin.app.features.models.PriceUI

data class TicketOfferUI(
    val id: Int,
    val price: PriceUI,
    val timeRange: List<String>,
    val title: String
)