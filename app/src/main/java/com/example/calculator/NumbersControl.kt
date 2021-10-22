package com.example.calculator

import android.content.Context
import android.util.Log
import android.widget.Toast

class NumbersControl {
    private val MAX_DIGITS = 20
    private lateinit var mContext: Context
    private lateinit var mViewControl: ViewControl

    private var mCurrentNumber: String = ""

    fun setContext(context: Context)
    {
        mContext = context
    }

    fun setViewControl(viewControl: ViewControl) {
        mViewControl = viewControl
    }

    fun newDigit(value: Int)
    {
        if (mCurrentNumber.length < MAX_DIGITS)
        {
            mViewControl.addText(value.toString())
            mCurrentNumber += value.toString()
        }
    }

    fun clearOne()
    {
        mViewControl.clearChar()
    }

    fun clearAll()
    {
        mViewControl.clearText()
    }

    fun sin()
    {

    }

    fun cos()
    {

    }

    fun tan()
    {

    }

    fun ln()
    {

    }

    fun log()
    {

    }

    fun percent()
    {

    }

    fun sqrt()
    {

    }

    fun square()
    {

    }

    fun toPowOf()
    {

    }

    fun divide()
    {

    }

    fun multiply()
    {

    }

    fun subtract()
    {

    }

    fun add()
    {

    }

    fun _coma()
    {

    }

    fun equal()
    {

    }
}