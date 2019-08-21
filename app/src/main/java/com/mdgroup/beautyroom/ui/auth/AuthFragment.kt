package com.mdgroup.beautyroom.ui.auth

import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.mdgroup.beautyroom.R

class AuthFragment : Fragment(R.layout.fragment_auth) {

    companion object {
        fun newInstance() = AuthFragment().apply { arguments = bundleOf() }
    }
}