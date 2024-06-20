package ru.zhogin.app.ui.components.tickets

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import ru.zhogin.app.features.models.tickets.TicketUI

@RequiresApi(Build.VERSION_CODES.O)
@Composable
internal fun TicketView(ticket: TicketUI) {
    val isBadge = (ticket.badge != null)

    if (isBadge) {
        Box(
            modifier = Modifier.fillMaxWidth()
        ) {
            WithOrWithoutBadgeView(ticket)
            BadgeView(ticket.badge.toString())
        }
    } else {
        WithOrWithoutBadgeView(ticket)
    }
}