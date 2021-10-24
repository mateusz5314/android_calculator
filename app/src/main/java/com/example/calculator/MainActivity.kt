package com.example.calculator

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import kotlin.system.exitProcess


class MainActivity : FragmentActivity() {

    enum class CurrScreen
    {
        MENU,
        SIMPLE,
        ADVANCED,
        ABOUT
    }
    private val mManager: FragmentManager  = supportFragmentManager
    private val mExpressionControl: ExpressionControl = ExpressionControl()
    private val mViewControl: ViewControl = ViewControl()
    private val mFragmentSimple: FragmentSimple = FragmentSimple()
    private val mFragmentAdvanced: FragmentAdvanced = FragmentAdvanced()
    private var mCurrentScreen: CurrScreen = CurrScreen.MENU

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val transaction: FragmentTransaction = mManager.beginTransaction()
        transaction.replace(R.id.fragmentContainer, FragmentMenu(), null)
        transaction.commit()

        mExpressionControl.setContext(applicationContext)
        mExpressionControl.setViewControl(mViewControl)
    }

    override fun onSaveInstanceState(savedInstanceState: Bundle) {
        super.onSaveInstanceState(savedInstanceState)
        // Save state to the savedInstanceState
        savedInstanceState.putSerializable("CurrentScreen", mCurrentScreen)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        // Restore state from savedInstanceState
        val currScreen = savedInstanceState.get("CurrentScreen")
        when (currScreen) {
            CurrScreen.MENU     -> buttonBack(this.findViewById(R.id.fragmentContainer))
            CurrScreen.SIMPLE   -> buttonSimple(this.findViewById(R.id.fragmentContainer))
            CurrScreen.ADVANCED -> buttonAdvanced(this.findViewById(R.id.fragmentContainer))
            CurrScreen.ABOUT    -> buttonAbout(this.findViewById(R.id.fragmentContainer))
        }
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
        mCurrentScreen = CurrScreen.SIMPLE
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
        mCurrentScreen = CurrScreen.ADVANCED
    }

    fun buttonAbout(view: View){
        val msg = "About"
        val toast = Toast.makeText(applicationContext, msg, msg.length)
        toast.show()

        val transaction: FragmentTransaction = mManager.beginTransaction()
        transaction.replace(R.id.fragmentContainer, FragmentAbout(), null)
        transaction.commit()
        mCurrentScreen = CurrScreen.ABOUT
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

        mExpressionControl.clearAll()
        mCurrentScreen = CurrScreen.MENU
    }

    fun onNumberClick(view: View)
    {
        when (view.id) {
            R.id._0 -> mExpressionControl.newDigit(0)
            R.id._1 -> mExpressionControl.newDigit(1)
            R.id._2 -> mExpressionControl.newDigit(2)
            R.id._3 -> mExpressionControl.newDigit(3)
            R.id._4 -> mExpressionControl.newDigit(4)
            R.id._5 -> mExpressionControl.newDigit(5)
            R.id._6 -> mExpressionControl.newDigit(6)
            R.id._7 -> mExpressionControl.newDigit(7)
            R.id._8 -> mExpressionControl.newDigit(8)
            R.id._9 -> mExpressionControl.newDigit(9)
        }
    }

    fun onAdvancedSignClick(view: View)
    {
        when (view.id) {
            R.id.sin     -> mExpressionControl.sin()
            R.id.cos     -> mExpressionControl.cos()
            R.id.tan     -> mExpressionControl.tan()
            R.id.ln      -> mExpressionControl.ln()
            R.id.log     -> mExpressionControl.log()
            R.id.percent -> mExpressionControl.percent()
            R.id.sqrt    -> mExpressionControl.sqrt()
            R.id.square  -> mExpressionControl.square()
            R.id.toPowOf -> mExpressionControl.toPowOf()
        }
    }

    fun onSignClick(view: View)
    {
        when (view.id) {
            R.id.divide       -> mExpressionControl.divide()
            R.id.multiply     -> mExpressionControl.multiply()
            R.id.subtract     -> mExpressionControl.subtract()
            R.id.add          -> mExpressionControl.add()
            R.id._coma        -> mExpressionControl._coma()
            R.id.equal        -> mExpressionControl.equal()
            R.id.bracketLeft  -> mExpressionControl.bracketL()
            R.id.bracketRight -> mExpressionControl.bracketR()
        }
    }

    fun onClearOneClick(view: View)
    {
        when (view.id) {
            R.id.cce -> mExpressionControl.clearOne()
        }
    }

    fun onClearAllClick(): Boolean
    {
        mExpressionControl.clearAll()
        return true
    }
}
