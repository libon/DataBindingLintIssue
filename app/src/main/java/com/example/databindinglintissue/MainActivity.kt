package com.example.databindinglintissue

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.databindinglintissue.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // Use the following instead to not have a lint warning:
        //DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
    }
}
