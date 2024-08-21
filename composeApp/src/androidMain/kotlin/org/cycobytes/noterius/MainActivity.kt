package org.cycobytes.noterius

import App
import AppPersistence
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import database.AndroidDatabaseBuilder

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            val context = LocalContext.current
            val database = remember {
                AppPersistence(AndroidDatabaseBuilder(context))
            }

            App(database)
        }
    }
}