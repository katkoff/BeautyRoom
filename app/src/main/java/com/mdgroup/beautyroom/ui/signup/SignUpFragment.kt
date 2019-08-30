package com.mdgroup.beautyroom.ui.signup

import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.mdgroup.beautyroom.R
import org.koin.android.viewmodel.ext.android.viewModel

class SignUpFragment : Fragment(R.layout.fragment_sign_up) {

    val signUpViewModel: SignUpViewModel by viewModel()

    companion object {
        fun newInstance() = SignUpFragment().apply { arguments = bundleOf() }
    }
}