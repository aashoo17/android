package com.aashoo17.navigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment.findNavController

class FirstFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view =  inflater.inflate(R.layout.fragment_first, container, false)
        val navController = findNavController(this)

        val textView = view.findViewById<TextView>(R.id.textView)
        textView.setOnClickListener{
            navController.navigate(R.id.action_firstFragment_to_secondFragment)
        }
        return view
    }
}