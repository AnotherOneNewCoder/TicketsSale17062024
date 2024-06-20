package ru.zhogin.app.ui.components.country

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import ru.zhogin.app.ui.R
import ru.zhogin.app.uikit.FirstEnterCardColor
import ru.zhogin.app.uikit.SecondEnterCardColor

@Composable
internal fun TrackList(destFrom: String, destTo: String, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            //.padding(top = 62.dp)
            .padding(horizontal = 21.dp),
        shape = RoundedCornerShape(21.dp),
        colors = CardDefaults.cardColors(
            containerColor = FirstEnterCardColor
        ),
    ) {
        Row {
            IconButton(onClick = { }, modifier = Modifier //.then(Modifier.size(32.dp))
                .padding(start = 11.dp, top = 38.dp)
            ) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack, contentDescription = "Back",
                    tint = Color.White, modifier = Modifier.size(32.dp)
                )
            }
            Spacer(modifier = Modifier.width(10.dp))
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 21.dp)
            ) {
                Spacer(modifier = Modifier.height(21.dp))
                DestinationField(
                    destFrom, R.drawable.icon_reverse, onClick = onClick

                )
                Spacer(modifier = Modifier.height(10.dp))
                Divider(
                    color = SecondEnterCardColor, thickness = 1.dp,
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(10.dp))
                DestinationField(destinationFrom = destTo, icon = R.drawable.icon_x, onClick = {

                })
                Spacer(modifier = Modifier.height(21.dp))
            }

        }



    }
}