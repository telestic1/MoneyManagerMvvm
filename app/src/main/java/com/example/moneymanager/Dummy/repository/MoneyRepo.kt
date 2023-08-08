package com.example.moneymanager.Dummy.repository

import androidx.lifecycle.LiveData
import com.example.moneymanager.Dummy.models.local.Money
import com.example.moneymanager.Dummy.models.local.MoneyDao

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MoneyRepo( val moneyDao: MoneyDao) {
//    private val api: TasksAPI = Networks.getRetrofit().create(TasksAPI::class.java)
//    private val responseHandler = ResponseHandler()

//    private val token =   "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2MTRjYjZiNWYwNDg1NDBiNWMxNDkzMmUiLCJpYXQiOjE2MzI0MTc0NjF9.B8kw7B3RitKIP64LEuWCqEfJg5AM832d3NnNjEfLhDQ"


    /*
    suspend fun login(loginRequestModel: LoginRequestModel): Resource<LoginResponses> {
        return try {
            val response = api.login(loginRequestModel)
            responseHandler.handleSuccess(response)
        } catch (e: Exception) {
            responseHandler.handleException(e)


        }


    }

    suspend fun SignUp(signUprequestModel: SignUprequestModel): Resource<LoginResponses> {
        return try {
            val responses = api.SignUp(signUprequestModel)
            responseHandler.handleSuccess(responses)
        } catch (e: Exception) {
            responseHandler.handleException(e)


        }

    }

*/


    fun addTaskToRoom(money: Money) {

        CoroutineScope(Dispatchers.IO).launch {
            moneyDao.addTask(money)

        }
    }

    fun getAllTask(): LiveData<List<Money>> {

        return moneyDao.getTask()

    }

    fun Update(money: Money) {

        CoroutineScope(Dispatchers.IO).launch {
            moneyDao.updateTask(money)

        }

    }


    fun delete(money: Money) {

        CoroutineScope(Dispatchers.IO).launch {
            moneyDao.deleteTask(money)

        }

    }

}