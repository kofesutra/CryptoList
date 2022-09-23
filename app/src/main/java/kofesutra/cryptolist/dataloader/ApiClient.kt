package kofesutra.cryptolist.dataloader

import kofesutra.cryptolist.dataloader.RetrofitBuilder.retrofit

class ApiClient {
    var apiClient: ApiInterface = retrofit.create(ApiInterface::class.java)
}