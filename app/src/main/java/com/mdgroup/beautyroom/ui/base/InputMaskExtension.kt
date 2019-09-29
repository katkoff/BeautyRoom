package com.mdgroup.beautyroom.ui.base

import android.widget.EditText
import com.redmadrobot.inputmask.MaskedTextChangedListener


fun EditText.inputMask(mask: String, extractedValueListener: (String) -> Unit) {
    MaskedTextChangedListener.installOn(
        this,
        mask,
        object : MaskedTextChangedListener.ValueListener {
            override fun onTextChanged(maskFilled: Boolean, extractedValue: String, formattedValue: String) {
                extractedValueListener.invoke(extractedValue)
            }
        }
    )
}
