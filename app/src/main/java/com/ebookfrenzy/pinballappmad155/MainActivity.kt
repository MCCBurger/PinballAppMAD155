package com.ebookfrenzy.pinballappmad155

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val playLog = PlayLogFragment()
        val findLocation = FindLocationFragment()

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment, playLog)
            commit()
        }

        btnLog.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.flFragment, playLog)
                addToBackStack(null)
                commit()
            }

        }

        btnFind.setOnClickListener {

            supportFragmentManager.beginTransaction().apply {
                replace(R.id.flFragment, findLocation)
                addToBackStack(null)
                commit()
            }
        }

        btnDirectory.setOnClickListener {
            val  intent = Intent(this,PinballDirectory::class.java)
                    startActivity (intent)
        }

    }
}