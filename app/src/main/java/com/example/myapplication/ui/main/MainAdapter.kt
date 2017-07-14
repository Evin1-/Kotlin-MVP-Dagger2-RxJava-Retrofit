package com.example.myapplication.ui.main

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication.R
import com.example.myapplication.data.entities.Repository
import kotlinx.android.synthetic.main.recycler_row.view.*

/**
 * Created by user on 7/14/17.
 */
class MainAdapter(val repositoryList: List<Repository>, val listener: (Repository) -> Unit) : RecyclerView.Adapter<MainAdapter.ViewHolder>() {
    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(repositoryList.get(position), listener)

    override fun getItemCount(): Int = repositoryList.size

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val layoutInflater: LayoutInflater = LayoutInflater.from(parent?.context)
        val view: View = layoutInflater.inflate(R.layout.recycler_row, parent, false)
        return ViewHolder(view)
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(repository: Repository, listener: (Repository) -> Unit) = with(itemView) {
            r_main_txt.text = repository.toString()
            setOnClickListener { listener(repository) }
        }
    }
}