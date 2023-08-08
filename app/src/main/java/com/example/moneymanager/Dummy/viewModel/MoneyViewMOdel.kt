package com.example.moneymanager.Dummy.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.moneymanager.Dummy.models.local.Money
import com.example.moneymanager.Dummy.repository.MoneyRepo
import kotlinx.coroutines.Dispatchers

class MoneyViewMOdel (val repo: MoneyRepo) : ViewModel(){


    /*
    fun userLogin(loginRequestModel: LoginRequestModel): LiveData<Resource<LoginResponses>> {

        val livedata = liveData(Dispatchers.IO) {
            val result = repo.login(loginRequestModel)
            emit(result)
        }

        return livedata

    }

    fun userAccount(signUprequestModel: SignUprequestModel): LiveData<Resource<LoginResponses>> {

        val liveData = liveData(Dispatchers.IO) {
            val result = repo.SignUp(signUprequestModel)
            emit(result)
        }

        return liveData

    }
    */




    fun addTask(money: Money) {
        repo.addTaskToRoom(money)
    }

    fun getTasks(): LiveData<List<Money>> {
        return repo.getAllTask()
    }

    fun upDateTask(money: Money){
        repo.Update(money)
    }

    fun deleteTask(money: Money){
        repo.delete(money)
    }

}
