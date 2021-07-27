package com.example.codewarschallenge.presentation.activity.searchscreen

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.SearchView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.codewarschallenge.R
import com.example.codewarschallenge.databinding.ActivitySearchScreenBinding
import com.example.codewarschallenge.domain.listener.ShowChallengesListener
import com.example.codewarschallenge.mainapplication.MainApplication
import com.example.codewarschallenge.presentation.activity.challengesscreen.ChallengesActivity
import com.example.codewarschallenge.presentation.adapter.UsersInfoAdapter
import com.example.codewarschallenge.presentation.states.ProgressbarState
import com.example.codewarschallenge.presentation.states.UserInfoState
import javax.inject.Inject

class SearchScreenActivity: AppCompatActivity(), ShowChallengesListener {

    private val binding by lazy { ActivitySearchScreenBinding.inflate(layoutInflater) }
    private val adapter by lazy { UsersInfoAdapter(this) }

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
        setUpUserRecyclerView()
    }

    private fun subscribeUI() {
        subscribeUser()
        subscribeProgressbar()
    }

    private fun setUpToolbarsBackButton() {
        setSupportActionBar(binding.toolbarSearchScreenId)
        val actionBar = supportActionBar
        actionBar?.apply {
            setTitle(R.string.search_toolbar_title)
            setDisplayHomeAsUpEnabled(true)
        }
    }

    private fun setUpUserRecyclerView() {
        binding.rvSearchScreenRecentSearches.adapter = adapter
        binding.rvSearchScreenRecentSearches.layoutManager = LinearLayoutManager(this)
    }

    private fun subscribeUser() {
        viewModel.onUserInfoState.observe(this, {
            when(it) {
                is UserInfoState.OnUserInfoAvailable -> {
                    binding.tvSearchScreenSearchForNewUsers.visibility = View.GONE
                    adapter.updateUsers(it.user)
                }
                UserInfoState.OnUserInfoUnavailable -> {
                    Toast.makeText(this, getString(R.string.search_screen_user_not_found_message), Toast.LENGTH_LONG).show()
                }
            }
        })
    }

    private fun subscribeProgressbar() {
        viewModel.onProgressbarState.observe(this, {
            when(it) {
                ProgressbarState.Show -> {
                    binding.tvSearchScreenSearchForNewUsers.visibility = View.GONE
                    binding.pbSearchScreen.visibility = View.VISIBLE
                }
                ProgressbarState.Hide -> {
                    binding.pbSearchScreen.visibility = View.GONE
                }
            }
        })
    }

    private fun setUpSearchView() {
        binding.svSearchScreenSearchMember.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                query?.let {
                    viewModel.fetchUserByName(it)
                    val intent = Intent(this@SearchScreenActivity, ChallengesActivity::class.java)
                    intent.putExtra(ChallengesActivity.EXTRA_USER_NAME, query)
                    startActivity(intent)
                }
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
                adapter.updateUsers(viewModel.orderUserListByRank())
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onClickShowChallenges(username: String) {
        val intent = Intent(this@SearchScreenActivity, ChallengesActivity::class.java)
        intent.putExtra(ChallengesActivity.EXTRA_USER_NAME, username)
        startActivity(intent)
    }
}