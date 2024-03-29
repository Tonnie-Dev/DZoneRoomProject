package com.androidshowtime.dzoneproject


import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.androidshowtime.dzoneproject.data.Movie
import com.androidshowtime.dzoneproject.data.MovieDao

@Database(entities = [Movie::class], version = 1)


abstract class AppDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao

    companion object {

       //  val INSTANCE by lazy {  }

        private var INSTANCE: AppDatabase? = null;

        fun getInstance(context: Context): AppDatabase? {


            if (INSTANCE == null) {

                synchronized(AppDatabase::class) {

                    INSTANCE = Room.databaseBuilder(
                            context.applicationContext,
                            AppDatabase::class.java, "movie-database"
                    ).build()
                }
            }
            return INSTANCE
        }

        fun destroyInstance() {

            INSTANCE = null
        }



    }


}





