package ru.zhogin.app.ui.components.avia

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import ru.zhogin.app.uikit.Title1

@Composable
internal fun HardCodedText(
    text: String,
    center: Boolean,
) {
    Column(
        modifier = if (center) Modifier.padding(top = 37.dp)
            .width(229.dp)
            .height(69.dp)
            .background(Color.Black)
        else Modifier
            .fillMaxWidth()
            .padding(start = 21.dp)
            .height(35.dp)
            .background(Color.Black),
        horizontalAlignment = if (center) Alignment.CenterHorizontally else Alignment.Start,
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.Title1,
            color = Color.White,
            textAlign = if (center) TextAlign.Center else TextAlign.Start,
        )
    }
}
//@Composable
//internal fun HardCodedText(
//    text: String,
//    center: Boolean,
//) {
//    Box(
//        modifier = if (center) Modifier.padding(top = 37.dp)
//            .width(229.dp)
//            .height(69.dp)
//            .background(Color.Black)
//        else Modifier
//            .fillMaxWidth()
//            .padding(start = 21.dp)
//            .height(35.dp)
//            .background(Color.Black),
//        contentAlignment = if (center) Alignment.Center else Alignment.CenterStart,
//    ) {
//        Text(
//            text = text,
//            style = MaterialTheme.typography.Title1,
//            color = Color.White,
//            textAlign = if (center) TextAlign.Center else TextAlign.Start,
//        )
//    }
//}