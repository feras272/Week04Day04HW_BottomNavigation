package com.example.week04day04hw

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import android.widget.Toolbar
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private var toolbar:Toolbar? = null
    private var frameLayout:FrameLayout? = null
    private var bottomNavigation:BottomNavigationView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        connectViews()
    }

    private fun connectViews() {
        toolbar = findViewById(R.id.toolbar_activity_main)
        frameLayout = findViewById(R.id.frame_layout_activity_main)
        bottomNavigation = findViewById(R.id.bottom_nav_activity_main)
    }
}