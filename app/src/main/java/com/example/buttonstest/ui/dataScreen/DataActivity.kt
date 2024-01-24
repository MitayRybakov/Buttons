package com.example.buttonstest.ui.dataScreen

import android.content.Context
import android.content.Intent
import android.os.Bundle
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

                Column(
                    modifier = Modifier.background(color = Color.Black),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceBetween,
                ) {
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(color = Color.White)
                            .weight(2f),
                    ) {
                        Text(
                            text = immutable.data.toString(),
                            fontSize = 44.sp
                        )
                    }
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f),
                    ) {
                        Button(
                            modifier = Modifier
                                .fillMaxWidth(),
                            onClick = {
                                this@DataActivity.onBackPressed()
                            }
                        ) {
                            Text(
                                text = "Назад",
                                modifier = Modifier
                                    .padding(all = 10.dp),
                                fontSize = 22.sp
                            )
                        }
                    }
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