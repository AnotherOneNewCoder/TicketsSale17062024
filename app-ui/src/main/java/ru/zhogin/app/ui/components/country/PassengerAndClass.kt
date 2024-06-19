package ru.zhogin.app.ui.components.country

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import ru.zhogin.app.ui.R
import ru.zhogin.app.uikit.FirstEnterCardColor
import ru.zhogin.app.uikit.StrokeColor
import ru.zhogin.app.uikit.Text2

@Composable
internal fun PassengersAndClass() {
    Card(

        shape = RoundedCornerShape(67.dp),
        colors = CardDefaults.cardColors(
            containerColor = FirstEnterCardColor
        ),
    ) {
        Row(
            modifier = Modifier
                .padding(horizontal = 13.dp, vertical = 11.dp)

        ) {
            Icon(
                painter = painterResource(id = R.drawable.icon_pass),
                contentDescription = "icon", modifier = Modifier.size(21.dp), tint = StrokeColor
            )
            Spacer(modifier = Modifier.width(10.dp))
            Text(
                text = stringResource(id = R.string.pass_and_class),
                style = MaterialTheme.typography.Text2,
            )
        }
    }
}