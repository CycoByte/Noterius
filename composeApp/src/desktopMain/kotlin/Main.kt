

import androidx.compose.runtime.remember
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import database.DesktopDatabaseBuilder

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "Noterius",
    ) {

        val database = remember {
            AppPersistence(DesktopDatabaseBuilder())
        }

        App(database)
    }
}