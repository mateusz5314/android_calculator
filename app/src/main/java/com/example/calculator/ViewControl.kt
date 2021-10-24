package com.example.calculator

import android.util.Log
import android.widget.TextView
import androidx.fragment.app.Fragment
import javax.security.auth.callback.Callback

class ViewControl {
    enum class WorkingMode {
        SIMPLE,
        ADVANCED,
        ABOUT
    }
    private var mCurrentText: String = ""
    private lateinit var mFragmentSimple: FragmentSimple
    private lateinit var mFragmentAdvanced: FragmentAdvanced
    private var mWorkingMode: WorkingMode = WorkingMode.SIMPLE

    fun setFragment(fragment: FragmentSimple)
    {
        mFragmentSimple = fragment
        mWorkingMode = WorkingMode.SIMPLE
    }

    fun setFragment(fragment: FragmentAdvanced)
    {
        mFragmentAdvanced = fragment
        mWorkingMode = WorkingMode.ADVANCED
    }

    fun removeFragment()
    {
        mWorkingMode = WorkingMode.ABOUT
    }

    fun clearChar()
    {
        mCurrentText = mCurrentText.dropLast(1)
        updateFragmentView(mCurrentText)
    }

    fun clearText()
    {
        updateFragmentView("0")
        mCurrentText = ""
    }

    fun addText(text : String)
    {
        val newText = mCurrentText + text
        updateFragmentView(newText)
        mCurrentText = newText
    }

    private fun updateFragmentView(text: String)
    {
        when (mWorkingMode) {
            WorkingMode.ADVANCED -> mFragmentAdvanced.updateCurrentEntry(text)
            WorkingMode.SIMPLE   -> mFragmentSimple.updateCurrentEntry(text)
            else -> {}//  nothing to do
        }
    }
}