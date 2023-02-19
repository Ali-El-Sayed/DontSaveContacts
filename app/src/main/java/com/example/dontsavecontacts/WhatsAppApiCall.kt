package com.example.dontsavecontacts

import android.content.Intent

interface WhatsAppApiCall {
    fun setContact(contactsViewModel: ContactViewModel):WhatsAppApiCall
    fun call():Intent
}