package com.jang.mvvmjangstagram.login

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.jang.mvvmjangstagram.R
import com.jang.mvvmjangstagram.databinding.ActivityFindIdBinding

class FindIdActivity : AppCompatActivity() {
    lateinit var binding: ActivityFindIdBinding
    val FindIdViewModel : FindIdViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_find_id)
        binding.activity = true
        binding.viewModel = FindIdViewModel
        binding.lifecycleOwner = this
        setObserve()
    }
    fun setObserve(){
        FindIdViewModel.toastMessage.observe(this){
            if(!it.isEmpty()){
                Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
            }
        }
    }
}