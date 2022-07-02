package com.example.projectthree

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class ProjectThreeApp : Application(){
    override fun onCreate() {
        super.onCreate()
    }
}