package com.oleg.lec4hw

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.protocol.HTTP

class AboutActivity : AppCompatActivity() {
    lateinit var btnSms:FloatingActionButton
    lateinit var btnEmail:FloatingActionButton
    lateinit var btnCall:FloatingActionButton
    lateinit var btnBrauser:FloatingActionButton
    lateinit var btnMap:FloatingActionButton


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_abaut)

        findViews()
        handleEvents()
    }

    private fun handleEvents() {
        btnBrauser.setOnClickListener{
            vieWebSite()
        }
        btnCall.setOnClickListener{
            dialPhone()
        }
        btnMap.setOnClickListener{
            showMap()
        }
        btnEmail.setOnClickListener{
            showEmail()
        }
        btnSms.setOnClickListener{
            showSms()
        }
    }

    private fun showSms() {
        val intent = Intent(Intent.ACTION_SENDTO).apply {
            data = Uri.parse("smsto:0546205370")
        }
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }
    }

    private fun showEmail() {
        val intent = Intent(Intent.ACTION_SENDTO).apply {
            data = Uri.parse("mailto:olegkovalinsky@gmail.com")
            putExtra(Intent.EXTRA_TEXT, "hello my friend")
        }

            startActivity(intent)

    }

    private fun showMap() {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("geo:47.6,-122.3?z=12"))
        startActivity(intent)
    }

    private fun dialPhone() {
        val uri = Uri.parse("tel:0546205370")
        val intent = Intent(Intent.ACTION_DIAL,uri)
        startActivity(intent)
    }

    private fun vieWebSite() {
        val uri = Uri.parse("https://developer.android.com/")
        val intent = Intent(Intent.ACTION_VIEW,uri)
        startActivity(intent)
    }

    private fun findViews() {
        btnSms = findViewById(R.id.btn_sms)
        btnBrauser = findViewById(R.id.btn_Brauser)
        btnMap = findViewById(R.id.btn_map)
        btnEmail = findViewById(R.id.btn_email)
        btnCall = findViewById(R.id.btn_call)
    }
}