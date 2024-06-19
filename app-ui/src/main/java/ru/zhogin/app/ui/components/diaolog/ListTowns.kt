package ru.zhogin.app.ui.components.diaolog

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.zhogin.app.uikit.SearchDialogCardFirstBG

@Composable
internal fun ListTowns(
    listIcon: List<Int>,
    listTown: List<String>,
    onChoosePopular:(String) -> Unit,
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 29.dp, end = 13.dp),
        shape = RoundedCornerShape(21.dp),
        colors = CardDefaults.cardColors(
            containerColor = SearchDialogCardFirstBG
        ),
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(21.dp)
        ) {
            items(listTown.size) { index ->
                TownView(listIcon[index], listTown[index], onChoosePopular = {
                    onChoosePopular(it)
                })
            }

        }
    }
}