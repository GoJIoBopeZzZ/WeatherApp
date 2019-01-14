package com.red.weatherapp.base

import android.os.Bundle
import android.support.annotation.CallSuper
import android.support.v4.app.Fragment

open class AbsFragment : Fragment(), FragmentTransactionAllowable, BackPressedListener {

    private lateinit var fragmentTransactionAllowable: FragmentTransactionAllowable

    @CallSuper
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        fragmentTransactionAllowable = activity as FragmentTransactionAllowable
    }

    override fun isTransactionAllowed(): Boolean = isAdded && fragmentTransactionAllowable.isTransactionAllowed()

    override fun onBackPressed() {
        activity?.apply {
            if (this is AbsActivity) {
                backPressed()
            } else {
                onBackPressed()
            }
        }
    }
}