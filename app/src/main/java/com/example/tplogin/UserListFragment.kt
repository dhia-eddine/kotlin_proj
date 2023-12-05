package com.example.tplogin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.tplogin.databinding.FragmentUsersListBinding


class UserListFragment : Fragment() {

    override fun onCreateView(

        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        val binding = FragmentUsersListBinding.inflate(layoutInflater, container, false)

        setData(binding)
        return binding.root

    }


    private fun setData(binding: FragmentUsersListBinding) {

    }

}