package ru.zhogin.app.ui.screens

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import ru.zhogin.app.features.models.directs.TicketOfferUI
import ru.zhogin.app.features.models.musicfly.OfferUI
import ru.zhogin.app.features.models.tickets.TicketUI
import ru.zhogin.app.ui.bottomnavbar.BottomBar

@RequiresApi(Build.VERSION_CODES.O)
@Composable
internal fun DefaultScreen(
    offers: List<OfferUI>,
    ticketsOffers: List<TicketOfferUI>,
    listTickets: List<TicketUI>,
) {
    val navController = rememberNavController()
    val listItems = listOf(
        NavigationScreens.AviaTickets.route,
        NavigationScreens.Hotels.route,
        NavigationScreens.Short.route,
        NavigationScreens.Follows.route,
        NavigationScreens.Profile.route,
        NavigationScreens.SearchChosenCountry.route,
        NavigationScreens.AllTicketsScreen.route,

        )


    val showBottomBar = navController.currentBackStackEntryAsState().value?.destination?.route in listItems.map { it}

    Surface(color = Color.Black) {
        Scaffold(
            bottomBar = {
                if (showBottomBar) {
                    BottomBar(navController = navController)
                }
            }
        ) { paddingValues ->
            NavGraph(
                navHostController = navController,
                paddingValues = paddingValues,
                offers = offers,
                ticketsOffers = ticketsOffers,
                listTickets = listTickets
            )

        }
    }
}