package ru.zhogin.app.ui.components.tickets

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.zhogin.app.uikit.SpecialBlue
import ru.zhogin.app.uikit.Text2

@Composable
internal fun BadgeView(text: String) {
    Card(
        shape = RoundedCornerShape(67.dp),
        backgroundColor = SpecialBlue,
    ) {
        Spacer(modifier = Modifier.height(3.dp))
        Text(
            text = text,
            style = MaterialTheme.typography.Text2,
            modifier = Modifier.padding(horizontal = 13.dp)
        )
        Spacer(modifier = Modifier.height(3.dp))
    }
}