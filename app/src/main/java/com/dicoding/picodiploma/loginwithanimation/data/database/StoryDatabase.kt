package com.dicoding.picodiploma.loginwithanimation.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.dicoding.picodiploma.loginwithanimation.data.retrofit.StoryDao
import com.dicoding.picodiploma.loginwithanimation.data.entity.Story

@Database(entities = [Story::class], version = 1)
abstract class StoryDatabase : RoomDatabase(){
    abstract fun storiesDao(): StoryDao

    companion object {
        @Volatile
        private var INSTANCE: StoryDatabase? = null

        @JvmStatic
        fun getDatabase(context: Context): StoryDatabase {
            if (INSTANCE == null){
                synchronized(StoryDatabase::class.java){
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                        StoryDatabase::class.java, "story_database")
                        .build()
                }
            }
            return INSTANCE as StoryDatabase
        }
    }
}