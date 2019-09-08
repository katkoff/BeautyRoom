package com.mdgroup.beautyroom.ui.signup

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.mdgroup.beautyroom.R
import com.mdgroup.beautyroom.domain.model.UserRegInfo
import com.mdgroup.beautyroom.ui.base.bind
import com.mdgroup.beautyroom.ui.base.snackbar
import kotlinx.android.synthetic.main.fragment_master_list.progressBar
import kotlinx.android.synthetic.main.fragment_sign_in.inputEditText_password
import kotlinx.android.synthetic.main.fragment_sign_in.inputEditText_phone
import kotlinx.android.synthetic.main.fragment_sign_up.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class SignUpFragment : Fragment(R.layout.fragment_sign_up) {

    private val signUpViewModel: SignUpViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bindViewModel()
        initClickListeners()
    }

    private fun bindViewModel() {
        bind(signUpViewModel.errorMessage) {
            snackbar(it)
        }
        bind(signUpViewModel.isProgress) {
            progressBar.isVisible = it
        }
    }

    private fun initClickListeners() {
        button_sign_up.setOnClickListener { signUpViewModel.onSignUpClicked(assembleSignUpModel()) }
    }

    private fun assembleSignUpModel(): UserRegInfo {
        return UserRegInfo(
            inputEditText_name.text.toString().trim(),
            inputEditText_phone.text.toString().trim(),
            inputEditText_password.text.toString().trim()
        )
    }

    companion object {
        fun newInstance() = SignUpFragment().apply { arguments = bundleOf() }
    }
}