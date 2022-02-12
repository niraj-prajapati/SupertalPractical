package com.supertal.practical.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.supertal.practical.R
import com.supertal.practical.databinding.MainFragmentBinding
import com.supertal.practical.models.Result
import com.supertal.practical.models.UsersItem
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment() {

    private lateinit var binding: MainFragmentBinding
    private val viewModel: MainViewModel by viewModels()
    private lateinit var usersAdapter: UsersAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = MainFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        bindLiveData()
    }

    /**
     * init variables and views
     */
    private fun initViews() {
        usersAdapter = UsersAdapter(object : UsersAdapter.UserClickListener {
            override fun onUserClicked(usersItem: UsersItem) {
                val action: NavDirections =
                    MainFragmentDirections.actionMainFragmentToUserDetailsFragment(usersItem)
                findNavController().navigate(action)
            }
        })

        binding.apply {
            swipeRefreshLayout.isRefreshing = true
            rvUsers.layoutManager = LinearLayoutManager(requireContext())
            rvUsers.adapter = usersAdapter
            swipeRefreshLayout.setOnRefreshListener {
                tvErrorRV.isVisible = false
                usersAdapter.updateData(arrayListOf())
                swipeRefreshLayout.isRefreshing = true
                viewModel.getUsers()
            }
        }
    }

    /**
     * observe livedata
     */
    private fun bindLiveData() {
        viewModel.apply {
            usersLiveData.observe(viewLifecycleOwner) { result ->
                when (result.status) {
                    Result.Status.SUCCESS -> {
                        result.data?.let { users ->
                            binding.apply {
                                val isUsersEmpty = users.isNullOrEmpty()
                                rvUsers.isVisible = isUsersEmpty.not()
                                tvErrorRV.apply {
                                    isVisible = isUsersEmpty
                                    text = getString(R.string.empty_users)
                                }
                                if (isUsersEmpty.not()) {
                                    usersAdapter.updateData(users)
                                }
                            }
                        }
                        binding.swipeRefreshLayout.isRefreshing = false
                    }

                    Result.Status.ERROR -> {
                        result.message?.let {
                            binding.tvErrorRV.apply {
                                isVisible = true
                                text = getString(R.string.error, it)
                            }
                        }
                        binding.swipeRefreshLayout.isRefreshing = false
                    }

                    Result.Status.LOADING -> {
                        binding.swipeRefreshLayout.isRefreshing = true
                    }
                }
            }
        }
    }
}