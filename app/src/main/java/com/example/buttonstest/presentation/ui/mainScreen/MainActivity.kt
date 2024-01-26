package com.example.buttonstest.presentation.ui.mainScreen

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.buttonstest.presentation.ui.mainScreen.compose.MainScreen
import com.example.buttonstest.presentation.ui.theme.ButtonsTestTheme

class MainActivity : ComponentActivity() {

    private val viewModel = MainViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e("!!!", "MainActivity onCreate")
        setContent {
            ButtonsTestTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen(viewModel)
                }
            }
        }
    }

    override fun onStart() {
        super.onStart()
        Log.e("!!!", "MainActivity onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.e("!!!", "MainActivity onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.e("!!!", "MainActivity onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.e("!!!", "MainActivity onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("!!!", "MainActivity onDestroy")
    }
}
