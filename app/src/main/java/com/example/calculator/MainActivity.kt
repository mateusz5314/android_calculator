package com.example.calculator

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction


class MainActivity : FragmentActivity() {

    private val mManager: FragmentManager  = supportFragmentManager
    private val mMenuFragment: Fragment = FragmentMenu()
    private val mSimpleFragment: Fragment = FragmentSimple()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val transaction: FragmentTransaction = mManager.beginTransaction()
        transaction.replace(R.id.fragmentContainer, FragmentMenu(), null)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    fun buttonSimple(view: View){
        val msg = "Simple"
        val toast = Toast.makeText(applicationContext, msg, msg.length)
        toast.show()

        val transaction: FragmentTransaction = mManager.beginTransaction()
        transaction.replace(R.id.fragmentContainer, mSimpleFragment, null)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    fun buttonAdvanced(view: View){
        val msg = "Advanced"
        val toast = Toast.makeText(applicationContext, msg, msg.length)
        toast.show()
    }

    fun buttonAbout(view: View){
        val msg = "About"
        val toast = Toast.makeText(applicationContext, msg, msg.length)
        toast.show()
    }

    fun buttonExit(view: View){
        val msg = "Exit"
        val toast = Toast.makeText(applicationContext, msg, msg.length)
        toast.show()
    }

    fun buttonBack(view: View){
        val msg = "Back"
        val toast = Toast.makeText(applicationContext, msg, msg.length)
        toast.show()

        val transaction: FragmentTransaction = mManager.beginTransaction()
        transaction.replace(R.id.fragmentContainer, mMenuFragment, null)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}