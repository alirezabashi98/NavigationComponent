package com.alireza.bashi.testnavigation

import android.os.Binder
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.alireza.bashi.testnavigation.databinding.FragmentWelcomeBinding

class WelcomeFragment : Fragment() {

    private var bainding: FragmentWelcomeBinding? = null
    private val args: WelcomeFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        bainding = FragmentWelcomeBinding.inflate(inflater, container, false)
        val view = bainding!!.root

        bainding!!.welcomeFragmentTextViewNameUser.text = args.username

        bainding!!.welcomeFragmentButtonOk.setOnClickListener {
            val action = WelcomeFragmentDirections.actionWelcomeFragmentToHomeFragment()
            view.findNavController().navigate(action)
        }

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        bainding = null
    }

}