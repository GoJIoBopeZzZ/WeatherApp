package com.red.weatherapp.base

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity

abstract class AbsActivity: AppCompatActivity(), FragmentTransactionAllowable {

    private var isFragmentTransactionsAllowed: Boolean = false

    override fun isTransactionAllowed(): Boolean = isFragmentTransactionsAllowed

    override fun onResumeFragments() {
        isFragmentTransactionsAllowed = true

        super.onResumeFragments()
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        isFragmentTransactionsAllowed = false

        super.onSaveInstanceState(outState)
    }

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)

        isFragmentTransactionsAllowed = true
    }

    override fun onBackPressed() {
        var currentFragment = getActiveFragment()

        if (currentFragment == null) {
            currentFragment = getExistingFragment()
        }

        if (currentFragment != null && currentFragment is BackPressedListener) {
            (currentFragment as BackPressedListener).onBackPressed()
        } else {
            backPressed()
        }
    }

    private fun getActiveFragment(): Fragment? = supportFragmentManager?.let {fm ->
        if (fm.backStackEntryCount == 0) {
            return@let null
        }

        return@let fm.getBackStackEntryAt(fm.backStackEntryCount - 1).name?.let {
            fm.findFragmentByTag(it)
        }
    }

    private fun getExistingFragment(): AbsFragment? = supportFragmentManager?.fragments?.firstOrNull { it is AbsFragment } as? AbsFragment

    fun backPressed() {
        super.onBackPressed()
    }
}