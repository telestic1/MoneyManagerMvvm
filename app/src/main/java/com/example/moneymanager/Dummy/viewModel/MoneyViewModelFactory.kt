package com.example.moneymanager.Dummy.viewModel


import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.moneymanager.Dummy.repository.MoneyRepo
class MoneyViewModelFactory(repo: MoneyRepo): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MoneyViewMOdel(repo) as T
        TODO("Not yet implemented")

    }



}