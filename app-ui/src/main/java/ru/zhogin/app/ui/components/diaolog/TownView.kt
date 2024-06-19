package ru.zhogin.app.ui.components.diaolog

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import ru.zhogin.app.ui.R
import ru.zhogin.app.uikit.StrokeColor
import ru.zhogin.app.uikit.Title3
import ru.zhogin.app.uikit.Title4

@Composable
internal fun TownView(icon: Int, text: String, onChoosePopular:(String) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(
                enabled = true,
                onClick = {
                    onChoosePopular(text)
                }
            )
    ) {
        Card(
            modifier = Modifier
                .padding(vertical = 10.dp)
                .size(53.dp),
            shape = RoundedCornerShape(10.dp)
        ) {
            Image(
                painter = painterResource(id = icon), contentDescription = "image",
                contentScale = ContentScale.FillBounds
            )
        }
        Spacer(modifier = Modifier.width(10.dp))
        Column(
            modifier = Modifier
                .padding(vertical = 10.dp)
        ) {
            Text(
                text = text,
                style = MaterialTheme.typography.Title3,
            )
            Spacer(modifier = Modifier.height(5.dp))
            Text(
                text = stringResource(id = R.string.popular_direction),
                style = MaterialTheme.typography.Title4,
                color = StrokeColor,
            )
        }

    }
    Divider(
        color = StrokeColor, thickness = 1.dp, modifier = Modifier
            .fillMaxWidth()
    )

}
