package com.mdgroup.beautyroom.ui.signin

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.mdgroup.beautyroom.R
import com.mdgroup.beautyroom.ui.base.bind
import com.mdgroup.beautyroom.ui.base.inputMask
import com.mdgroup.beautyroom.ui.base.snackbar
import kotlinx.android.synthetic.main.fragment_sign_in.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.terrakok.cicerone.android.support.SupportAppScreen

class SignInFragment : Fragment(R.layout.fragment_sign_in) {

    private val viewModel: SignInViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bindViewModel()
        initClickListeners()
        initInputMask()
    }

    private fun bindViewModel() {
        bind(viewModel.errorMessage) {
            snackbar(it)
        }
        bind(viewModel.isProgress) {
            progressBar.isVisible = it
        }
    }

    private fun initClickListeners() {
        button_sign_in.setOnClickListener {
            val password = inputEditText_password.text.toString().trim()

            viewModel.onSignInClicked(password)
        }

        button_sign_up.setOnClickListener {
            viewModel.onSignUpClicked()
        }
    }

    private fun initInputMask() {
        inputEditText_phone.inputMask("+7 ([000]) [000]-[00]-[00]") { phone ->
            viewModel.onPhoneChanged(phone)
        }
    }

//    private fun recognizeScreen(nextScreen: SupportAppScreen, screenKey: String?): SupportAppScreen = when (nextScreen) {
//        is MasterDetailsScreen -> {
//            if (masterId != null) {
//                MasterDetailsScreen(masterId)
//            } else {
//                MasterListScreen()
//            }
//        }
//        is AppointmentsScreen -> AppointmentsScreen()
//        else -> MasterListScreen()
//    }

    companion object {
        private const val NEXT_SCREEN_ARG = "NEXT_SCREEN_ARG"
        private const val SCREEN_KEY_ARG = "SCREEN_KEY_ARG"

        fun newInstance(nextScreen: SupportAppScreen) = SignInFragment().apply {
            arguments = bundleOf(
                NEXT_SCREEN_ARG to nextScreen,
                SCREEN_KEY_ARG to nextScreen.screenKey
            )
        }
    }
}