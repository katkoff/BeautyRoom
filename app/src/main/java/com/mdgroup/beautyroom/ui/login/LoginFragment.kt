package com.mdgroup.beautyroom.ui.login

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.mdgroup.beautyroom.R
import kotlinx.android.synthetic.main.fragment_login.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.koin.android.viewmodel.ext.android.viewModel

class LoginFragment : Fragment(R.layout.fragment_login) {

    val loginViewModel: LoginViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        button_sign_in.setOnClickListener {
            GlobalScope.launch {
                loginViewModel.login(
                    inputEditText_phone.text.toString().trim(),
                    inputEditText_password.text.toString().trim()
                )
            }
        }
    }

    companion object {
        fun newInstance() = LoginFragment().apply { arguments = bundleOf() }
    }
}