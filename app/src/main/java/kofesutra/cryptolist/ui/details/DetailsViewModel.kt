package kofesutra.cryptolist.ui.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kofesutra.cryptolist.model.TransferData

class DetailsViewModel : ViewModel() {

    private var _nameof2LD = MutableLiveData<String>()
    val nameof2LD: LiveData<String> = _nameof2LD
    private var _price2LD = MutableLiveData<String>()
    val price2LD: LiveData<String> = _price2LD
    private var _logo2LD = MutableLiveData<String>()
    val logo2LD: LiveData<String> = _logo2LD
    private var _priceHighLD = MutableLiveData<String>()
    val priceHighLD: LiveData<String> = _priceHighLD
    private var _priceHighTimeLD = MutableLiveData<String>()
    val priceHighTimeLD: LiveData<String> = _priceHighTimeLD

    fun st() {
    _nameof2LD.value = TransferData.intentName
    _price2LD.value = TransferData.intentPrice
    _logo2LD.value = TransferData.intentLogo
    _priceHighLD.value = TransferData.intentHigh
    _priceHighTimeLD.value = TransferData.intentHighTimestamp
    }

}