package com.oleg.lec4hw

import android.content.Intent
import android.os.Bundle
import android.widget.Button

class MainActivity : ForceLightThemeMode() {
    lateinit var btnAbout:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnAbout = findViewById(R.id.btn_about)
        btnAbout.setOnClickListener{
            val aboutIntent = Intent(this,AboutActivity::class.java)
            startActivity(aboutIntent)
        }
    }
}