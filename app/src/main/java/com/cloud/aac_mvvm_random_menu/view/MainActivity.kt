package com.cloud.aac_mvvm_random_menu.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.cloud.aac_mvvm_random_menu.R
import com.cloud.aac_mvvm_random_menu.databinding.ActivityMainBinding
import com.cloud.aac_mvvm_random_menu.model.DataBase
import com.cloud.aac_mvvm_random_menu.viewmodel.ViewModel

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding
    lateinit var vm : ViewModel
    lateinit var menuText : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        menuText = findViewById(R.id.txt_menu)
        vm = ViewModel(DataBase().getInstance())
        binding.viewModel = vm
        binding.btnChoose.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                vm.getUser()
                menuText.text = vm.getWinner()
            }

        } );


    }
}