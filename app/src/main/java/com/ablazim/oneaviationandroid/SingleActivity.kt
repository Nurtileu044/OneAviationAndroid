package com.ablazim.oneaviationandroid

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ablazim.oneaviationandroid.databinding.ActivitySingleBinding
import com.ablazim.oneaviationandroid.extensions.replaceFragment
import com.ablazim.oneaviationandroid.splash.ui.SplashFragment

class SingleActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySingleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySingleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if(savedInstanceState == null) {
            replaceFragment(SplashFragment())
        }
    }
}