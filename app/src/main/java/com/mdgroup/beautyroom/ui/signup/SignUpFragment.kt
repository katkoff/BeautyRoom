package com.mdgroup.beautyroom.ui.signup

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.mdgroup.beautyroom.R
import com.mdgroup.beautyroom.domain.model.UserRegInfo
import com.mdgroup.beautyroom.navigation.ScreenFactory
import com.mdgroup.beautyroom.ui.base.bind
import com.mdgroup.beautyroom.ui.base.inputMask
import com.mdgroup.beautyroom.ui.base.snackbar
import kotlinx.android.synthetic.main.fragment_sign_in.inputEditText_password
import kotlinx.android.synthetic.main.fragment_sign_in.inputEditText_phone
import kotlinx.android.synthetic.main.fragment_sign_up.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.terrakok.cicerone.android.support.SupportAppScreen

class SignUpFragment : Fragment(R.layout.fragment_sign_up) {

    private val viewModel: SignUpViewModel by viewModel()

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

    private fun initInputMask() {
        inputEditText_phone.inputMask("+7 ([000]) [000]-[00]-[00]") { phone ->
            viewModel.onPhoneChanged(phone)
        }
    }

    private fun initClickListeners() {
        button_sign_up.setOnClickListener {
            viewModel.onSignUpClicked(
                userRegInfo = assembleSignUpModel(),
                nextScreen = getNextScreen(),
                isReplace = requireArguments().getBoolean(IS_REPLACE_ARG))
        }
    }

    private fun getNextScreen(): SupportAppScreen {
        val screenFactory = requireArguments().getSerializable(SCREEN_FACTORY_ARG) as ScreenFactory?
        return screenFactory?.getScreen(requireArguments(), NEXT_SCREEN_ARG)!!
    }

    private fun assembleSignUpModel(): UserRegInfo {
        return UserRegInfo(
            name = inputEditText_name.text.toString().trim(),
            phone = "",
            password = inputEditText_password.text.toString().trim()
        )
    }

    companion object {
        private const val NEXT_SCREEN_ARG = "NEXT_SCREEN_ARG"
        private const val SCREEN_FACTORY_ARG = "SCREEN_FACTORY_ARG"
        private const val IS_REPLACE_ARG = "IS_REPLACE_ARG"

        fun newInstance(
            nextScreen: SupportAppScreen,
            screenFactory: ScreenFactory,
            isReplace: Boolean
        ) = SignUpFragment().apply {
            arguments = bundleOf(
                NEXT_SCREEN_ARG to nextScreen,
                SCREEN_FACTORY_ARG to screenFactory,
                IS_REPLACE_ARG to isReplace
            )
        }
    }
}