package com.dicoding.picodiploma.loginwithanimation.view.setting

import android.os.Bundle
import android.widget.CompoundButton
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.lifecycle.ViewModelProvider
import com.dicoding.picodiploma.loginwithanimation.R
import com.dicoding.picodiploma.loginwithanimation.databinding.ActivitySettingBinding
import com.dicoding.picodiploma.loginwithanimation.view.ViewModelFactory
import com.google.android.material.switchmaterial.SwitchMaterial

class SettingActivity : AppCompatActivity() {
//
//    private lateinit var binding : ActivitySettingBinding
//    private val viewModel : SettingViewModel by viewModels<SettingViewModel>()
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_setting)
//
//        supportActionBar?.title = "Settings"
//
//        val switchTheme = findViewById<SwitchMaterial>(R.id.switch_theme)
//
//        val pref = SettingPreferences.getInstance(application.dataStore)
//        val settingViewModel = ViewModelProvider(this, ViewModelFactory(repository, application, pref)).get(
//            SettingViewModel::class.java
//        )
//        settingViewModel.getThemeSettings().observe(this) { isDarkModeActive: Boolean ->
//            if (isDarkModeActive) {
//                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
//                switchTheme.isChecked = true
//            } else {
//                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
//                switchTheme.isChecked = false
//            }
//        }
//
//        switchTheme.setOnCheckedChangeListener { _: CompoundButton?, isChecked: Boolean ->
//            settingViewModel.saveThemeSetting(isChecked)
//        }
//    }


}