package com.davidodari.splashy.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.davidodari.splashy.R

/**Host Activity for fragments**/
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
