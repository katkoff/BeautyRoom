package com.mdgroup.beautyroom.ui.signin

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.google.android.material.snackbar.Snackbar
import com.mdgroup.beautyroom.R
import com.mdgroup.beautyroom.domain.model.UserCredentials
import kotlinx.android.synthetic.main.fragment_sign_in.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.koin.android.viewmodel.ext.android.viewModel

class SignInFragment : Fragment(R.layout.fragment_sign_in) {

    val signInViewModel: SignInViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        signInViewModel.errorMessage.observe(this, Observer { message ->
            Snackbar.make(view, message, Snackbar.LENGTH_SHORT).show()
        })
        initClickListeners()
    }

    private fun initClickListeners() {
        button_sign_in.setOnClickListener {
            GlobalScope.launch {
                signInViewModel.onSignInClicked(assembleSignInModel())
            }
        }

        button_sign_up.setOnClickListener { signInViewModel.onSignUpClicked() }
    }

    private fun assembleSignInModel(): UserCredentials {
        return UserCredentials(
            inputEditText_phone.text.toString().trim(),
            inputEditText_password.text.toString().trim()
        )
    }

    companion object {
        fun newInstance() = SignInFragment().apply { arguments = bundleOf() }
    }
}