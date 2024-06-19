package ru.zhogin.app.ui.screens

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.EaseIn
import androidx.compose.animation.core.EaseOut
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import ru.zhogin.app.features.models.directs.TicketOfferUI
import ru.zhogin.app.features.models.musicfly.OfferUI
import ru.zhogin.app.features.models.tickets.TicketUI
import ru.zhogin.app.ui.R
import ru.zhogin.app.ui.bottomnavbar.BottomNavigationItem
import ru.zhogin.app.uikit.Title1
import java.time.LocalDate

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun NavGraph(
    navHostController: NavHostController,
    paddingValues: PaddingValues,
    offers: List<OfferUI>,
    ticketsOffers: List<TicketOfferUI>,
    listTickets: List<TicketUI>,
) {
    var destFrom by remember {
        mutableStateOf("")
    }
    var destTo by remember {
        mutableStateOf("")
    }
    var date by remember {
        mutableStateOf(LocalDate.now())
    }

    NavHost(navController = navHostController, startDestination = NavigationScreens.AviaTickets.route,
        enterTransition = {
            fadeIn(
                animationSpec = tween(
                    300, easing = LinearEasing
                )
            ) + slideIntoContainer(
                animationSpec = tween(300, easing = EaseIn),
                towards = AnimatedContentTransitionScope.SlideDirection.Start
            )
        },
        exitTransition = {
            fadeOut(
                animationSpec = tween(
                    300, easing = LinearEasing
                )
            ) + slideOutOfContainer(
                animationSpec = tween(300, easing = EaseOut),
                towards = AnimatedContentTransitionScope.SlideDirection.End
            )

        }) {
        composable(NavigationScreens.AviaTickets.route) {

            AviaTicketsScreen(offers, onScreenChosenCounty = { from, to ->
                destFrom = from
                destTo = to
                navHostController.navigate(NavigationScreens.SearchChosenCountry.route)
            })
        }
        composable(NavigationScreens.Hotels.route) {
            HotelsScreen()
        }
        composable(NavigationScreens.Short.route) {
            ShortScreen()
        }
        composable(NavigationScreens.Follows.route) {
            FollowsScreen()
        }
        composable(NavigationScreens.Profile.route) {
            ProfileScreen()
        }
        composable(NavigationScreens.SearchChosenCountry.route) {
            SearchChosenCountryScreen(destinationFrom = destFrom, destinationTo = destTo, ticketsOffers = ticketsOffers,
                onClickShowAllTickets = { to, from, dateDep ->
                    destTo = to
                    destFrom = from
                    date = dateDep
                    navHostController.navigate(NavigationScreens.AllTicketsScreen.route)
                })
        }
        composable(NavigationScreens.AllTicketsScreen.route) {
            AllTicketsScreen(destFrom = destFrom, destTo = destTo, date = date, onClick = {
                navHostController.navigateUp()
            }, listTickets = listTickets)
        }
    }
}


@Composable
fun ProfileScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 72.dp)
            .background(Color.Black),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = stringResource(id = R.string.profile), style = MaterialTheme.typography.Title1
        )
    }

}

@Composable
fun FollowsScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 72.dp)
            .background(Color.Black),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = stringResource(id = R.string.follows), style = MaterialTheme.typography.Title1
        )
    }
}

@Composable
fun ShortScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 72.dp)
            .background(Color.Black),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = stringResource(id = R.string.shots), style = MaterialTheme.typography.Title1
        )
    }
}

@Composable
fun HotelsScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 72.dp)
            .background(Color.Black),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = stringResource(id = R.string.hotels), style = MaterialTheme.typography.Title1
        )
    }
}