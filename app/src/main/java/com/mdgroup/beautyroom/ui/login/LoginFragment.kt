package com.mdgroup.beautyroom.ui.login

import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.mdgroup.beautyroom.R

class LoginFragment : Fragment(R.layout.fragment_login) {

    companion object {
        fun newInstance() = LoginFragment().apply { arguments = bundleOf() }
    }
}