package ru.zhogin.app.ui.components.avia

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import ru.zhogin.app.features.models.musicfly.OfferUI
import ru.zhogin.app.ui.R
import ru.zhogin.app.ui.screens.addCharAtIndex
import ru.zhogin.app.uikit.HintTextColor
import ru.zhogin.app.uikit.Title3
import ru.zhogin.app.uikit.Title4

@Composable
internal fun MusicFly(offer: OfferUI, image: Int) {
    Column(
        modifier = Modifier.padding(start = if (offer.id != 1) 89.dp else 0.dp)
    ) {
        Card(
            modifier = Modifier.size(176.dp),
            shape = RoundedCornerShape(21.dp)
        ) {
            Image(
                painter = painterResource(id = image), contentDescription = "image",
                contentScale = ContentScale.FillBounds
            )
        }
        Spacer(modifier = Modifier.height(11.dp))
        Text(
            text = offer.title,
            style = MaterialTheme.typography.Title3,
        )
        Spacer(modifier = Modifier.height(11.dp))
        Text(
            text = offer.town,
            style = MaterialTheme.typography.Title4,
        )
        Spacer(modifier = Modifier.height(5.dp))
        Row {
            Icon(
                painter = painterResource(id = R.drawable.icon_plane),
                contentDescription = "icon", tint = HintTextColor,
                modifier = Modifier.size(32.dp)
            )
            Text(
                text = "от " + offer.price.value.toString().addCharAtIndex(' ', 1) + " " + "₽",
                style = MaterialTheme.typography.Title4,
            )
        }
    }
}