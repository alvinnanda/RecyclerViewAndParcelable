package com.alvinnanda.submission1githubuser


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import de.hdodenhof.circleimageview.CircleImageView

class DetailUserActivity : AppCompatActivity() {
    companion object {
        const val DATA = "data"
    }

    private lateinit var txtName: TextView
    private lateinit var txtLocation: TextView
    private lateinit var txtUsername: TextView
    private lateinit var txtCompany: TextView
    private lateinit var txtFollowing: TextView
    private lateinit var txtFollower: TextView
    private lateinit var txtRepository: TextView
    private lateinit var imgAvatar: CircleImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_user)

        val user = intent.getParcelableExtra<User>(DATA)!!



        txtName = findViewById(R.id.txtName)
        txtName.setText(user.name)
        txtLocation = findViewById(R.id.txtLocation)
        txtLocation.setText(user.location)
        txtUsername= findViewById(R.id.txtUsername)
        txtUsername.setText(user.username)
        txtCompany= findViewById(R.id.txt_company)
        txtCompany.setText(user.company)
        txtFollowing= findViewById(R.id.txtFolloing)
        txtFollowing.setText(user.following)
        txtFollower= findViewById(R.id.txtFollower)
        txtFollower.setText(user.followers)
        txtRepository= findViewById(R.id.txtRepository)
        txtRepository.setText(user.repository)
        imgAvatar= findViewById(R.id.imgAvatar)
        imgAvatar.setImageResource(user.photo)

    }
}


