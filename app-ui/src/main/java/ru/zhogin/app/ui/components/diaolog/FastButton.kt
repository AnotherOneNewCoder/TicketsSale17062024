package ru.zhogin.app.ui.components.diaolog

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import ru.zhogin.app.uikit.SearchDialogBG
import ru.zhogin.app.uikit.Title4

@Composable
internal fun FastButton(image: Int, text: String, onClick: () -> Unit) {
    Column(
        modifier = Modifier
            .widthIn(min = 86.dp, max = 105.dp)
            .clickable(
                enabled = true,
                onClick = onClick
            )
        ,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card(
            //modifier = Modifier.padding(horizontal = 10.dp),
            shape = RoundedCornerShape(11.dp),
            colors = CardDefaults.cardColors(
                containerColor = SearchDialogBG
            ),
        ) {
            Image(
                painter = painterResource(id = image), contentDescription = "Image",
                modifier = Modifier.size(64.dp), contentScale = ContentScale.FillBounds
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        Text(text = text, style = MaterialTheme.typography.Title4, textAlign = TextAlign.Center,)


    }
}