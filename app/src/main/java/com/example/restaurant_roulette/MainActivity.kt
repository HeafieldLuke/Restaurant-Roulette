package com.example.restaurant_roulette

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.restaurant_roulette.fragments.ExploreFragment
import com.example.restaurant_roulette.fragments.HomeFragment
import com.example.restaurant_roulette.fragments.MapFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val homeFragment = HomeFragment()
        val exploreFragment = ExploreFragment()
        val mapFragment = MapFragment()

        makeCurrentFragment(homeFragment)

        bottom_navigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.ic__home -> makeCurrentFragment(homeFragment)
                R.id.ic__explore -> makeCurrentFragment(exploreFragment)
                R.id.ic__map -> makeCurrentFragment(mapFragment)
            }
            true
        }
    }
    
    private fun makeCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fl_wrapper, fragment)
            commit()
        }
}