package go.faddy.hmrsystem.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import go.faddy.hmrsystem.R
import go.faddy.hmrsystem.databinding.FragmentPrimaryDashBoardBinding


@AndroidEntryPoint
class PrimaryDashBoardFragment : Fragment() {

    private lateinit var binding: FragmentPrimaryDashBoardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPrimaryDashBoardBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initClickListener()
    }

    private fun initClickListener() {
        binding.customerBalanceLayout.setOnClickListener {
            findNavController().navigate(R.id.action_primaryDashBoardFragment_to_showDataFacadeFragment)
        }
        binding.button2.setOnClickListener {

        }
    }
}