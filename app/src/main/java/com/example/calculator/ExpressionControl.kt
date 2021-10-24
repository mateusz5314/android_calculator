package com.example.calculator

import android.content.Context
import android.widget.Toast
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception

class ExpressionControl {
    private val MAXLENGHT = 30
    private lateinit var mContext: Context
    private lateinit var mViewControl: ViewControl

    private var mCurrentExpression: String = ""

    fun setContext(context: Context)
    {
        mContext = context
    }

    fun refresh()
    {
        pushBack("")
    }

    fun setViewControl(viewControl: ViewControl) {
        mViewControl = viewControl
    }

    fun newDigit(value: Int)
    {
        if (mCurrentExpression.length < MAXLENGHT)
        {
            pushBack(value.toString())
        }
    }

    fun clearOne()
    {
        mViewControl.clearChar()
        mCurrentExpression = mCurrentExpression.dropLast(1)
    }

    fun clearAll()
    {
        mViewControl.clearText()
        mCurrentExpression = ""
    }

    fun bracketL()
    {
        pushBack("(")
    }

    fun bracketR()
    {
        pushBack(")")
    }

    fun sin()
    {
        pushBack("sin(")
    }

    fun cos()
    {
        pushBack("cos(")
    }

    fun tan()
    {
        pushBack("tan(")
    }

    fun ln()
    {
        pushBack("ln(")
    }

    fun log()
    {
        pushBack("log")
    }

    fun percent()
    {
        pushBack("%")
    }

    fun sqrt()
    {
        pushBack("sqrt(")
    }

    fun square()
    {
        pushBack("^2")
    }

    fun toPowOf()
    {
        pushBack("^")
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
        try {
            val e = ExpressionBuilder(mCurrentExpression).build()
            clearAll()
            mCurrentExpression = e.evaluate().toString()
            mViewControl.addText(mCurrentExpression)
        }
        catch (e: Exception)
        {
            val msg = "Incorrect operation"
            val toast = Toast.makeText(mContext, msg, msg.length)
            toast.show()
        }
    }

    private fun pushBack(value: String)
    {
        mCurrentExpression += value
        mViewControl.addText(value)
    }
}