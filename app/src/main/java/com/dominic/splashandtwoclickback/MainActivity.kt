package com.dominic.splashandtwoclickback

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import com.dominic.splashandtwoclickback.databinding.ActivityMainBinding
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    var doubleTouchForExit = false
    lateinit var handler: Handler
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()



    }

    override fun onBackPressed() {
        if (doubleTouchForExit){
            super.onBackPressed()
            return
        }
        handler = Handler(Looper.getMainLooper())
        this.doubleTouchForExit = true
        Toast.makeText(this, "Please, Click Back again to exit", Toast.LENGTH_SHORT).show()
        handler.postDelayed({
                            doubleTouchForExit = false
        },2000)


    }
}
