package com.example.codewarschallenge.presentation.activity.searchscreen

import android.os.Bundle
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
}