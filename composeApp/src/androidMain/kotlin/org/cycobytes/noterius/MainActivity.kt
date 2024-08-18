package org.cycobytes.noterius

import App
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import database.getTestDatabase

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            val context = LocalContext.current
            val dao = remember {
                getTestDatabase(context).testDao()
            }

            App(dao)
        }
    }
}

//@Preview
//@Composable
//fun AppAndroidPreview() {
//
//    val context = LocalContext.current
//    val dao = remember {
//        getTestDatabase(context).testDao()
//    }
//
//    App(dao)
//}