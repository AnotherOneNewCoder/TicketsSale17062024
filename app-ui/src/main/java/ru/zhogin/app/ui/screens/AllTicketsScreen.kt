package ru.zhogin.app.ui.screens

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import ru.zhogin.app.features.models.tickets.TicketUI
import ru.zhogin.app.ui.components.tickets.PriceGraphic
import ru.zhogin.app.ui.components.tickets.TicketsList
import ru.zhogin.app.ui.components.tickets.TrackList
import java.time.LocalDate

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun AllTicketsScreen(
    listTickets: List<TicketUI>,
    destFrom: String,
    destTo: String,
    date: LocalDate,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Card(
        modifier = modifier.fillMaxSize(),
        backgroundColor = Color.Black,
        shape = RoundedCornerShape(0.dp),
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 21.dp),
        ) {
            Spacer(modifier = Modifier.height(21.dp))
            TrackList(destFrom = destFrom, destTo = destTo, date = date, onClick)
            Spacer(modifier = Modifier.height(37.dp))
            TicketsList(listTickets)

        }
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.BottomCenter
        ) {
            PriceGraphic()
        }

    }
}