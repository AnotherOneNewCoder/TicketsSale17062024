package ru.zhogin.app.ui

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import ru.zhogin.app.features.AppViewModel
import ru.zhogin.app.features.states.StateDirects
import ru.zhogin.app.features.states.StateMusicfly
import ru.zhogin.app.features.states.StateTickets
import ru.zhogin.app.ui.screens.DefaultScreen
import ru.zhogin.app.uikit.TicketsSale17062024Theme

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun MainScreen() {
    MainScreen(viewModel = viewModel())
}
@RequiresApi(Build.VERSION_CODES.O)
@Composable
internal fun MainScreen(
    viewModel: AppViewModel
) {
    val listMusicfly by viewModel.stateMusicfly.collectAsState()
    val listDirects by viewModel.stateDirects.collectAsState()
    val listTickets by viewModel.stateTickets.collectAsState()

    val stateMusicfly = listMusicfly
    val stateDirects = listDirects
    val stateTickets = listTickets

    if (listMusicfly != StateMusicfly.None && listDirects != StateDirects.None && listTickets != StateTickets.None ) {
        MainContent(stateMusicfly, stateDirects, stateTickets)
    }
    
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun MainContent(stateMusicfly: StateMusicfly, stateDirects: StateDirects, stateTickets: StateTickets) {
    if (stateMusicfly is StateMusicfly.Error || stateDirects is StateDirects.Error || stateTickets is StateTickets.Error) {
        ErrorMessage()
    }
    if (stateMusicfly is StateMusicfly.Loading || stateDirects is StateDirects.Loading || stateTickets is StateTickets.Loading) {
        ProgressIndicator()
    }
    if (stateMusicfly is StateMusicfly.Success && stateDirects is StateDirects.Success || stateTickets is StateTickets.Success) {
        stateMusicfly.offers?.offers?.let { listOfferUI ->
            stateDirects.ticketsOffers?.let { directs ->
                stateTickets.tickets?.let { listTicketUI ->
                    DefaultScreen(offers = listOfferUI, ticketsOffers = directs.ticketsOffers, listTickets =listTicketUI.tickets )
                }
            }

        }
    }
}




@Composable
private fun ErrorMessage() {
    Box(
        Modifier
            .fillMaxWidth()
            .background(TicketsSale17062024Theme.colorScheme.error)
            .padding(8.dp),
        contentAlignment = Alignment.Center

    ) {
        Text(text = "Error during update!", color = TicketsSale17062024Theme.colorScheme.onError)
    }
}


@Composable
private fun ProgressIndicator() {
    Box(
        Modifier
            .fillMaxWidth()
            .padding(8.dp),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator()
    }
}
