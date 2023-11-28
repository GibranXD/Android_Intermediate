package com.dicoding.picodiploma.loginwithanimation.view.story

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.dicoding.picodiploma.loginwithanimation.data.response.DetailResponse
import com.dicoding.picodiploma.loginwithanimation.databinding.ActivityDetailStoryBinding
import com.dicoding.picodiploma.loginwithanimation.view.ViewModelFactory

class DetailStoryActivity : AppCompatActivity(){

    private lateinit var binding: ActivityDetailStoryBinding

    private lateinit var detailViewModel: DetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailStoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        detailViewModel = obtainViewModel(this@DetailStoryActivity)

        var token = ""

        val id = intent.getStringExtra("id")

        detailViewModel.getSession().observe(this){ session ->
            if(session.isLogin){
                token = session.token
                if(id != null){
                    val stories = token?.let { detailViewModel.getStoryDetail(id, it) }
                    Log.d("token", "id: $token")
                    if(stories == true) Toast.makeText(this@DetailStoryActivity, "Cannot retrieve story data", Toast.LENGTH_SHORT)
                }
            }
        }

       detailViewModel.detailStory.observe(this){ story ->
           setDetailStory(story)
       }

        detailViewModel.isLoading.observe(this){
            showLoading(it)
        }

        supportActionBar?.show()

        supportActionBar?.title = "Detail Story"
    }

    private fun setDetailStory(story: DetailResponse){
        binding.tvStoryUser.text = story.story?.name
        binding.tvStoryDesc.text = story.story?.description
        Glide
            .with(binding.root.context)
            .load(story.story?.photoUrl)
            .into(binding.ivStory)
    }

    private fun showLoading(isLoading: Boolean) {
        if (isLoading) {
            binding.progressSay.visibility = View.VISIBLE
        } else {
            binding.progressSay.visibility = View.GONE
        }
    }

    private fun obtainViewModel(activity: AppCompatActivity): DetailViewModel{
        val factory = ViewModelFactory.getInstance(activity.application)
        return ViewModelProvider(activity, factory).get(DetailViewModel::class.java)
    }


}