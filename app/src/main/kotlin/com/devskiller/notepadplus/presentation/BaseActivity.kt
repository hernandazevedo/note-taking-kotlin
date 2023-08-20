package com.devskiller.notepadplus.presentation

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

abstract class BaseActivity : AppCompatActivity() {
    /**
     * Method created to add fragments to layout containers
     */
    protected fun replaceFragment(
        containerViewId: Int,
        fragment: Fragment,
        fragmentTag: String,
    ) {
        supportFragmentManager
            .beginTransaction()
            .replace(containerViewId, fragment, fragmentTag)
            .addToBackStack(null)
            .commit()
    }
}