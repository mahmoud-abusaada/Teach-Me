package com.abusada.teachme.application.interceptors

import android.content.Context
import com.abusada.teachme.domain.extensions.isNetworkAvailable
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException

class NetworkConnectionInterceptor(private val mContext: Context) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        if (!isNetworkConnected()) {
            throw IOException("No Internet Connection")
        }
        val builder = chain.request().newBuilder();
        return chain.proceed(builder.build());
    }

    private fun isNetworkConnected(): Boolean {
        return mContext.isNetworkAvailable()
    }
}