package com.example.buttonstest.ui.dataScreen

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.buttonstest.ui.mainScreen.MainActivity

class DataActivity : ComponentActivity() {

    private val viewModel = DataViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DataScreen()
        }
    }

    @Composable
    fun DataScreen() {

        val state by viewModel.uiState.collectAsState()

        viewModel.randomData()

        when (val immutable = state) {

            is DataScreenState.Data -> {
                Text(
                    text = immutable.data.toString(),
                    modifier = Modifier
                        .padding(horizontal = 160.dp, vertical = 50.dp)
                        .size(200.dp),
                )
                Button(
                    onClick = {
                        this@DataActivity.onBackPressed()
                    },
                    modifier = Modifier
                        .padding(horizontal = 160.dp, vertical = 250.dp),
                ) {
                    Text(
                        text = "Назад",
                        modifier = Modifier
                            .padding(all = 10.dp),
                    )
                }
            }
        }
    }

    private fun startMainActivity() {
        val intent = Intent(this@DataActivity, MainActivity::class.java)
        startActivity(intent)
    }

    companion object {
        fun newIntent(contex: Context): Intent =
            Intent(contex, DataActivity::class.java)

    }
}