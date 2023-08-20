package com.devskiller.notepadplus.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.devskiller.notepadplus.R

class WelcomeFragment : Fragment() {

    companion object {

        fun newInstance(): WelcomeFragment = WelcomeFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // START REFACTOR OF THIS METHOD
        return inflater.inflate(R.layout.fragment_welcome, container, false)
    }
}
