package com.dicoding.picodiploma.loginwithanimation.data.retrofit

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.dicoding.picodiploma.loginwithanimation.data.entity.Story


@Dao
interface StoryDao {
    @Query("SELECT * FROM Story")
    fun getStories(): LiveData<List<Story>>
}