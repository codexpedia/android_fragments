package com.example.fragments

import android.app.Activity
import android.app.Fragment
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem

class MainActivity : Activity() {

    private var fragTag: String? = ""
    private var mCurrentFrag: Fragment? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState != null) {
            fragTag = savedInstanceState.getString("frag_tag")
            //            mCurrentFrag = getFragmentManager().getFragment(savedInstanceState, fragTag);
            mCurrentFrag = fragmentManager.findFragmentByTag(fragTag)
        }

        if (mCurrentFrag == null) {
            mCurrentFrag = FragmentMain()
            fragTag = "fragment_main"
            fragmentManager
                    .beginTransaction()
                    .replace(R.id.fragment_place, mCurrentFrag, fragTag)
                    .addToBackStack(null)
                    .commit()
        }

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_main, menu)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        var returnVal = true
        var fr: Fragment? = null
        when (item.itemId) {
            R.id.action_main -> {
                fr = FragmentMain()
                fragTag = "fragment_main"
            }
            R.id.action_a -> {
                fr = FragmentA()
                fragTag = "fragment_a"
            }
            R.id.action_b -> {
                fr = FragmentB()
                fragTag = "fragment_b"
            }
            R.id.action_c -> {
                fr = FragmentC()
                fragTag = "fragment_c"
            }
            else -> returnVal = false
        }

        if (returnVal) {
            mCurrentFrag = fr
            val fm = fragmentManager
            val fragmentTransaction = fm.beginTransaction()
            fragmentTransaction
                    .replace(R.id.fragment_place, fr, fragTag)
                    .addToBackStack(null)
                    .commit()
            return returnVal
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.i(this.localClassName, " onSaveInstanceState.")
        outState.putString("frag_tag", fragTag)
        //        getFragmentManager().putFragment(outState, fragTag, mCurrentFrag);
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(this.localClassName, " onDestroy.")
    }
}

