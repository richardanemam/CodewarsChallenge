package com.example.codewarschallenge.presentation.activity.searchscreen

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.example.codewarschallenge.R
import com.example.codewarschallenge.databinding.ActivitySearchScreenBinding

class SearchScreenActivity: AppCompatActivity() {

    private val binding by lazy { ActivitySearchScreenBinding.inflate(layoutInflater) }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        setContentView(binding.root)

        setUpViews()
    }

    private fun setUpViews() {
        setUpToolbarsBackButton()
    }

    private fun setUpToolbarsBackButton() {
        setSupportActionBar(binding.toolbarSearchScreenId)
        val actionBar = supportActionBar
        actionBar?.apply {
            setTitle(R.string.search_toolbar_title)
            setDisplayHomeAsUpEnabled(true)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu_order, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId) {
            R.id.menu_order_by_rank -> {
                //TODO order by rank
                true
            }
            R.id.menu_order_by_search -> {
                //TODO order by search
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}