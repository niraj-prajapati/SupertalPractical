package com.supertal.practical.ui.main

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.supertal.practical.R
import com.supertal.practical.databinding.ListItemUsersBinding
import com.supertal.practical.models.UsersItem

class UsersAdapter(private val userClickListener: UserClickListener) :
    RecyclerView.Adapter<UsersAdapter.ItemHolder>() {

    private var list: ArrayList<UsersItem> = arrayListOf()
    private lateinit var context: Context

    class ItemHolder(view: ListItemUsersBinding) : RecyclerView.ViewHolder(view.root) {
        val ivProfilePhoto = view.ivProfilePhoto
        val tvUserName = view.tvUserName
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        context = parent.context
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ListItemUsersBinding.inflate(layoutInflater, parent, false)
        return ItemHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        val item = list[holder.adapterPosition]
        holder.apply {
            Glide.with(context).load(item.imageUrl)
                .placeholder(R.mipmap.ic_launcher_foreground)
                .into(ivProfilePhoto)
            tvUserName.text = item.name
            itemView.setOnClickListener {
                userClickListener.onUserClicked(item)
            }
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    //update users when fetched
    fun updateData(list: ArrayList<UsersItem>) {
        this.list = list
        notifyDataSetChanged()
    }

    //interface to handle click of user item
    interface UserClickListener {
        fun onUserClicked(usersItem: UsersItem)
    }
}