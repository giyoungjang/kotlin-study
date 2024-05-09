package com.jang.mvvmjangstagram

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.content.PackageManagerCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.jang.mvvmjangstagram.databinding.ActivityMainBinding
import com.jang.mvvmjangstagram.fragment.AlarmFragment
import com.jang.mvvmjangstagram.fragment.DetailViewFragment
import com.jang.mvvmjangstagram.fragment.GridFragment
import com.jang.mvvmjangstagram.fragment.UserFragment

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),0)
        binding.bottomNavigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.action_home -> {
                    var f = DetailViewFragment()
                    supportFragmentManager.beginTransaction().replace(R.id.main_content, f).commit()
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.action_search -> {
                    var f = GridFragment()
                    supportFragmentManager.beginTransaction().replace(R.id.main_content, f).commit()
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.action_add_photo -> {
                    if(ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED){
                        var i = Intent(this, AddPhotoActivity::class.java)
                        startActivity(i)
                        )
                    }
                    return@setOnNavigationItemSelectedListener true
                }

                R.id.action_favorite_alarm -> {
                    var f = AlarmFragment()
                    supportFragmentManager.beginTransaction().replace(R.id.main_content, f).commit()
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.action_account -> {
                    var f = UserFragment()
                    supportFragmentManager.beginTransaction().replace(R.id.main_content, f).commit()
                    return@setOnNavigationItemSelectedListener true
                }
            }
            return@setOnNavigationItemSelectedListener false
        }
    }
}