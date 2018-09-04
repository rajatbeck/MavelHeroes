package com.android.marvelApp.utils.extensions

fun <T : Any> T?.whenNotNull(f: (it: T) -> Unit) {
    if (this != null) f(this)
}
