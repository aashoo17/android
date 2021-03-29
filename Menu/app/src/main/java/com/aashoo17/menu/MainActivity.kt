package com.aashoo17.menu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    //attach options menu from resource to activity
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu,menu)
        return true
    }
    //take action when any menu item is clicked/selected
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        //check the menu items id and take action based on it
        return when (item.itemId){
            R.id.setting -> {true}
            R.id.favourite -> {true}
            else -> super.onOptionsItemSelected(item)
        }
    }
}