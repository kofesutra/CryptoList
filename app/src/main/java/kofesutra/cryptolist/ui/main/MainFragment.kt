package kofesutra.cryptolist.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import kofesutra.cryptolist.databinding.FragmentMainBinding
import kofesutra.cryptolist.recycleradapter.RecAdapter

class MainFragment : Fragment() {

    private var binding: FragmentMainBinding? = null
    private val mViewModel: MainViewModel by activityViewModels()
    private var recAdapter: RecAdapter = RecAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater, container,false)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(false)

        mViewModel.loadData()

        binding!!.recyclerV.adapter = recAdapter

        mViewModel.dataList.observe(viewLifecycleOwner) {
            recAdapter.submitList(it)
        }

        binding!!.fab.setOnClickListener {
            Toast.makeText(context, "Refresh data", Toast.LENGTH_SHORT).show()
            mViewModel.loadData()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }

}