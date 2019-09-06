package com.mdgroup.beautyroom.di.modules

import com.mdgroup.beautyroom.ui.bottomnavigation.BottomNavigationViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val bottomNavigationModule = module {
    viewModel { BottomNavigationViewModel() }
}