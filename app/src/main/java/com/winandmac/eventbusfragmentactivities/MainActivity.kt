package com.winandmac.eventbusfragmentactivities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.navigation.NavigationBarView
import com.winandmac.eventbusfragmentactivities.fragments.PublisherFragment
import com.winandmac.eventbusfragmentactivities.fragments.SubscriberAFragment
import java.util.concurrent.Flow.Publisher

class MainActivity : AppCompatActivity() {

    // Init all the fragments
    private val publisherFragment = PublisherFragment()
    private val subscriberAFragment = SubscriberAFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Start the app with the Publisher fragment
        replaceFragment(publisherFragment)

        // Add the actions for the bottom navigation bar
        val bottomNavigationBarView = findViewById<NavigationBarView>(R.id.bottom_navigation)
        bottomNavigationBarView.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.menu_publisher -> replaceFragment(publisherFragment)
                R.id.menu_subscribera -> replaceFragment(subscriberAFragment)
            }
            true
        }
    }

    // Function to replace the fragment
    private fun replaceFragment(fragment: Fragment) {
        if (fragment != null) {
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container, fragment)
            transaction.commit()
        }
    }
}