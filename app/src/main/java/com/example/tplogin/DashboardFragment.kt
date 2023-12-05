package com.example.tplogin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.tplogin.databinding.FragmentDashboardBinding
import com.google.firebase.auth.FirebaseAuth

class DashboardFragment : Fragment() {
    var auth = FirebaseAuth.getInstance()
    var user = auth.currentUser!!
    override fun onCreateView(

        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        val binding = FragmentDashboardBinding.inflate(layoutInflater, container, false)

        setData(binding)
        return binding.root
        auth = FirebaseAuth.getInstance()
        user = auth.currentUser!!}


    private fun setData(binding: FragmentDashboardBinding) {
        binding.tvDetails.text=user!!.email.toString()

    }

}