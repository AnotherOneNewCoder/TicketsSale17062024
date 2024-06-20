package ru.zhogin.app.ui.components.tickets

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.zhogin.app.features.models.tickets.TicketUI

@RequiresApi(Build.VERSION_CODES.O)
@Composable
internal fun TicketsList(listTickets: List<TicketUI>) {
    LazyColumn {
        items(listTickets.size) { index ->
            TicketView(listTickets[index])
            Spacer(modifier = Modifier.height(21.dp))
        }
    }
}