package com.android.marvelApp.utils.extensions


import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity

inline fun FragmentManager.transact(func: FragmentTransaction.() -> Unit) {
    val transaction = beginTransaction()
    transaction.func()
    transaction.commit()
}


inline fun FragmentManager.transactStateless(func: FragmentTransaction.() -> Unit) {
    val transaction = beginTransaction()
    transaction.func()
    transaction.commitAllowingStateLoss()
}

inline fun FragmentTransaction.add(fragment: Fragment) {
    add(fragment, fragment.javaClass.simpleName)
}

inline fun FragmentTransaction.replace(resId: Int, fragment: Fragment) {
    replace(resId, fragment, fragment.javaClass.simpleName)
}


inline fun AppCompatActivity.transact(func: FragmentTransaction.() -> Unit) {
    supportFragmentManager.transact(func)
}

inline fun AppCompatActivity.transactStateless(func: FragmentTransaction.() -> Unit) {
    supportFragmentManager.transactStateless(func)
}

inline fun Fragment.transact(func: FragmentTransaction.() -> Unit) {
    fragmentManager?.transact(func)
}

inline fun Fragment.transactStateless(func: FragmentTransaction.() -> Unit) {
    fragmentManager?.transactStateless(func)
}



