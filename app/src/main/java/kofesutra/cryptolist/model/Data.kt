package kofesutra.cryptolist.model

data class Data(
    var symbol: String,
    var price: String,
    var logo_url: String,
    var high: String,
    val idForDiff: Int = UNDEFINED_ID
)
{
    companion object {
        const val UNDEFINED_ID = -1
    }
}
