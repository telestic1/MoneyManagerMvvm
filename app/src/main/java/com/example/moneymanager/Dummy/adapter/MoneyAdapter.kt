package com.example.moneymanager.Dummy.adapter

import android.content.Context
import android.os.Parcel
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.moneymanager.Dummy.models.local.Money
import com.example.moneymanager.R

class MoneyAdapter(val context: Context,
                   val transList: MutableList<Money>,
                   val listener: OnTaskItemClicked

    ) : RecyclerView.Adapter<MoneyAdapter.TaskViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
            val inflater = LayoutInflater.from(context)
            val view1: View = inflater.inflate(R.layout.task_item_row, parent, false)
            return TaskViewHolder(view1)

        }

        override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
            val transation = transList.get(position)
            holder.name.text = transation.name
            holder.reason.text = transation.reason
            holder.amount.text = transation.amount

            holder.editTv.setOnClickListener {
                listener.OnEditClicked(transation)
            }
            holder.delete.setOnClickListener {
                listener.OnDeleteClicked(transation)
            }

        }

        override fun getItemCount(): Int {
            return transList.size
        }


        class TaskViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            var name: TextView
            var reason: TextView
            var amount: TextView

            var editTv: TextView
            var delete: TextView


            init {

                name = itemView.findViewById(R.id.tvName)
                reason = itemView.findViewById(R.id.tvReason)
                amount = itemView.findViewById(R.id.tvAmount)

                editTv = itemView.findViewById(R.id.editTv)
                delete = itemView.findViewById(R.id.deleteTv)

            }
        }

}
