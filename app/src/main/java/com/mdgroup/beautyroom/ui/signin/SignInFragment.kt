package com.mdgroup.beautyroom.ui.signin

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.mdgroup.beautyroom.R
import com.mdgroup.beautyroom.domain.model.UserCredentials
import com.mdgroup.beautyroom.ui.base.snackbar
import kotlinx.android.synthetic.main.fragment_sign_in.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class SignInFragment : Fragment(R.layout.fragment_sign_in) {

    private val viewModel: SignInViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.errorMessage.observe(this, Observer { message ->
            snackbar(message)
        })
        initClickListeners()
    }

    private fun initClickListeners() {
        button_sign_in.setOnClickListener {
            viewModel.onSignInClicked(assembleUserCredentials())
        }

        button_sign_up.setOnClickListener {
            viewModel.onSignUpClicked()
        }
    }

    private fun assembleUserCredentials(): UserCredentials {
        return UserCredentials(
            inputEditText_phone.text.toString().trim(),
            inputEditText_password.text.toString().trim()
        )
    }

    companion object {
        fun newInstance() = SignInFragment().apply { arguments = bundleOf() }
    }
}