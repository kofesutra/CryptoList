package kofesutra.cryptolist.dataloader

import kofesutra.cryptolist.model.Data
import kofesutra.cryptolist.model.DataLoader

class DataLoaderImpl : DataLoader {
    override suspend fun getData():List<Data> {
        return try {
            ApiClient().apiClient.getData()
                .takeIf { it.isSuccessful }
                ?.body()
                .orEmpty()
        } catch (e: Exception) {
            emptyList()
        }
    }
}
