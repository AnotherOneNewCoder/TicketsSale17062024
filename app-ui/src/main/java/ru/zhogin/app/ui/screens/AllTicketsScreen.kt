package ru.zhogin.app.ui.screens

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import ru.zhogin.app.features.models.tickets.TicketUI
import ru.zhogin.app.ui.R
import ru.zhogin.app.ui.utils.calculateDurationInHours
import ru.zhogin.app.ui.utils.getHours
import ru.zhogin.app.uikit.HintTextColor
import ru.zhogin.app.uikit.RedRectangle
import ru.zhogin.app.uikit.SearchDialogBG
import ru.zhogin.app.uikit.SpecialBlue
import ru.zhogin.app.uikit.Text2
import ru.zhogin.app.uikit.ThirdEnterCardColor
import ru.zhogin.app.uikit.Title1
import ru.zhogin.app.uikit.Title3
import ru.zhogin.app.uikit.Title4
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun AllTicketsScreen(
    listTickets: List<TicketUI>,
    destFrom: String,
    destTo: String,
    date: LocalDate,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier.fillMaxSize().padding(bottom = 72.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.Black
        ),
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

@Composable
private fun PriceGraphic() {
    Box(modifier = Modifier.padding(bottom = 21.dp)) {
        Card(
            shape = RoundedCornerShape(67.dp),
            colors = CardDefaults.cardColors(
                containerColor = SpecialBlue
            ),
        ) {
            Row(modifier = Modifier.padding(21.dp)) {
                Icon(
                    painter = painterResource(id = R.drawable.icon_filters),
                    contentDescription = "icon", modifier = Modifier.size(21.dp), tint = Color.White
                )
                Spacer(modifier = Modifier.width(5.dp))
                Text(
                    text = stringResource(R.string.filter),
                    style = MaterialTheme.typography.Text2,
                )
                Spacer(modifier = Modifier.width(21.dp))
                Icon(
                    painter = painterResource(id = R.drawable.icon_graphic),
                    contentDescription = "icon", modifier = Modifier.size(21.dp), tint = Color.White
                )
                Spacer(modifier = Modifier.width(5.dp))
                Text(
                    text = stringResource(R.string.prise_graphic),
                    style = MaterialTheme.typography.Text2,
                )
            }

        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun TicketsList(listTickets: List<TicketUI>) {
    LazyColumn {
        items(listTickets.size) { index ->
            TicketView(listTickets[index])
            Spacer(modifier = Modifier.height(21.dp))
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun TicketView(ticket: TicketUI) {
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

@RequiresApi(Build.VERSION_CODES.O)
@Composable
internal fun WithOrWithoutBadgeView(ticket: TicketUI) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = if (ticket.badge == null) 0.dp else 11.dp),
        colors = CardDefaults.cardColors(
            containerColor = ThirdEnterCardColor
        ),

    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 21.dp)
        ) {
            Spacer(modifier = Modifier.height(21.dp))
            Text(
                text = if (ticket.price.value.toString().length < 5)
                    ticket.price.value.toString().addCharAtIndex(' ', 1) + " " + "₽"
                else ticket.price.value.toString().addCharAtIndex(' ', 2) + " " + "₽",
                style = MaterialTheme.typography.Title1,
            )
            Spacer(modifier = Modifier.height(21.dp))
            Row(
                modifier = Modifier
                    .padding(start = 42.dp)
                    .horizontalScroll(rememberScrollState())
            ) {
                Text(
                    text = ticket.departure.date.getHours(),
                    style = MaterialTheme.typography.Text2,
                )
                Spacer(modifier = Modifier.width(2.dp))
                Divider(
                    color = HintTextColor, thickness = 1.dp,
                    modifier = Modifier
                        .width(13.dp)
                        .padding(top = 12.dp)
                )
                Spacer(modifier = Modifier.width(5.dp))
                Text(
                    text = ticket.arrival.date.getHours(),
                    style = MaterialTheme.typography.Text2,
                )
                Spacer(modifier = Modifier.width(17.dp))
                Text(
                    text = calculateDurationInHours(
                        ticket.departure.date,
                        ticket.arrival.date
                    ) + stringResource(
                        R.string.hour_in_road
                    ), style = MaterialTheme.typography.Title4,
                )
                if (!ticket.hasTransfer) {
                    Text(
                        text = stringResource(R.string.without_transfer),
                        style = MaterialTheme.typography.Title4,
                    )
                }
            }
            Spacer(modifier = Modifier.height(5.dp))
            Row(
                modifier = Modifier
                    .padding(start = 42.dp)
            ) {
                Text(
                    text = ticket.departure.airport,
                    style = MaterialTheme.typography.Text2,
                    color = HintTextColor
                )
                Spacer(modifier = Modifier.width(33.dp))
                Text(
                    text = ticket.arrival.airport,
                    style = MaterialTheme.typography.Text2,
                    color = HintTextColor
                )
            }
            Spacer(modifier = Modifier.height(30.dp))

        }
        Box(modifier = Modifier.padding(start = 21.dp, top = 86.dp)) {
            Icon(
                painter = painterResource(
                    id = R.drawable.icon_rectangle
                ),
                contentDescription = "rectangle",
                modifier = Modifier.size(32.dp),
                tint = RedRectangle,
            )
        }

    }
}

@Composable
internal fun BadgeView(text: String) {
    Card(
        shape = RoundedCornerShape(67.dp),
        colors = CardDefaults.cardColors(
            containerColor = SpecialBlue
        ),
    ) {
        Spacer(modifier = Modifier.height(3.dp))
        Text(
            text = text,
            style = MaterialTheme.typography.Text2,
            modifier = Modifier.padding(horizontal = 13.dp)
        )
        Spacer(modifier = Modifier.height(3.dp))
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
internal fun TrackList(destFrom: String, destTo: String, date: LocalDate, onClick: () -> Unit) {
    val dayFormatter = DateTimeFormatter.ofPattern("dd MMMM")
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = SearchDialogBG
        ),
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 43.dp, end = 21.dp)
        ) {
            Spacer(modifier = Modifier.height(11.dp))
            Text(
                text = "$destFrom-$destTo",
                style = MaterialTheme.typography.Title3,
            )
            Spacer(modifier = Modifier.height(5.dp))

            Text(
                text = date.format(dayFormatter) + stringResource(R.string.one_pass),
                style = MaterialTheme.typography.Text2,
                color = HintTextColor,
            )
            Spacer(modifier = Modifier.height(11.dp))
        }
        Box(
            modifier = Modifier.padding(top = 21.dp)
        ) {
            IconButton(onClick = onClick, modifier = Modifier.then(Modifier.size(32.dp))) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack, contentDescription = "Back",
                    tint = SpecialBlue, modifier = Modifier.size(32.dp)
                )
            }
        }

    }
}