package ru.zhogin.app.ui.bottomnavbar

import android.graphics.drawable.Icon
import androidx.annotation.DrawableRes
import androidx.compose.material3.Icon
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import ru.zhogin.app.ui.R

//sealed class BottomNavigationItem(
//    val title: String,
//    val route: String,
//) {
//    data object AviaTickets: BottomNavigationItem("Авиабилеты", "avia")
//    data object Hotels: BottomNavigationItem("Отели", "hotels")
//    data object Short: BottomNavigationItem("Короче", "short")
//    data object Follows:BottomNavigationItem("Подписки", "follows")
//    data object Profile: BottomNavigationItem("Профиль", "profile")
//}

data class BottomNavigationItem(
    val title: String,
    val icon: ImageVector,
    val route: String,
)