package com.example.buttonstest.presentation.ui.dataScreen

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.buttonstest.presentation.ui.dataScreen.compose.DataScreen
import com.example.buttonstest.presentation.ui.mainScreen.MainActivity

class DataActivity : ComponentActivity() {

    private val viewModel = DataViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e("!!!", "DataActivity onCreate")
        setContent {
            DataScreen(viewModel)
        }
    }

    override fun onStart() {
        super.onStart()
        Log.e("!!!", "DataActivity onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.e("!!!", "DataActivity onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.e("!!!", "DataActivity onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.e("!!!", "DataActivity onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("!!!", "DataActivity onDestroy")
    }

    companion object {
        fun newIntent(contex: Context): Intent =
            Intent(contex, DataActivity::class.java)
    }
}