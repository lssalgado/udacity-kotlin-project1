package com.udacity.shoestore

import android.os.Bundle
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.udacity.shoestore.databinding.MainActivityBinding
import com.udacity.shoestore.screens.instructions.InstructionsFragmentDirections
import com.udacity.shoestore.screens.shoelist.ShoeListFragment

class MainActivity : AppCompatActivity() {

    lateinit var navController: NavController
    lateinit var viewModel: MainActivityViewModel
    lateinit var binding: MainActivityBinding
    lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(
            this,
            R.layout.main_activity
        )

        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)

        navController = findNavController(R.id.navHostFragment)
        appBarConfiguration = AppBarConfiguration(navController.graph)

        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration)
    }

    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(navController, appBarConfiguration)
    }


}
