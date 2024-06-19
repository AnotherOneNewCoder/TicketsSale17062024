package ru.zhogin.app.ui.screens

sealed class NavigationScreens(val route: String) {
    data object SearchChosenCountry: NavigationScreens("search_chosen_country")
    data object AllTicketsScreen: NavigationScreens("all_tickets_screen")
    data object AviaTickets: NavigationScreens("avia")
    data object Hotels: NavigationScreens("hotels")
    data object Short: NavigationScreens("short")
    data object Follows:NavigationScreens("follows")
    data object Profile: NavigationScreens("profile")
}