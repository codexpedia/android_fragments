package com.example.fragments

import android.app.Fragment
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


class FragmentA : Fragment() {

    override fun onAttach(context: Context) {
        // This is called once the fragment is associated with its activity.
        super.onAttach(context)
        Log.i(TAG, " onAttach()")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        // This is called after the onAttach(), doing the initial creation of the fragment.
        super.onCreate(savedInstanceState)
        Log.i(TAG, " onCreate()")
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup, savedInstanceState: Bundle?): View? {
        //This is called after the onCreate(), this is where you will initialize all the views in this fragment.
        Log.i(TAG, " onCreateView()")
        return inflater.inflate(R.layout.fragment_a, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        //This is called after onCreateView(), this is where you can access the resource from the activity of this fragment.
        super.onActivityCreated(savedInstanceState)
        Log.i(TAG, " onActivityCreated()")
    }

    override fun onStart() {
        //This is called after onActivityCreated(), it makes the fragment visible to the user (based on its containing activity being started).
        super.onStart()
        Log.i(TAG, " onStart()")
    }

    override fun onResume() {
        //This is called after onStart()
        super.onResume()
        Log.i(TAG, " onResume()")
    }

    override fun onPause() {
        //This is called when the fragment is being moved out from the screen
        super.onPause()
        Log.i(TAG, " onPause()")
    }

    override fun onStop() {
        //This is called when the fragment is no longer visible to the user either because its activity is being stopped or a fragment operation is modifying it in the activity.
        super.onStop()
        Log.i(TAG, " onStop.")
    }

    override fun onDestroyView() {
        //This is where you will clean up resources of this fragment, background thread, handlers, etc.
        super.onDestroyView()
        Log.i(TAG, " onDestroyView.")
        onDestroy()

    }

    override fun onDestroy() {
        //This is called to do final cleanup of the fragment's state.
        super.onDestroy()
        Log.i(TAG, " onDestroy.")
    }

    override fun onDetach() {
        //This is called immediately prior to the fragment no longer being associated with its activity.
        super.onDetach()
        Log.i(TAG, " onDetach()")
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        //This is called after onActivityCreated(), this is where you will retrieve the data that's stored from the onSaveInstanceState
        super.onViewStateRestored(savedInstanceState)
        val greeting = if (savedInstanceState != null) savedInstanceState.getString("greeting") else "null"
        Log.i(TAG, " onViewStateRestored: " + greeting!!)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        //This is called after onPause(), this is where you will store the data that you want to keep when the uer come back to this fragment
        super.onSaveInstanceState(outState)
        Log.i(TAG, " onSaveInstanceState.")
        outState.putString("greeting", "Hello")
    }

    companion object {
        private val TAG = "FragmentA"
    }
}
