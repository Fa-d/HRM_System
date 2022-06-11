package go.faddy.hmrsystem.ui.dashboard

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import go.faddy.hmrsystem.databinding.FragmentShowDataFacadeBinding


@AndroidEntryPoint
class ShowDataFacadeFragment : Fragment() {
    private val viewModel: HomeViewModel by activityViewModels()
    private lateinit var binding: FragmentShowDataFacadeBinding
    private val facadeCustomerBalanceAdapter = FacadeCustomerBalanceAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentShowDataFacadeBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initClickListener()
        initView()
    }

    private fun initView() {

        with(binding.customerRecycler) {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(requireContext())
            adapter = facadeCustomerBalanceAdapter
        }
    }

    private fun initClickListener() {
        binding.codeSearchET.setText("1002")
        binding.searchButton.setOnClickListener {
            viewModel.getCustomerBalance(binding.codeSearchET.text.toString().trim())
                .observe(viewLifecycleOwner, Observer { dataset ->
                    Log.d("hey", "$dataset")
                    facadeCustomerBalanceAdapter.initLoad(dataset)
                    binding.customerCodeTV.text = dataset[0].cusname
                })
        }
    }
}