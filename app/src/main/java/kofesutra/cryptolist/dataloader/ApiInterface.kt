package kofesutra.cryptolist.dataloader

import kofesutra.cryptolist.model.Data
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {
    @GET(Constants.ADD_URL)
    suspend fun getData(): Response<List<Data>>
}