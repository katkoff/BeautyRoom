package com.mdgroup.beautyroom.ui.master.details

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mdgroup.beautyroom.domain.model.Master
import ru.terrakok.cicerone.Router

class MasterDetailsViewModel(
    private val router: Router,
    private val masterId: String
) : ViewModel() {

    val master = MutableLiveData<Master>()

    init {
        master.value = Master(
            id = masterId,
            firstName = "Джесси",
            lastName = "Пинкман",
            mobilePhone = "+79239998877",
            information = "Лучший мастер бровей во всём Новосибирске! Брови как у Брежнева, Бейонс, " +
                    "или у вашего лучшего друга!",
            photo = "https://cdn.wallpapersafari.com/67/37/prDVYb.jpg",
            email = "whassup@gmail.com",
            address = "г. Новосибирск, ул. Николаева, 11"
        )
    }

    fun onBackPressed() {
        router.exit()
    }
}