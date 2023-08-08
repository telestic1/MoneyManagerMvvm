package com.example.moneymanager.Dummy.adapter

import com.example.moneymanager.Dummy.models.local.Money


interface OnTaskItemClicked {

    fun OnEditClicked(money: Money)
    fun OnDeleteClicked(money: Money)
}




