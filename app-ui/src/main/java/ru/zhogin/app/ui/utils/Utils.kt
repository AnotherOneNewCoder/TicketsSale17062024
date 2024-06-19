package ru.zhogin.app.ui.utils

import android.os.Build
import androidx.annotation.RequiresApi
import java.math.RoundingMode
import java.text.DecimalFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit

@RequiresApi(Build.VERSION_CODES.O)
fun String.getHours(): String {
    val formatter = DateTimeFormatter.ofPattern("HH:mm")
    val stringToLocalDateTime = LocalDateTime.parse(this)
    return stringToLocalDateTime.format(formatter)
}

@RequiresApi(Build.VERSION_CODES.O)
fun calculateDurationInHours(first: String, second: String): String {
    val firstStringToLocalDateTime = LocalDateTime.parse(first)
    val secondStringToLocalDateTime = LocalDateTime.parse(second)
    val difference =
        firstStringToLocalDateTime.until(secondStringToLocalDateTime, ChronoUnit.MINUTES)
    val df = DecimalFormat("#.#")
    df.roundingMode = RoundingMode.UP
    return df.format(difference.toDouble() / 60).toString().replace(',', '.')
}