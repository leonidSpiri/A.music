package ru.spiridonov.amusic.presentation

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import javax.inject.Inject


class MainViewModel @Inject constructor(
    private val application: Application
) : ViewModel() {

    private val _mainActivityState = MutableLiveData<MainActivityState>()
    val mainActivityState: LiveData<MainActivityState>
        get() = _mainActivityState


    init {
        checkUserLoggedIn()
    }

    private fun checkUserLoggedIn() {
        val isUserLoggedIn = true // TODO(get access token from storage, check it)
        if (isUserLoggedIn)
            _mainActivityState.postValue(MainActivityState.NeedToReLogin)
        else
            _mainActivityState.postValue(MainActivityState.SetupView)


    }
}