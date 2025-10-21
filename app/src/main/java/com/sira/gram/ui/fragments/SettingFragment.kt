package com.sira.gram.ui.fragments

import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat
import com.sira.gram.R

class SettingFragment : PreferenceFragmentCompat() {

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.preferences, rootKey)
    }
}