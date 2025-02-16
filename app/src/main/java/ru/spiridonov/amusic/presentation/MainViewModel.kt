package ru.spiridonov.amusic.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ru.spiridonov.amusic.domain.usecases.networkDataFetch.FetchDataFromNetworkUseCase
import javax.inject.Inject


class MainViewModel @Inject constructor(
    //private val application: Application,
    private val fetchDataFromNetworkUseCase: FetchDataFromNetworkUseCase
) : ViewModel() {

    private val _mainActivityState = MutableLiveData<MainActivityState>()
    val mainActivityState: LiveData<MainActivityState>
        get() = _mainActivityState


    fun initialCheck() {
        checkUserLoggedIn()
    }

    private fun checkUserLoggedIn() {
        val isUserLoggedIn = true // TODO(get access token from storage, check it)
        if (isUserLoggedIn) {
            _mainActivityState.postValue(MainActivityState.SetupView)
            fetchChartData()
        } else _mainActivityState.postValue(MainActivityState.NeedToReLogin)
    }

    private fun fetchChartData() {
        viewModelScope.launch(Dispatchers.IO) {
            fetchDataFromNetworkUseCase.invoke()
        }
    }
}