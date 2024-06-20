package ru.zhogin.app.ui.screens

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import ru.zhogin.app.features.models.musicfly.OfferUI
import ru.zhogin.app.ui.R
import ru.zhogin.app.ui.components.avia.EnterPoints
import ru.zhogin.app.ui.components.avia.HardCodedText
import ru.zhogin.app.ui.components.avia.MusicFly
import ru.zhogin.app.ui.datasore.DataStoreManager
import ru.zhogin.app.ui.datasore.data.SettingsData
import ru.zhogin.app.ui.dialog.SearchScreenDialog

@Composable
fun AviaTicketsScreen(
    offers: List<OfferUI>,
    onScreenChosenCounty: (String, String) -> Unit,
) {

    val listMusicFly = listOf(
        R.drawable.music_first,
        R.drawable.music_second,
        R.drawable.music_third,
    )
    var from by rememberSaveable {
        mutableStateOf("")
    }
    var to by rememberSaveable {
        mutableStateOf("")
    }
    var openDialog by rememberSaveable {
        mutableStateOf(false)
    }

    when (openDialog) {
        true -> SearchScreenDialog(
            onDismissRequest = { openDialog = false },
            from = from, to = to,
            onNavigationChosenCountry = { destFrom, destTo ->
                to = destTo
                onScreenChosenCounty(destFrom, destTo)
            }
        )

        else -> {

        }
    }
    val coroutine = rememberCoroutineScope()
    val context = LocalContext.current
    val dataStoreManager = DataStoreManager(context)
    LaunchedEffect(key1 = true) {
        dataStoreManager.getSettings().collect { settings ->
            from = settings.departureFrom
        }
    }

    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .fillMaxWidth()
          //  .fillMaxSize()
            .padding(bottom = 80.dp)
            .background(Color.Black),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(37.dp))
        HardCodedText(text = stringResource(id = R.string.tickets_sale), center = true)
        Spacer(modifier = Modifier.height(48.dp))
        EnterPoints(
            from = from,
            changeFrom = { from = it }, to = to,
            changeTo = { to = it },
            switchToSearch = {
                if (from.isNotEmpty()) {
                    openDialog = true
                    coroutine.launch {
                        dataStoreManager.saveSettings(
                            SettingsData(
                                departureFrom = from
                            )
                        )
                    }
                } else Toast.makeText(
                    context,
                    context.getString(R.string.field_from_should_be_filled), Toast.LENGTH_SHORT
                ).show()
            }
        )
        Spacer(modifier = Modifier.height(43.dp))
        HardCodedText(text = stringResource(id = R.string.music_fly), center = false)
        Spacer(modifier = Modifier.height(33.dp))
        LazyRow(
            modifier = Modifier.padding(horizontal = 16.dp)
        ) {
            items(offers.size) { count ->
                MusicFly(offers[count], listMusicFly[count])
            }
        }


    }
}

internal fun String.addCharAtIndex(char: Char, index: Int) =
    StringBuilder(this).apply { insert(index, char) }.toString()
