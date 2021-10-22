package com.example.calculator

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import kotlin.system.exitProcess


class MainActivity : FragmentActivity() {

    private val mManager: FragmentManager  = supportFragmentManager
    private val mNumbersControl: NumbersControl = NumbersControl()
    private val mViewControl: ViewControl = ViewControl()
    private val mFragmentSimple: FragmentSimple = FragmentSimple()
    private val mFragmentAdvanced: FragmentAdvanced = FragmentAdvanced()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val transaction: FragmentTransaction = mManager.beginTransaction()
        transaction.replace(R.id.fragmentContainer, FragmentMenu(), null)
        transaction.commit()

        mNumbersControl.setContext(applicationContext)
        mNumbersControl.setViewControl(mViewControl)
    }

    fun buttonSimple(view: View){
        val msg = "Simple"
        val toast = Toast.makeText(applicationContext, msg, msg.length)
        toast.show()

        val transaction: FragmentTransaction = mManager.beginTransaction()
        transaction.replace(R.id.fragmentContainer, mFragmentSimple, null)
        transaction.add(R.id.simpleKeysContainer_S, FragmentSimpleKeys(), null)
        transaction.commit()

        mViewControl.setFragment(mFragmentSimple)
    }

    fun buttonAdvanced(view: View){
        val msg = "Advanced"
        val toast = Toast.makeText(applicationContext, msg, msg.length)
        toast.show()

        val transaction: FragmentTransaction = mManager.beginTransaction()
        transaction.replace(R.id.fragmentContainer, mFragmentAdvanced, null)
        transaction.add(R.id.advancedKeysContainer, FragmentAdvancedKeys(), null)
        transaction.add(R.id.simpleKeysContainer_A, FragmentSimpleKeys(), null)
        transaction.commit()

        mViewControl.setFragment(mFragmentAdvanced)
    }

    fun buttonAbout(view: View){
        val msg = "About"
        val toast = Toast.makeText(applicationContext, msg, msg.length)
        toast.show()

        val transaction: FragmentTransaction = mManager.beginTransaction()
        transaction.replace(R.id.fragmentContainer, FragmentAbout(), null)
        transaction.commit()
    }

    fun buttonExit(view: View){
        val msg = "Exit"
        val toast = Toast.makeText(applicationContext, msg, msg.length)
        toast.show()

        finish()
        exitProcess(0)
    }

    fun buttonBack(view: View){
        val msg = "Back"
        val toast = Toast.makeText(applicationContext, msg, msg.length)
        toast.show()

        val transaction: FragmentTransaction = mManager.beginTransaction()
        transaction.replace(R.id.fragmentContainer, FragmentMenu(), null)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    fun onNumberClick(view: View)
    {
        when (view.id) {
            R.id._0 -> mNumbersControl.newDigit(0)
            R.id._1 -> mNumbersControl.newDigit(1)
            R.id._2 -> mNumbersControl.newDigit(2)
            R.id._3 -> mNumbersControl.newDigit(3)
            R.id._4 -> mNumbersControl.newDigit(4)
            R.id._5 -> mNumbersControl.newDigit(5)
            R.id._6 -> mNumbersControl.newDigit(6)
            R.id._7 -> mNumbersControl.newDigit(7)
            R.id._8 -> mNumbersControl.newDigit(8)
            R.id._9 -> mNumbersControl.newDigit(9)
        }
    }

    fun onAdvancedSignClick(view: View)
    {
        when (view.id) {
            R.id.sin     -> mNumbersControl.sin()
            R.id.cos     -> mNumbersControl.cos()
            R.id.tan     -> mNumbersControl.tan()
            R.id.ln      -> mNumbersControl.ln()
            R.id.log     -> mNumbersControl.log()
            R.id.percent -> mNumbersControl.percent()
            R.id.sqrt    -> mNumbersControl.sqrt()
            R.id.square  -> mNumbersControl.square()
            R.id.toPowOf -> mNumbersControl.toPowOf()
        }
    }

    fun onSignClick(view: View)
    {
        when (view.id) {
            R.id.divide   -> mNumbersControl.divide()
            R.id.multiply -> mNumbersControl.multiply()
            R.id.subtract -> mNumbersControl.subtract()
            R.id.add      -> mNumbersControl.add()
            R.id._coma    -> mNumbersControl._coma()
            R.id.equal    -> mNumbersControl.equal()
        }
    }

    fun onClearOneClick(view: View)
    {
        when (view.id) {
            R.id.cce -> mNumbersControl.clearOne()
        }
    }

    fun onClearAllClick(): Boolean
    {
        mNumbersControl.clearAll()
        return true
    }
}
