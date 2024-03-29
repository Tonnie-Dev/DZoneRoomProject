package com.androidshowtime.dzoneproject

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.androidshowtime.dzoneproject.fragments.MovieListFragment
import com.androidshowtime.dzoneproject.fragments.NewMovieFragment
import timber.log.Timber

class MainActivity : AppCompatActivity(), NewMovieFragment.OnFragmentInteractionListener,
                     MovieListFragment.OnFragmentInteractionListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (BuildConfig.DEBUG){
            Timber.plant(Timber.DebugTree())

        }

        if (savedInstanceState == null) {
            goToMovieListFragment()
        }



    }


    override fun goToNewMovieFragment() {

        val manager = supportFragmentManager
        val transaction = manager.beginTransaction()
        transaction.replace(R.id.flContent, NewMovieFragment.newInstance())
        transaction.commit()

    }

    override fun goToMovieListFragment() {


        val manager = supportFragmentManager
        val transaction = manager.beginTransaction()
        transaction.replace(R.id.flContent, MovieListFragment.newInstance())
        transaction.commit()
    }
}
