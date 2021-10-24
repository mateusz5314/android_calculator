package com.example.calculator

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView





// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
private var mCurrentText: String = ""

/**
 * A simple [Fragment] subclass.
 * Use the [FragmentSimple.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentSimple : Fragment() {
    private lateinit var mTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?)
    : View {
        val v: View = inflater.inflate(R.layout.fragment_simple, container, false)
        mTextView = v.findViewById<TextView>(R.id.currentEntry)
        mTextView.text = mCurrentText
        return v
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment fragmentSimple.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FragmentSimple().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    fun updateCurrentEntry(text: String)
    {
        try
        {
            mTextView.text = text
            mCurrentText = text
        }
        catch (e: Exception)
        {
        }
    }
}