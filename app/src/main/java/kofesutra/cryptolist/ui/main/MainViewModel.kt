package kofesutra.cryptolist.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kofesutra.cryptolist.dataloader.DataLoaderImpl
import kofesutra.cryptolist.model.Data
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val _dataList = MutableLiveData<List<Data>>()
    val dataList: LiveData<List<Data>> = _dataList

    fun loadData() {
        viewModelScope.launch {
            _dataList.postValue(DataLoaderImpl().getData())
        }
    }
}