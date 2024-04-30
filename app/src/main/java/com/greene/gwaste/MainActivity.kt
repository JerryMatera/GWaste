package com.greene.gwaste

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.greene.gwaste.presentation.navigation.GWasteNavGraph
import com.greene.gwaste.presentation.ui.theme.GWasteTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GWasteTheme {
                GWasteNavGraph()
            }
        }
    }
}