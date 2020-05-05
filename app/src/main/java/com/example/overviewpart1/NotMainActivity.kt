package com.example.overviewpart1

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class NotMainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startService(Intent(this, HelloService::class.java))
    }

}