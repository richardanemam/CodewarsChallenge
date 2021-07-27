package com.example.codewarschallenge.presentation.activity.challengesscreen

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.codewarschallenge.R
import com.example.codewarschallenge.databinding.ActivityChallengesBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class ChallengesActivity : AppCompatActivity() {

    private val binding by lazy { ActivityChallengesBinding.inflate(layoutInflater) }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        setContentView(binding.root)
        setUpViews()

    }

    private fun setUpViews() {
        binding.bnvChallengesMenu.setOnNavigationItemSelectedListener(object: BottomNavigationView.OnNavigationItemSelectedListener{
            override fun onNavigationItemSelected(item: MenuItem): Boolean {
                when(item.itemId) {
                    R.id.menu_challenges_complete -> {
                        //navigateTo(Comple)
                    }
                    R.id.menu_challenges_authored -> {

                    }
                }
                return true
            }

        })
    }

    private fun navigateTo(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(binding.flChallengesContainer.id, fragment)
            .commit()
    }


}