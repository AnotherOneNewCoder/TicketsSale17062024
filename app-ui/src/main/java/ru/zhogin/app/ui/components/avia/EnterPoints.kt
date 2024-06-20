package ru.zhogin.app.ui.components.avia

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
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import ru.zhogin.app.ui.R
import ru.zhogin.app.uikit.FirstEnterCardColor
import ru.zhogin.app.uikit.HintTextColor
import ru.zhogin.app.uikit.SecondEnterCardColor
import ru.zhogin.app.uikit.StrokeColor
import ru.zhogin.app.uikit.Text1

@Composable
internal fun EnterPoints(
    from: String,
    changeFrom: (String) -> Unit,
    to: String,
    changeTo: (String) -> Unit,
    switchToSearch: () -> Unit,
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 21.dp)
            .height(163.dp),
        shape = RoundedCornerShape(21.dp),
        backgroundColor = FirstEnterCardColor
    ) {
        Card(
            modifier = Modifier.padding(21.dp),
            shape = RoundedCornerShape(21.dp),
            backgroundColor = SecondEnterCardColor,
            elevation = 10.dp
        ) {
            Row {
                IconButton(
                    onClick = {},
                    //switchToSearch,
                    modifier = Modifier.padding(start = 10.dp, top = 33.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.icon_search),
                        contentDescription = "search",
                        modifier = Modifier.size(32.dp)
                    )
                }
                Spacer(modifier = Modifier.width(16.dp))
                Column {
                    Spacer(modifier = Modifier.height(21.dp))
                    BasicTextField(
                        value = from,
                        onValueChange = changeFrom,
                        modifier = Modifier
                            .fillMaxWidth(),
                        textStyle = MaterialTheme.typography.Text1,
                        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
                        singleLine = true,
                        decorationBox = { innerTextField ->
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                            ) {
                                if (from.isEmpty()) {
                                    Text(
                                        text = "Откуда - Москва",
                                        style = MaterialTheme.typography.Text1,
                                        color = HintTextColor
                                    )
                                }
                            }
                            innerTextField()

                        }
                    )
                    Spacer(modifier = Modifier.height(11.dp))

                    Divider(
                        color = StrokeColor, thickness = 1.dp, modifier = Modifier
                            .fillMaxWidth()
                            .padding(end = 21.dp)
                    )
                    Spacer(modifier = Modifier.height(11.dp))
                    BasicTextField(
                        value = to,
                        onValueChange = changeTo,
                        modifier = Modifier.fillMaxWidth(),
                        textStyle = MaterialTheme.typography.Text1,
                        singleLine = true,
                        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
                        keyboardActions = KeyboardActions(onDone = {
                            switchToSearch()
                        }),
                        decorationBox = { innerTextField ->
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                            ) {
                                if (to.isEmpty()) {
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

                }

            }
        }
    }
}