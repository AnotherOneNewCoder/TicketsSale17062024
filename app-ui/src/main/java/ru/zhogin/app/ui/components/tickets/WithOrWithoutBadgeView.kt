package ru.zhogin.app.ui.components.tickets

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import ru.zhogin.app.features.models.tickets.TicketUI
import ru.zhogin.app.ui.R
import ru.zhogin.app.ui.screens.addCharAtIndex
import ru.zhogin.app.ui.utils.calculateDurationInHours
import ru.zhogin.app.ui.utils.getHours
import ru.zhogin.app.uikit.HintTextColor
import ru.zhogin.app.uikit.RedRectangle
import ru.zhogin.app.uikit.Text2
import ru.zhogin.app.uikit.ThirdEnterCardColor
import ru.zhogin.app.uikit.Title1
import ru.zhogin.app.uikit.Title4

@RequiresApi(Build.VERSION_CODES.O)
@Composable
internal fun WithOrWithoutBadgeView(ticket: TicketUI) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = if (ticket.badge == null) 0.dp else 11.dp),
        backgroundColor = ThirdEnterCardColor,
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
                    Spacer(modifier = Modifier.width(21.dp))
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