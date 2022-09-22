package kofesutra.cryptolist.recycleradapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.ImageLoader
import coil.decode.SvgDecoder
import coil.load
import kofesutra.cryptolist.databinding.CardViewBinding
import kofesutra.cryptolist.model.Data
import kofesutra.cryptolist.recycleradapter.diffcallbacks.RecDiffCallBack


class RecAdapter : ListAdapter<Data, RecAdapter.RecViewHolder>(RecDiffCallBack()) {

    class RecViewHolder(binding: CardViewBinding) : RecyclerView.ViewHolder(binding.root) {
        val price: TextView = binding.itemPrice // Отображение цены
        val nameOf: TextView = binding.itemName // Отображение названия
        val logo: ImageView = binding.itemLogo // Отображение картинок
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
//        val logoTemp: String = itemHere.logo_url
//        val indexPlusHigh = itemHere.high.indexOf('.')
//        val highCutted = itemHere.high.substring(0..indexPlusHigh + 5)

        val context = holder.logo.context
        // Обработкик SVG
        val svgImageLoader = ImageLoader.Builder(context)
            .components { add(SvgDecoder.Factory())
            }
            .build()
        // Binding SVG
        holder.logo.load(itemHere.logo_url, svgImageLoader) {
            size(80, 80)
        }

//        holder.itemView.setOnClickListener {
//            val intent = Intent(holder.itemView.context, SecondActivity::class.java)
//            intent.putExtra(SecondActivity.intentPrice, holder.price.text)
//            intent.putExtra(SecondActivity.intentName, holder.nameOf.text)
//            intent.putExtra(SecondActivity.intentLogo, logoTemp)
//            intent.putExtra(SecondActivity.intentHigh, highCutted)
////            intent.putExtra(SecondActivity.intentPercentDay, listStart[position].price_change_pct)
//            holder.itemView.context.startActivity(intent)
//        }

    }
}