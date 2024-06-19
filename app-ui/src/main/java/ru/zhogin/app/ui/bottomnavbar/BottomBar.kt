package ru.zhogin.app.ui.bottomnavbar

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import ru.zhogin.app.ui.R
import ru.zhogin.app.uikit.SpecialBlue
import ru.zhogin.app.uikit.StrokeColor
import ru.zhogin.app.uikit.TabText
import ru.zhogin.app.uikit.TicketsSale17062024Theme

@Composable
internal fun BottomBar(
    navController: NavHostController
) {
    NavigationBar(
        containerColor = Color.Black,
    ) {



            val items = listOf(
                BottomNavigationItem(
                    title = "Авиабилеты",
                    icon = ImageVector.vectorResource(id = R.drawable.icon_botton_plane),
                    route = "avia"
                ),
                BottomNavigationItem(
                    title = "Отели",
                    icon = ImageVector.vectorResource(id = R.drawable.icon_botton_hotel),
                    route = "hotels"
                ),
                BottomNavigationItem(
                    title = "Короче",
                    icon = ImageVector.vectorResource(id = R.drawable.icon_botton_place),
                    route = "short"
                ),
                BottomNavigationItem(
                    title = "Подписки",
                    icon = ImageVector.vectorResource(id = R.drawable.icon_botton_bell),
                    route = "follows"
                ),
                BottomNavigationItem(
                    title = "Профиль",
                    icon = ImageVector.vectorResource(id = R.drawable.icon_botton_profile),
                    route = "profile"
                ),
            )
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentRoute = navBackStackEntry?.destination?.route

            items.forEach { item ->
                NavigationBarItem(
                    selected = currentRoute == item.route,
                    onClick = {

                        navController.navigate(item.route)
                    },
                    icon = {
                        Icon(
                            imageVector = item.icon,
                            contentDescription = item.title,
                            tint = if (currentRoute == item.route) SpecialBlue else StrokeColor,

                        )
                    },
                    label = {
                        Text(
                            text = item.title,
                            style = TicketsSale17062024Theme.typography.TabText,
                            softWrap = false,
                            overflow = TextOverflow.Visible,
                            color = if (currentRoute == item.route) SpecialBlue else StrokeColor
                        )
                    },
                    alwaysShowLabel = true,
                    colors = NavigationBarItemDefaults.colors(
                        indicatorColor = Color.Black
                    ),

                    )
            }
        }

}