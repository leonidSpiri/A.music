package ru.spiridonov.amusic.presentation

sealed class MainActivityState {
    data object NeedToReLogin : MainActivityState()
    data object SetupView : MainActivityState()
}