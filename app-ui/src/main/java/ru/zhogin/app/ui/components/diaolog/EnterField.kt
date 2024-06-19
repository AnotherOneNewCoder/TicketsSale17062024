package ru.zhogin.app.ui.components.diaolog

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import ru.zhogin.app.ui.R
import ru.zhogin.app.uikit.HintTextColor
import ru.zhogin.app.uikit.SearchDialogCardFirstBG
import ru.zhogin.app.uikit.SecondEnterCardColor
import ru.zhogin.app.uikit.Text1

@Composable
internal fun EnterField(
    from: String,
    destinationTo: String,
    changeTo: (String) -> Unit,
    clearTo: () -> Unit,
    onClickSearch: () -> Unit
) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 21.dp),
        colors = CardDefaults.cardColors(
            containerColor = SearchDialogCardFirstBG
        ),
        shape = RoundedCornerShape(21.dp),
    ) {
        Column {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 21.dp, top = 21.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.icon_plane_dialog),
                    contentDescription = "plane icon",
                    modifier = Modifier.size(32.dp),
                    tint = HintTextColor
                )
                Spacer(modifier = Modifier.width(11.dp))
                Text(text = from, style = MaterialTheme.typography.Text1,)
            }
            Spacer(modifier = Modifier.height(10.dp))
            Divider(
                color = SecondEnterCardColor, thickness = 1.dp, modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 21.dp)
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 21.dp, top = 11.dp, bottom = 21.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.icon_search),
                    contentDescription = "search icon",
                    modifier = Modifier
                        .size(32.dp)
                        .clickable(
                            enabled = true,
                            onClick = onClickSearch
                        ),
                    tint = Color.White
                )
                Spacer(modifier = Modifier.width(11.dp))
                BasicTextField(
                    value = destinationTo,
                    onValueChange = changeTo,
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f),
                    textStyle = MaterialTheme.typography.Text1,
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
                    keyboardActions = KeyboardActions(onDone = {
                        onClickSearch()
                    }),
                    decorationBox = { innerTextField ->
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                        ) {
                            if (destinationTo.isEmpty()) {
                                Text(
                                    text = "Куда - Турция",
                                    style = MaterialTheme.typography.Text1,
                                    color = HintTextColor,
                                )
                            }
                        }
                        innerTextField()
                    }
                )
                Box(
                    contentAlignment = Alignment.CenterEnd,
                ) {

                    Icon(
                        painter = painterResource(id = R.drawable.icon_x),
                        contentDescription = "clear icon",
                        modifier = Modifier
                            .clickable(
                                enabled = true,
                                onClick = clearTo
                            )
                            .padding(end = 21.dp)
                            .size(32.dp),
                        tint = HintTextColor
                    )
                }

            }
        }
    }
}