package ru.zhogin.app.uikit

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
val MyCustomFont = FontFamily(
    Font(R.font.sf_pro_display_regular, FontWeight.Normal),
    Font(R.font.sf_pro_display_medium, FontWeight.Medium),
    Font(R.font.sf_pro_display_semibold, FontWeight.SemiBold),
    Font(R.font.sf_pro_display_mediumitalic, FontWeight.Medium, FontStyle.Italic)
)
// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)
val Typography.Title1: TextStyle
    @Composable
    get() {
        return TextStyle(
            fontFamily = MyCustomFont,
            fontWeight = FontWeight.SemiBold,
            fontSize = 29.sp,
            color = Color.White,
        )
    }
val Typography.Title2: TextStyle
    @Composable
    get() {
        return TextStyle(
            fontFamily = MyCustomFont,
            fontWeight = FontWeight.SemiBold,
            fontSize = 27.sp,
            color = Color.White,
        )
    }
val Typography.Title3: TextStyle
    @Composable
    get() {
        return TextStyle(
            fontFamily = MyCustomFont,
            fontWeight = FontWeight.Medium,
            fontSize = 21.sp,
            color = Color.White,
        )
    }
val Typography.Title4: TextStyle
    @Composable
    get() {
        return TextStyle(
            fontFamily = MyCustomFont,
            fontWeight = FontWeight.Normal,
            fontSize = 19.sp,
            color = Color.White,
        )
    }
val Typography.Text1: TextStyle
    @Composable
    get() {
        return TextStyle(
            fontFamily = MyCustomFont,
            fontWeight = FontWeight.Normal,
            fontSize = 21.sp,
            color = Color.White,
        )
    }
val Typography.Text2: TextStyle
    @Composable
    get() {
        return TextStyle(
            fontFamily = MyCustomFont,
            fontWeight = FontWeight.Medium,
            fontStyle = FontStyle.Italic,
            fontSize = 19.sp,
            color = Color.White,
        )
    }
val Typography.ButtonText1: TextStyle
    @Composable
    get() {
        return TextStyle(
            fontFamily = MyCustomFont,
            fontWeight = FontWeight.Normal,
            fontSize = 21.sp,
            color = Color.White,
        )
    }
val Typography.TabText: TextStyle
    @Composable
    get() {
        return TextStyle(
            fontFamily = MyCustomFont,
            fontWeight = FontWeight.Normal,
            fontSize = 13.sp,

            )
    }