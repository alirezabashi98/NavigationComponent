package com.alireza.bashi.testnavigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.alireza.bashi.testnavigation.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    private var bainding: FragmentHomeBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        bainding = FragmentHomeBinding.inflate(inflater, container, false)
        val view = bainding!!.root

        // set on clicked button go to login
        onClickButtonGoToLogin(view)

        return view
    }

    private fun onClickButtonGoToLogin(view: View) {

        bainding!!.button.setOnClickListener {

            val action = HomeFragmentDirections.actionHomeFragmentToLoginFragment()
            view.findNavController().navigate(action)

        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        bainding = null
    }

}