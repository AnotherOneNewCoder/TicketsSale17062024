package ru.zhogin.app.ui.components.country

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import ru.zhogin.app.ui.R
import ru.zhogin.app.uikit.FirstEnterCardColor
import ru.zhogin.app.uikit.Text2
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
@Composable
internal fun FlyBack(
    onClick: () -> Unit,
    date: LocalDate,
    dateBack: LocalDate
) {
    val dayFormatter = DateTimeFormatter.ofPattern("dd MMM, EE")
    Card(
        modifier = Modifier.clickable(
            enabled = true,
            onClick = onClick
        ),
        shape = RoundedCornerShape(67.dp),
        colors = CardDefaults.cardColors(
            containerColor = FirstEnterCardColor
        ),
    ) {
        Row(
            modifier = Modifier.padding(start = 13.dp, top = 11.dp, bottom = 11.dp)
        ) {
            IconButton(onClick = onClick, modifier = Modifier.then(Modifier.size(21.dp))) {
                Icon(
                    imageVector = Icons.Rounded.Add, contentDescription = "Back",
                    tint = Color.White,
                )
            }
            Spacer(modifier = Modifier.width(10.dp))
            Text(
                text = if (dateBack < date) stringResource(id = R.string.tiket_back) else dateBack.format(
                    dayFormatter
                ),
                style = MaterialTheme.typography.Text2,

                )
            Spacer(modifier = Modifier.width(13.dp))
        }
    }
}