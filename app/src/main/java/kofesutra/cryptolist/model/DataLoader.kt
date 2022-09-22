package kofesutra.cryptolist.model

interface DataLoader {
    suspend fun getData():List<Data>
}