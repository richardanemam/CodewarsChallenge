package com.example.codewarschallenge.presentation.activity.searchscreen

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.codewarschallenge.R
import com.example.codewarschallenge.databinding.ActivitySearchScreenBinding
import com.example.codewarschallenge.domain.model.User
import com.example.codewarschallenge.mainapplication.MainApplication
import com.example.codewarschallenge.presentation.adapter.UsersInfoAdapter
import com.example.codewarschallenge.presentation.states.UserInfoState
import javax.inject.Inject

class SearchScreenActivity: AppCompatActivity() {

    private val binding by lazy { ActivitySearchScreenBinding.inflate(layoutInflater) }
    private val users = mutableListOf<User>()

    @Inject
    lateinit var viewModel: SearchScreenViewModel

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        setContentView(binding.root)

        (application as MainApplication).getApplicationComponent().injection(this)
        setUpViews()
        subscribeUI()
    }

    private fun setUpViews() {
        setUpToolbarsBackButton()
        setUpSearchView()
    }

    private fun subscribeUI() {
        subscribeUser()
    }

    private fun setUpToolbarsBackButton() {
        setSupportActionBar(binding.toolbarSearchScreenId)
        val actionBar = supportActionBar
        actionBar?.apply {
            setTitle(R.string.search_toolbar_title)
            setDisplayHomeAsUpEnabled(true)
        }
    }

    private fun setUpUserRecyclerView(users: List<User>) {
        binding.rvSearchScreenRecentSearches.adapter = UsersInfoAdapter(users)
        binding.rvSearchScreenRecentSearches.layoutManager = LinearLayoutManager(this)
    }

    private fun subscribeUser() {
        viewModel.onUserInfoState.observe(this, {
            when(it) {
                is UserInfoState.UserInfoAvailable -> {
                    users.add(it.user)
                    setUpUserRecyclerView(users)
                }
            }
        })
    }

    private fun setUpSearchView() {
        binding.svSearchScreenSearchMember.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                query?.let { viewModel.fetchUserByName(it) }
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                //Do nothing
                return false
            }

        })
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