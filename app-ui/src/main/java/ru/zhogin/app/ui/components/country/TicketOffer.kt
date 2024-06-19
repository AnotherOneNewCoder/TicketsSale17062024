package ru.zhogin.app.ui.components.country

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import ru.zhogin.app.features.models.directs.TicketOfferUI
import ru.zhogin.app.ui.R
import ru.zhogin.app.ui.screens.addCharAtIndex
import ru.zhogin.app.uikit.RedRectangle
import ru.zhogin.app.uikit.SecondEnterCardColor
import ru.zhogin.app.uikit.SpecialBlue
import ru.zhogin.app.uikit.Text2
import ru.zhogin.app.uikit.Title4

@Composable
internal fun TicketOffer(
    offer: TicketOfferUI
) {
    Column {

        Spacer(modifier = Modifier.height(21.dp))
        Row {
            Box {
                Icon(
                    painter = painterResource(
                        id = R.drawable.icon_rectangle
                    ),
                    contentDescription = "rectangle",
                    modifier = Modifier.size(32.dp),
                    tint = when (offer.id) {
                        1 -> RedRectangle
                        10 -> SpecialBlue
                        30 -> Color.White
                        else -> Color.Transparent
                    }
                )

            }
            Spacer(modifier = Modifier.width(10.dp))
            Column {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = offer.title,
                        style = MaterialTheme.typography.Text2,
                    )
                    Box {
                        Row {
                            Text(
                                text = offer.price.value.toString()
                                    .addCharAtIndex(' ', 1) + " " + "₽",
                                style = MaterialTheme.typography.Text2,
                                color = SpecialBlue,
                            )
                            Icon(
                                painter = painterResource(id = R.drawable.icon_right_arrow),
                                contentDescription = "arrow",
                                modifier = Modifier.size(21.dp),
                                tint = SpecialBlue
                            )
                        }
                    }
                }
                Spacer(modifier = Modifier.height(5.dp))
                Row(
                    modifier = Modifier
                        .height(23.dp)

                ) {
                    for (i in offer.timeRange) {
                        Text(
                            text = i + " ",
                            style = MaterialTheme.typography.Title4,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                }

            }
        }



        Spacer(modifier = Modifier.height(13.dp))
        Divider(
            color = SecondEnterCardColor, thickness = 1.dp,
            modifier = Modifier.fillMaxWidth()
        )

    }
}