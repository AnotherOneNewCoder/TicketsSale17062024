package ru.zhogin.app.ui.components.country

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.zhogin.app.uikit.FirstEnterCardColor
import ru.zhogin.app.uikit.Text2
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
@Composable
internal fun DateFrom(
    date: LocalDate,
    onDateClicked: () -> Unit,
) {
    val dayFormatter = DateTimeFormatter.ofPattern("dd MMM, EE")
    Card(
        modifier = Modifier.clickable(
            enabled = true,
            onClick = onDateClicked
        ),
        shape = RoundedCornerShape(67.dp),
        colors = CardDefaults.cardColors(
            containerColor = FirstEnterCardColor
        ),
    ) {
        Row(
            modifier = Modifier.padding(horizontal = 13.dp, vertical = 11.dp)
        ) {
            Text(
                text = date.format(dayFormatter),
                style = MaterialTheme.typography.Text2,
            )
        }
    }
}