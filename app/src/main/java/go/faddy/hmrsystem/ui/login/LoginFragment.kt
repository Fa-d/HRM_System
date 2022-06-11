package go.faddy.hmrsystem.ui.login

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import dagger.hilt.android.AndroidEntryPoint
import go.faddy.hmrsystem.databinding.FragmentLoginBinding
import go.faddy.hmrsystem.ui.dashboard.DashBoardActivity


@AndroidEntryPoint
class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentLoginBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initClickListener()
    }

    private fun initClickListener() {
        binding.loginButton.setOnClickListener {
            binding.userIdET.setText("admin")
            binding.passwordET.setText("admin")
            val userId = binding.userIdET.text.toString().trim()
            val pass = binding.passwordET.text.toString().trim()
            if (userId == "admin" && pass == "admin") {
                startActivity(Intent(requireContext(), DashBoardActivity::class.java))
            } else {

            }
        }
    }
}