package com.example.dontsavecontacts

import android.content.Intent
import android.net.Uri
import android.util.Log


private const val TAG: String = "Api"

object Api : WhatsAppApiCall {
    private const val BASE_URL = "https://wa.me"
    private lateinit var url: String

    override fun setContact(contactsViewModel: ContactViewModel): WhatsAppApiCall {
        val number: String = contactsViewModel.getString()
        Log.d(TAG, "setContact: $number")
        url = Uri.parse(BASE_URL)
            .buildUpon()
            .appendPath(number)
            .toString()
        return this
    }

    override fun call(): Intent {
        Log.d(TAG, "call: $url")
        val intent = Intent(Intent.ACTION_VIEW).apply {
            data = Uri.parse(url)
        }
        return intent
    }

}
