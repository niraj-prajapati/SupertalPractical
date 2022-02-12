package com.supertal.practical.ui.userdetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.supertal.practical.R
import com.supertal.practical.databinding.UserDetailsFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UserDetailsFragment : Fragment() {

    private lateinit var binding: UserDetailsFragmentBinding
    private val viewModel: UserDetailsViewModel by viewModels()
    private val args: UserDetailsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = UserDetailsFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    /**
     * init variables and views
     */
    private fun initViews() {
        val usersItem = args.userObj

        binding.apply {
            Glide.with(requireContext()).load(usersItem.imageUrl)
                .placeholder(R.mipmap.ic_launcher_foreground)
                .into(ivProfilePhoto)
            tvUserName.text = usersItem.name
        }
    }
}