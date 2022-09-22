package kofesutra.cryptolist.ui.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DetailsViewModel : ViewModel() {

    companion object {
        const val intentLogo = "???"
        const val intentName = "!!!"
        const val intentPrice = "888"
        const val intentHigh = "999"
//        const val intentPercentDay = "999"
    }

    private var _nameof2LD = MutableLiveData<String>()
    val nameof2LD: LiveData<String> = _nameof2LD
    private var _price2LD = MutableLiveData<String>()
    val price2LD: LiveData<String> = _price2LD
    private var _logo2LD = MutableLiveData<String>()
    val logo2LD: LiveData<String> = _logo2LD
    private var _priceHighLD = MutableLiveData<String>()
    val priceHighLD: LiveData<String> = _priceHighLD

init {
    _nameof2LD.value = intentName
    _price2LD.value = intentPrice
    _logo2LD.value = intentLogo
    _priceHighLD.value = intentHigh
}


}