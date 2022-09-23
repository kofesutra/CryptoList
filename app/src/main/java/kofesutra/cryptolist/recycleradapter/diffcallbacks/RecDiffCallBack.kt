package kofesutra.cryptolist.recycleradapter.diffcallbacks

import androidx.recyclerview.widget.DiffUtil
import kofesutra.cryptolist.model.Data

class RecDiffCallBack: DiffUtil.ItemCallback<Data>() {
    override fun areItemsTheSame(oldItem: Data, newItem: Data): Boolean {
        return oldItem.idForDiff == newItem.idForDiff
    }

    override fun areContentsTheSame(oldItem: Data, newItem: Data): Boolean {
        return oldItem == newItem
    }
}