package com.alvinnanda.submission1githubuser

import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView




class MainActivity : AppCompatActivity() {

    private lateinit var rvUser: RecyclerView
    private val list = ArrayList<User>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvUser = findViewById(R.id.rv_User)
        rvUser.setHasFixedSize(true)

        list.addAll(listUser)
        showRecyclerList()
    }
    private val listUser: ArrayList<User>
        get() {
            val dataUser = ArrayList<User>()
            val dataName = resources.getStringArray(R.array.name)
            val dataLocation = resources.getStringArray(R.array.location)
            val dataPhoto = resources.obtainTypedArray(R.array.avatar)
            val dataUserName = resources.getStringArray(R.array.username)
            val dataRepository = resources.getStringArray(R.array.repository)
            val dataCompany = resources.getStringArray(R.array.company)
            val dataFollowers = resources.getStringArray(R.array.followers)
            val dataFollowing = resources.getStringArray(R.array.following)
            for (i in dataName.indices) {
                val user = User(dataName[i],dataLocation[i], dataPhoto.getResourceId(i, -1),dataUserName[i],dataRepository[i],dataCompany[i],dataFollowers[i],dataFollowing[i])
                dataUser.add(user)
            }
            return dataUser
        }



    private fun showRecyclerList() {
        if (applicationContext.resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            rvUser.layoutManager = GridLayoutManager(this, 2)
        } else {
            rvUser.layoutManager = LinearLayoutManager(this)
        }

        val listUserAdapter = ListUserAdapter(list)
        rvUser.adapter = listUserAdapter

        listUserAdapter.setOnItemClickCallback(object : ListUserAdapter.OnItemClickCallback {
            override fun onItemClicked(data: User) {
                showSelectedUser(data)

            }
        })
    }

    private fun showSelectedUser(user: User)  {
        val intent = Intent(this@MainActivity, DetailUserActivity::class.java)
        intent.putExtra(DetailUserActivity.DATA, user)
        startActivity(intent)
    }

}


