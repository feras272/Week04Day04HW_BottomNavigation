package com.example.week04day04hw

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private var toolbar:Toolbar? = null
    private var frameLayout:FrameLayout? = null
    private var bottomNavigation:BottomNavigationView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        connectViews()
        bottomNavigationClicks()
        chooseFragment(HomeFragment(), "HOME", "Home")
    }

    private fun connectViews() {
        toolbar = findViewById(R.id.toolbar_activity_main)
        frameLayout = findViewById(R.id.frame_layout_activity_main)
        bottomNavigation = findViewById(R.id.bottom_nav_activity_main)
    }

    private fun chooseFragment(fragment: Fragment, tag:String, title:String) {
        val fragmentTransaction: FragmentTransaction =supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout_activity_main, fragment, tag)
        fragmentTransaction.addToBackStack(tag)
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
        fragmentTransaction.commit()
        toolbar?.setTitle(title)
    }

    private fun bottomNavigationClicks() {
        bottomNavigation?.setOnItemSelectedListener{

            when(it.itemId) {
                R.id.home-> {
                    chooseFragment(HomeFragment(), "HOME", "Home")
                }
                R.id.dashboard-> {
                    chooseFragment(DashboardFragment(), "DASHBOARD", "Dashboard")
                }
                R.id.notification -> {
                    chooseFragment(NotificationFragment(), "NOTIFICATION", "Notification")
                }
                R.id.profile-> {
                    chooseFragment(ProfileFragment(), "PROFILE", "Profile")
                }
            }
            true
        }
    }
}