package com.mdgroup.beautyroom.ui.signin

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.mdgroup.beautyroom.R
import kotlinx.android.synthetic.main.fragment_sign_in.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.koin.android.viewmodel.ext.android.viewModel

class SignInFragment : Fragment(R.layout.fragment_sign_in) {

    val signInViewModel: SignInViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initClickListeners()
    }

    private fun initClickListeners() {
        button_sign_in.setOnClickListener {
            GlobalScope.launch {
                signInViewModel.signIn(
                    inputEditText_phone.text.toString().trim(),
                    inputEditText_password.text.toString().trim()
                )
            }
        }

        button_sign_up.setOnClickListener { signInViewModel.signUp() }
    }

    companion object {
        fun newInstance() = SignInFragment().apply { arguments = bundleOf() }
    }
}