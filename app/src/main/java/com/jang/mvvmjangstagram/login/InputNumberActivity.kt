package com.jang.mvvmjangstagram.login

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.jang.mvvmjangstagram.R
import com.jang.mvvmjangstagram.databinding.ActivityInputNumberBinding

class InputNumberActivity : AppCompatActivity() {
    lateinit var binding : ActivityInputNumberBinding
    val inputNumberViewModel : InputNumberViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_input_number)
        binding.viewModel = inputNumberViewModel
        binding.lifecycleOwner = this
        setObserve()
    }
    fun setObserve(){
        inputNumberViewModel.nextPage.observe(this){
            if(it){
                finish()
                startActivity(Intent(this,LoginActivity::class.java))
            }
        }
    }
}