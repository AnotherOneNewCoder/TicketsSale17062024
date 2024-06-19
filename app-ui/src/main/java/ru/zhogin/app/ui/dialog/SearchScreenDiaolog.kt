package ru.zhogin.app.ui.dialog

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import ru.zhogin.app.ui.R
import ru.zhogin.app.ui.components.diaolog.EnterField
import ru.zhogin.app.ui.components.diaolog.FastButton
import ru.zhogin.app.ui.components.diaolog.ListTowns
import ru.zhogin.app.uikit.HintTextColor
import ru.zhogin.app.uikit.SearchDialogBG
import ru.zhogin.app.uikit.StrokeColor
import ru.zhogin.app.uikit.Title3

@Composable
fun SearchScreenDialog(
    onDismissRequest: () -> Unit,
    from: String,
    to: String,
    onNavigationChosenCountry: (String, String) -> Unit,
) {

    var destinationTo by rememberSaveable {
        mutableStateOf(to)
    }
    val fastButtonListText = listOf(
        "Сложный маршрут",
        "Куда угодно",
        "Выходные",
        "Горячие билеты",
    )
    val fastButtonIconList = listOf(
        R.drawable.icon_fast_button_first,
        R.drawable.icon_fast_button_second,
        R.drawable.icon_fast_button_third,
        R.drawable.icon_fast_button_fourth,
    )
    val popularListIcon = listOf(
        R.drawable.icon_stambul,
        R.drawable.icon_sochi,
        R.drawable.icon_phuket,
    )
    val popularListText = listOf(
        "Стамбул",
        "Сочи",
        "Пхукет",
    )
    var closeDialog by rememberSaveable {
        mutableStateOf(false)
    }

    Dialog(
        onDismissRequest = { onDismissRequest() },
        properties = DialogProperties(
            usePlatformDefaultWidth = false // experimental
        )
    ) {
        Card(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 32.dp, start = 1.dp, end = 1.dp, bottom = 1.dp),
            shape = RoundedCornerShape(21.dp),
            colors = CardDefaults.cardColors(
                containerColor = SearchDialogBG
            ),
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(21.dp))
                Card(
                    shape = RoundedCornerShape(13.dp)
                ) {
                    Divider(
                        color = StrokeColor, thickness = 7.dp, modifier = Modifier
                            .width(51.dp)
                    )
                }
                Spacer(modifier = Modifier.height(32.dp))
                EnterField(
                    from = from,
                    destinationTo = destinationTo,
                    changeTo = { destinationTo = it },
                    clearTo = { destinationTo = "" },
                    onClickSearch = {
                        onDismissRequest()
                        onNavigationChosenCountry(from, destinationTo)
                    }
                )
                Spacer(modifier = Modifier.height(32.dp))
                LazyRow(
                    modifier = Modifier
                        .padding(horizontal = 22.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    items(fastButtonIconList.size) { index ->
                        FastButton(image = fastButtonIconList[index],
                            text = fastButtonListText[index],
                            onClick = {
                                if (fastButtonListText[index] == fastButtonListText[1]) {
                                    destinationTo = fastButtonListText[1]
                                } else {
                                    closeDialog = true
                                }
                            })
                    }

                }
                Spacer(modifier = Modifier.height(40.dp))
                ListTowns(popularListIcon, popularListText, onChoosePopular = {
                    destinationTo = it
                })

            }
        }
        if (closeDialog) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(21.dp),
                    shape = RoundedCornerShape(21.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = HintTextColor
                    ),
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(21.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Spacer(modifier = Modifier.height(21.dp))
                        Text(
                            text = stringResource(id = R.string.close_dialog),
                            style = MaterialTheme.typography.Title3,
                            color = Color.Black,
                        )
                        Spacer(modifier = Modifier.height(21.dp))
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceEvenly
                        ) {
                            TextButton(onClick = {
                                closeDialog = false
                            }) {
                                Text(
                                    text = stringResource(id = R.string.no),
                                    style = MaterialTheme.typography.Title3,
                                    color = Color.Black, textAlign = TextAlign.Center
                                )
                            }
                            TextButton(onClick = {
                                closeDialog = false
                                onDismissRequest()
                            }) {
                                Text(
                                    text = stringResource(id = R.string.yes),
                                    style = MaterialTheme.typography.Title3,
                                    color = Color.Black,
                                )
                            }
                        }
                        Spacer(modifier = Modifier.height(21.dp))
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun SearchPreview() {
    SearchScreenDialog(
        from = "Moscow",
        onDismissRequest = {},
        to = "",

        onNavigationChosenCountry = { from, to ->

        }


    )
}