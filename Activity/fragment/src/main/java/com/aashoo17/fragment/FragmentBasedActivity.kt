package com.aashoo17.fragment

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class FragmentBasedActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment_based)

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.apply {
            add(R.id.fragmentContainer,BasicFragment())
        }

        //commit when all needed transaction which are to be done are completed
        fragmentTransaction.commit()
    }
}