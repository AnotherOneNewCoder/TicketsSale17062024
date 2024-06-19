package ru.zhogin.app.features.states

import ru.zhogin.app.features.models.musicfly.OffersUI

sealed class StateMusicfly(val offers: OffersUI?) {
    data object None : StateMusicfly(offers = null)
    class Loading(offers: OffersUI? = null) : StateMusicfly(offers)
    class Error(offers: OffersUI? = null) : StateMusicfly(offers)
    class Success(offers: OffersUI) : StateMusicfly(offers)
}