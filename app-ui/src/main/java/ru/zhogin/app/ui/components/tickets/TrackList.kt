package ru.zhogin.app.ui.components.tickets

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import ru.zhogin.app.ui.R
import ru.zhogin.app.uikit.HintTextColor
import ru.zhogin.app.uikit.SearchDialogBG
import ru.zhogin.app.uikit.SpecialBlue
import ru.zhogin.app.uikit.Text2
import ru.zhogin.app.uikit.Title3
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
@Composable
internal fun TrackList(destFrom: String, destTo: String, date: LocalDate, onClick: () -> Unit) {
    val dayFormatter = DateTimeFormatter.ofPattern("dd MMMM")
    Card(
        modifier = Modifier.fillMaxWidth(),
        backgroundColor = SearchDialogBG
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 43.dp, end = 21.dp)
        ) {
            Spacer(modifier = Modifier.height(11.dp))
            Text(
                text = "$destFrom-$destTo",
                style = MaterialTheme.typography.Title3,
            )
            Spacer(modifier = Modifier.height(5.dp))

            Text(
                text = date.format(dayFormatter) + stringResource(R.string.one_pass),
                style = MaterialTheme.typography.Text2,
                color = HintTextColor,
            )
            Spacer(modifier = Modifier.height(11.dp))
        }
        Box(
            modifier = Modifier.padding(top = 21.dp)
        ) {
            IconButton(onClick = onClick, modifier = Modifier.then(Modifier.size(32.dp))) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack, contentDescription = "Back",
                    tint = SpecialBlue, modifier = Modifier.size(32.dp)
                )
            }
        }

    }
}