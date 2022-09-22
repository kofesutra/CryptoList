package kofesutra.cryptolist.dataloader

class Constants {
    companion object {
        const val BASE_URL = "https://api.nomics.com/v1/currencies/"
        const val myApiKey = "c5f770409abd04d9c19f3f36f01b0ba1accf9702"
        const val ADD_URL = "ticker?key=$myApiKey&ids=BTC,ETH,LTC,XRP,SOL,DOT,DASH,XMR,ZEC,BCH,LUNA,USDT"
    }

}