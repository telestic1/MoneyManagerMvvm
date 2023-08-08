package com.example.moneymanager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.moneymanager.Dummy.adapter.MoneyAdapter
import com.example.moneymanager.Dummy.adapter.OnTaskItemClicked
import com.example.moneymanager.Dummy.models.local.Money
import com.example.moneymanager.Dummy.models.local.MoneyDao
import com.example.moneymanager.Dummy.models.local.TaskRoomDataBase
import com.example.moneymanager.Dummy.repository.MoneyRepo
import com.example.moneymanager.Dummy.viewModel.MoneyViewMOdel
import com.example.moneymanager.Dummy.viewModel.MoneyViewModelFactory
import com.example.moneymanager.databinding.ActivityMainBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity(), OnTaskItemClicked {
    lateinit var binding : ActivityMainBinding
    lateinit var roomDb: TaskRoomDataBase
    lateinit var moneyDao: MoneyDao
    lateinit var viewmodel: MoneyViewMOdel
//        val viewmodel: MoneyViewMOdel by viewModels()
    lateinit var moneyAdapter: MoneyAdapter
    private val transList = mutableListOf<Money>()
    var MAX_Balance = 10000
    var Balance_Remaing = MAX_Balance


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        roomDb = TaskRoomDataBase.getDatabaseObject(this)
        moneyDao = roomDb.MoneyDao()

        val repo = MoneyRepo(moneyDao)
        val viewMOdelFactory = MoneyViewModelFactory(repo)

//        viewmodel = ViewModelProviders.of(this, viewMOdelFactory).get(MoneyViewMOdel::class.java)

        viewmodel = ViewModelProviders.of(this, viewMOdelFactory).get(MoneyViewMOdel::class.java)

        binding.tvCloseAmount.setText(Balance_Remaing.toString())
        binding.tvOpenAmount.setText(MAX_Balance.toString())
        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener { view ->

            showHide(binding.addlayout.root)
            showHide(binding.recyclerview)
            showHide(binding.fab)

        }
        binding.addlayout.Addbutton.setOnClickListener {
            binding.addlayout.apply {
                var name =   tvName.text.toString()
                var amount =   tvAmountAddTask.text.toString()
                var reason =   tvReason.text.toString()
                var opingbalance =   binding.tvOpenAmount.text.toString()
                if ((name != null) && (amount != null) && (reason != null)) {
                    val newTask = Money(name, reason, amount)
                    viewmodel.addTask(newTask)
//
                }


                Balance_Remaing -= amount.toInt();
                MAX_Balance = opingbalance.toInt()

                showHide(binding.addlayout.root)
                showHide(binding.recyclerview)
                showHide(binding.fab)
                binding.tvCloseAmount.setText(Balance_Remaing.toString())
                binding.tvOpenAmount.setText(opingbalance)
            }








        }

        moneyAdapter = MoneyAdapter(this, transList, this)
        binding.recyclerview.layoutManager = LinearLayoutManager(this)
        binding.recyclerview.adapter = moneyAdapter

        viewmodel.getTasks().observe(this, Observer {
            transList.clear()
            transList.addAll(it)
            moneyAdapter.notifyDataSetChanged()
        })


    }


    override fun OnEditClicked(money: Money) {

        showHide(binding.editLayout.root)
        showHide(binding.recyclerview)
        showHide(binding.fab)

        if (binding.editLayout.tvName.text != null) {

            binding.editLayout.apply {
                val newName =   tvName.text.toString()
                val newReason =   tvReason.text.toString()
                val newAmount =   tvAmountAddTask.text.toString()

                money.name = newName
                money.reason = newReason
                money.amount = newAmount
            }



            viewmodel.upDateTask(money)

        }
        binding.editLayout.Addbutton.setOnClickListener {
            showHide(binding.editLayout.root)
            showHide(binding.recyclerview)
            showHide(binding.fab)

            viewmodel.upDateTask(money)

        }

    }

    override fun OnDeleteClicked(money: Money) {
        viewmodel.deleteTask(money)
    }

    fun showHide(view: View) {
        view.visibility = if (view.visibility == View.VISIBLE) {
            View.INVISIBLE
        } else {
            View.VISIBLE
        }
    }
}
