package cl.bootcamp.shoestapsprint5

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import cl.bootcamp.shoestapsprint5.navigation.AppNavigation
import cl.bootcamp.shoestapsprint5.ui.theme.ShoesTapSprint5Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContent {
            ShoesTapSprint5Theme {
                AppNavigation()
            }
        }
    }
}
