package ru.spiridonov.amusic.presentation.ui.home

import androidx.lifecycle.ViewModel
import ru.spiridonov.amusic.domain.usecases.track.GetChartTrackListUseCase
import ru.spiridonov.amusic.domain.usecases.track.GetTrackListUseCase
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private val getChartTrackListUseCase: GetChartTrackListUseCase,
    private val getTrackListUseCase: GetTrackListUseCase
) : ViewModel() {


    suspend fun getChartTrackList() = getTrackListUseCase.invoke()

}