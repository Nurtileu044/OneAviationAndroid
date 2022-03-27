package com.ablazim.oneaviationandroid

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.ablazim.oneaviationandroid.databinding.ActivitySingleBinding
import com.ablazim.oneaviationandroid.extensions.replaceFragment
import com.ablazim.oneaviationandroid.splash.ui.SplashFragment

class SingleActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySingleBinding
    private var airplaneModeChangedReceiver: BroadcastReceiver? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySingleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        airplaneModeChangedReceiver = object : BroadcastReceiver() {
            override fun onReceive(context: Context?, intent: Intent?) {
                if (intent?.action == Intent.ACTION_AIRPLANE_MODE_CHANGED) {
                    Toast.makeText(
                        this@SingleActivity,
                        "AIRPLANE MODE is ${intent.categories}, ${intent.extras}, ${intent.dataString}",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
        }

        if (savedInstanceState == null) {
            replaceFragment(SplashFragment())
        }

        registerReceiver(
            airplaneModeChangedReceiver, IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED)
        )
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(airplaneModeChangedReceiver)
    }
}