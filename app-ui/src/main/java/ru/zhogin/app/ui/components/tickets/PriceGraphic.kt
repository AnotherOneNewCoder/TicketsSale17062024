package ru.zhogin.app.ui.components.tickets

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import ru.zhogin.app.ui.R
import ru.zhogin.app.uikit.SpecialBlue
import ru.zhogin.app.uikit.Text2

@Composable
internal fun PriceGraphic() {
    Card(
        shape = RoundedCornerShape(67.dp),
        backgroundColor = SpecialBlue,
    ) {
        Row(modifier = Modifier.padding(13.dp)) {
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