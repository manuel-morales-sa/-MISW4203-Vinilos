package com.vinylsMobile.vinylsApplication.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.vinylsMobile.vinylsApplication.data.api.ApiHelper
import com.vinylsMobile.vinylsApplication.data.repository.CollectorRepository
import com.vinylsMobile.vinylsApplication.ui.main.viewmodel.CollectorViewModel

class CollectorViewModelFactory(private val apiHelper: ApiHelper) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CollectorViewModel::class.java)) {
            return CollectorViewModel(CollectorRepository(apiHelper)) as T
        }
        throw IllegalArgumentException("Clase desconocida")
    }

}