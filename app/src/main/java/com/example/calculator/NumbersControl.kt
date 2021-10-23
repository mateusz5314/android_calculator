package com.example.calculator

import android.content.Context
import android.util.Log
import android.widget.Toast
import net.objecthunter.exp4j.Expression
import net.objecthunter.exp4j.ExpressionBuilder

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
            pushBack(value.toString())
        }
    }

    fun clearOne()
    {
        mViewControl.clearChar()
        mCurrentNumber = mCurrentNumber.dropLast(1)
    }

    fun clearAll()
    {
        mViewControl.clearText()
        mCurrentNumber = ""
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
        pushBack("/")
    }

    fun multiply()
    {
        pushBack("*")
    }

    fun subtract()
    {
        pushBack("-")
    }

    fun add()
    {
        pushBack("+")
    }

    fun _coma()
    {
        pushBack(".")
    }

    fun equal()
    {
        val e = ExpressionBuilder(mCurrentNumber).build()
        clearAll()
        mCurrentNumber = e.evaluate().toString()
        mViewControl.addText(mCurrentNumber)
    }

    private fun pushBack(value: String)
    {
        mCurrentNumber += value
        mViewControl.addText(value)
    }
}