package com.example.buttonstest.presentation.ui.dataScreen.compose

import androidx.activity.ComponentActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import com.example.buttonstest.presentation.ui.dataScreen.DataScreenState
import com.example.buttonstest.presentation.ui.dataScreen.DataViewModel

@Composable
fun DataScreen(viewModel:DataViewModel) {
    val state by viewModel.uiState.collectAsState()
    val activity = LocalContext.current as? ComponentActivity

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
                        text = immutable.data.value.toString(),
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
                            activity?.onBackPressed()
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