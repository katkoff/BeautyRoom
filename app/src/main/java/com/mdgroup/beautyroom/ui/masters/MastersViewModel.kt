package com.mdgroup.beautyroom.ui.masters

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mdgroup.beautyroom.domain.interactor.MastersInteractor
import com.mdgroup.beautyroom.domain.model.MasterModel
import kotlinx.coroutines.launch
import ru.terrakok.cicerone.Router

class MastersViewModel(
    private val mastersInteractor: MastersInteractor,
    private val router: Router
) : ViewModel() {

    val mastersLiveData = MutableLiveData<List<MasterModel>>()
    val errorMessageLiveData: MutableLiveData<String> = MutableLiveData()
    val progressVisibleLiveData: MutableLiveData<Boolean> = MutableLiveData()

    fun getMasters() {
        progressVisibleLiveData.postValue(true)
        viewModelScope.launch {
            try {
                val masters = mastersInteractor.getMasters()
                mastersLiveData.postValue(masters)
                progressVisibleLiveData.postValue(false)
                Log.d("MastersViewModel", "Success. MasterList: $masters")
            } catch (exception: Exception) {
                errorMessageLiveData.postValue(exception.message)
                progressVisibleLiveData.postValue(false)
                Log.d("MastersViewModel", "Error " + exception.message)
            }
        }
    }
}