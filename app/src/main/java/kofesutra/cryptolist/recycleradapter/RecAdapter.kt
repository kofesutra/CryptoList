package kofesutra.cryptolist.recycleradapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.ImageLoader
import coil.decode.SvgDecoder
import coil.load
import kofesutra.cryptolist.R
import kofesutra.cryptolist.databinding.CardViewBinding
import kofesutra.cryptolist.model.Data
import kofesutra.cryptolist.model.TransferData
import kofesutra.cryptolist.recycleradapter.diffcallbacks.RecDiffCallBack

class RecAdapter : ListAdapter<Data, RecAdapter.RecViewHolder>(RecDiffCallBack()) {

    class RecViewHolder(binding: CardViewBinding) : RecyclerView.ViewHolder(binding.root) {
        val price: TextView = binding.itemPrice
        val nameOf: TextView = binding.itemName
        val logo: ImageView = binding.itemLogo
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecViewHolder {
        val binding = CardViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RecViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecViewHolder, position: Int) {

        val itemHere = currentList[position]
        val indexPlus = itemHere.price.indexOf('.')
        holder.price.text = itemHere.price.substring(0 ..indexPlus+5)
        holder.nameOf.text = itemHere.symbol
        val logoTemp: String = itemHere.logo_url
        val indexPlusHigh = itemHere.high.indexOf('.')
        val highCutted = itemHere.high.substring(0..indexPlusHigh + 5)
        val highTimestamp = itemHere.high_timestamp

        // SVG
        val context = holder.logo.context
        val svgImageLoader = ImageLoader.Builder(context)
            .components { add(SvgDecoder.Factory())
            }
            .build()
        // Binding SVG
        holder.logo.load(itemHere.logo_url, svgImageLoader) {
            size(80, 80)
        }

        holder.itemView.setOnClickListener {
            TransferData.intentName = holder.nameOf.text as String
            TransferData.intentLogo = logoTemp
            TransferData.intentPrice = holder.price.text as String
            TransferData.intentHigh = highCutted
            TransferData.intentHighTimestamp = highTimestamp
            Navigation.findNavController(holder.itemView).navigate(R.id.action_mainFragment_to_detailsFragment)
        }
    }
}