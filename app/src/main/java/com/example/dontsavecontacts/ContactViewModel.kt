package com.example.dontsavecontacts

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

private const val TAG = "ContactViewModel"

class ContactViewModel : ViewModel() {
    private val _number = MutableLiveData(Contact("", ""))
    val number: LiveData<Contact>
        get() = _number

    fun getString() = "${_number.value?.countryCode}${_number.value?.phoneNumber}"

    fun onCountryCodeChanged(s: String) {
        _number.value?.countryCode = s
    }

    fun onPhoneNumberChanged(s: String) {
        _number.value?.phoneNumber = s
    }

}