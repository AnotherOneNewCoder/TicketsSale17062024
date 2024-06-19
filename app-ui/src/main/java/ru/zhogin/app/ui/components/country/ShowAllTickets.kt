package ru.zhogin.app.ui.components.country

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.zhogin.app.ui.R
import ru.zhogin.app.uikit.SpecialBlue
import java.time.LocalDate

@Composable
internal fun ShowAllTickets(
    destTo: String,
    destFrom: String,
    date: LocalDate,
    onClickShowAllTickets: (String, String, LocalDate) -> Unit,
) {
    Card(
        shape = RoundedCornerShape(11.dp),
        colors = CardDefaults.cardColors(
            containerColor = SpecialBlue
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 21.dp)
            .clickable(
                enabled = true,
                onClick = { onClickShowAllTickets(destTo, destFrom, date) }
            )
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(14.dp))
            Text(
                text = stringResource(id = R.string.show_all),
                fontSize = 21.sp,
                fontWeight = FontWeight.SemiBold,
                fontStyle = FontStyle.Italic,
                color = Color.White, textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(13.dp))
        }

    }
}