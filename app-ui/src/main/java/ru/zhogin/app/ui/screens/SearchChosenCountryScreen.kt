package ru.zhogin.app.ui.screens

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.maxkeppeker.sheets.core.models.base.rememberUseCaseState
import com.maxkeppeler.sheets.calendar.CalendarDialog
import com.maxkeppeler.sheets.calendar.models.CalendarConfig
import com.maxkeppeler.sheets.calendar.models.CalendarSelection
import ru.zhogin.app.features.models.directs.TicketOfferUI
import ru.zhogin.app.ui.components.country.DateFrom
import ru.zhogin.app.ui.components.country.DirectFlights
import ru.zhogin.app.ui.components.country.Filters
import ru.zhogin.app.ui.components.country.FlyBack
import ru.zhogin.app.ui.components.country.PassengersAndClass
import ru.zhogin.app.ui.components.country.ShowAllTickets
import ru.zhogin.app.ui.components.country.TrackList
import java.time.LocalDate

@OptIn(ExperimentalMaterial3Api::class)
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun SearchChosenCountryScreen(
    destinationFrom: String,
    destinationTo: String,
    ticketsOffers: List<TicketOfferUI>,
    onClickShowAllTickets: (String, String, LocalDate) -> Unit,
) {
    var destFrom by rememberSaveable {
        mutableStateOf(destinationFrom)
    }
    var destTo by rememberSaveable {
        mutableStateOf(destinationTo)
    }
    var date by remember {
        mutableStateOf(LocalDate.now())
    }
    var dateBack by remember {
        mutableStateOf(LocalDate.now().minusDays(1))
    }

    var whichDate by rememberSaveable {
        mutableStateOf(true)
    }

    val calendarState = rememberUseCaseState()
    CalendarDialog(
        state = calendarState,
        config = CalendarConfig(
            monthSelection = true,
            yearSelection = true,
        ),
        selection = CalendarSelection.Date { dateSelected ->
            if (whichDate) date = dateSelected else dateBack = dateSelected
        })
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 80.dp)
            .background(Color.Black)
            //.verticalScroll(rememberScrollState()),
        ) {
        Spacer(modifier = Modifier.height(63.dp))
        TrackList(destFrom, destTo, onClick =
        {
            destFrom = destTo.also { destTo = destFrom }
        })
        Spacer(modifier = Modifier.height(17.dp))
        Row(
            modifier = Modifier
                .padding(horizontal = 21.dp)
                .horizontalScroll(
                    rememberScrollState()
                )
        ) {
            FlyBack(onClick = {
                whichDate = false
                calendarState.show()
            }, date, dateBack)
            Spacer(modifier = Modifier.width(10.dp))
            DateFrom(date, onDateClicked = {
                whichDate = true
                calendarState.show()
            })
            Spacer(modifier = Modifier.width(10.dp))
            PassengersAndClass()
            Spacer(modifier = Modifier.width(10.dp))
            Filters()
        }
        Spacer(modifier = Modifier.height(16.dp))
        DirectFlights(ticketsOffers)
        Spacer(modifier = Modifier.height(30.dp))
        ShowAllTickets(
            destTo, destFrom, date,
            onClickShowAllTickets = onClickShowAllTickets
        )
    }

}

















