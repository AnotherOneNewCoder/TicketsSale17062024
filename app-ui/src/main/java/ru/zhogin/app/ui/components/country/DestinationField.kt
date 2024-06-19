package ru.zhogin.app.ui.components.country

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import ru.zhogin.app.uikit.Title3

@Composable
internal fun DestinationField(destinationFrom: String, icon: Int, onClick: () -> Unit) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Text(
            text = destinationFrom,
            style = MaterialTheme.typography.Title3,
        )
        IconButton(
            modifier = Modifier.then(Modifier.size(32.dp)),
            onClick = onClick,
        )
        {
            Icon(
                painter = painterResource(id = icon),
                contentDescription = "icon", tint = Color.White,
                modifier = Modifier.size(32.dp)
            )
        }
    }
}