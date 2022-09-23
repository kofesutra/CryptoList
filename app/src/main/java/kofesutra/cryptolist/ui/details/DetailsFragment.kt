package kofesutra.cryptolist.ui.details

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.activityViewModels
import coil.ImageLoader
import coil.decode.SvgDecoder
import coil.load
import kofesutra.cryptolist.R
import kofesutra.cryptolist.databinding.FragmentDetailsBinding
import kofesutra.cryptolist.databinding.FragmentMainBinding
import kofesutra.cryptolist.ui.main.MainViewModel

class DetailsFragment : Fragment() {

    private var binding: FragmentDetailsBinding? = null
    private val mViewModel: DetailsViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailsBinding.inflate(inflater, container,false)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)

        mViewModel.st()

        val svgImageLoader = context?.let {
            ImageLoader.Builder(it)
                .components { add(SvgDecoder.Factory()) }.build()
        }

        mViewModel.nameof2LD.observe(viewLifecycleOwner) {
            binding?.itemName2?.text = it.toString()
        }
        mViewModel.price2LD.observe(viewLifecycleOwner) {
            binding?.itemPrice2?.text = it.toString()
        }
        mViewModel.logo2LD.observe(viewLifecycleOwner) {
            if (svgImageLoader != null) {
                binding?.itemLogo2?.load(it, svgImageLoader) {
                    size(150, 150)
                }
            }
        }
        mViewModel.priceHighLD.observe(viewLifecycleOwner) {
            binding?.itemHigh2?.text = it.toString()
        }
        mViewModel.priceHighTimeLD.observe(viewLifecycleOwner) {
            binding?.itemHighTime2?.text = it.toString()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }

}