package ru.zhogin.app.ui.components.country

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import ru.zhogin.app.features.models.directs.TicketOfferUI
import ru.zhogin.app.ui.R
import ru.zhogin.app.uikit.ThirdEnterCardColor
import ru.zhogin.app.uikit.Title2

@Composable
internal fun DirectFlights(
    ticketsOffers: List<TicketOfferUI>,
) {
    Card(
        shape = RoundedCornerShape(21.dp),
        colors = CardDefaults.cardColors(
            containerColor = ThirdEnterCardColor
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 21.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 21.dp)
        ) {
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = stringResource(id = R.string.direct_flights),
                style = MaterialTheme.typography.Title2,
            )

            LazyColumn {
                items(3) { index ->
                    TicketOffer(ticketsOffers[index])
                }
            }
            Spacer(modifier = Modifier.height(21.dp))
        }

    }
}