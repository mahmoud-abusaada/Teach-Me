package com.abusada.teachme.presentation.extensions

import android.os.Looper
import android.view.View
import androidx.annotation.CheckResult
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.SendChannel
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.conflate

internal fun checkMainThread() {
    check(Looper.myLooper() == Looper.getMainLooper()) {
        "Expected to be called on the main thread but was " + Thread.currentThread().name
    }
}

@CheckResult
@OptIn(ExperimentalCoroutinesApi::class)
fun View.clicks(): Flow<Unit> = callbackFlow {

    checkMainThread()

    val listener = View.OnClickListener {
        safeOffer(Unit)
    }

    setOnClickListener(listener)

    awaitClose { setOnClickListener(null) }

}.conflate()

fun <E> SendChannel<E>.safeOffer(value: E) = !isClosedForSend && try {
    offer(value)
} catch (e: CancellationException) {
    false
}