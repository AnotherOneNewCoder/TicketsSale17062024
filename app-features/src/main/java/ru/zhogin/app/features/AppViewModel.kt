package ru.zhogin.app.features

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import ru.zhogin.app.features.models.directs.TicketOffersUI
import ru.zhogin.app.features.models.musicfly.OffersUI
import ru.zhogin.app.features.models.tickets.TicketsUI
import ru.zhogin.app.features.states.StateDirects
import ru.zhogin.app.features.states.StateMusicfly
import ru.zhogin.app.features.states.StateTickets
import ru.zhogin.app_data.RequestResult
import javax.inject.Inject
import javax.inject.Provider

@HiltViewModel
class AppViewModel @Inject constructor(
    repository: Provider<GetAllDataUseCase>
) : ViewModel() {
    val stateMusicfly: StateFlow<StateMusicfly> = repository.get().invokeMusicfly()
        .map { it.toStateOffers() }
        .stateIn(viewModelScope, SharingStarted.Lazily, StateMusicfly.None)

    val stateDirects: StateFlow<StateDirects> = repository.get().invokeDirects()
        .map { it.toStateDirects() }
        .stateIn(viewModelScope, SharingStarted.Lazily, StateDirects.None)
    val stateTickets: StateFlow<StateTickets> = repository.get().invokeTickets()
        .map { it.toStateTickets() }
        .stateIn(viewModelScope, SharingStarted.Lazily, StateTickets.None)
}

private fun RequestResult<OffersUI>.toStateOffers() : StateMusicfly {
    return when(this) {
        is RequestResult.Error -> StateMusicfly.Error(data)
        is RequestResult.InProgress -> StateMusicfly.Loading(data)
        is RequestResult.Success -> StateMusicfly.Success(data)
    }
}
private fun RequestResult<TicketOffersUI>.toStateDirects() : StateDirects {
    return when(this) {
        is RequestResult.Error -> StateDirects.Error(data)
        is RequestResult.InProgress -> StateDirects.Loading(data)
        is RequestResult.Success -> StateDirects.Success(data)
    }
}
private fun RequestResult<TicketsUI>.toStateTickets() : StateTickets {
    return when(this) {
        is RequestResult.Error -> StateTickets.Error(data)
        is RequestResult.InProgress -> StateTickets.Loading(data)
        is RequestResult.Success -> StateTickets.Success(data)
    }
}