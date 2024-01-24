package com.example.buttonstest.ui.mainScreen.compose

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
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
import com.example.buttonstest.ui.dataScreen.DataActivity
import com.example.buttonstest.ui.mainScreen.MainViewModel
import com.example.buttonstest.ui.mainScreen.ScreenState


@Composable
fun MainScreen(viewModel: MainViewModel) {

    val state by viewModel.uiState.collectAsState()
    val context = LocalContext.current


    when (val immutableState = state) {

        is ScreenState.Loading -> {
            LoadingScreen()
        }

        is ScreenState.Success -> {
            SuccessScreen(
                state = immutableState,
                onSuccessClick = { viewModel.loadInfo() },
                onErrorClick = { viewModel.sendInfo() },
                onNextClick = {
                    viewModel.randomData()
                    context.startDataActivity()
                },
            )
        }

        is ScreenState.Initial -> {
            InitialScreen(
                state = immutableState,
                onSuccessClick = { viewModel.loadInfo() },
                onErrorClick = { viewModel.sendInfo() },
                onNextClick = {
                    viewModel.randomData()
                    context.startDataActivity()
                },
            )
        }

        is ScreenState.Error -> {
            ErrorScreen(
                state = immutableState,
                onSuccessClick = { viewModel.loadInfo() },
                onErrorClick = { viewModel.sendInfo() },
                onNextClick = {
                    viewModel.randomData()
                    context.startDataActivity()
                },
            )
        }
    }
}

@Composable
private fun ErrorScreen(
    state: ScreenState.Error,
    onSuccessClick: () -> Unit,
    onErrorClick: () -> Unit,
    onNextClick: () -> Unit,
) {
    Column(
        modifier = Modifier
            .background(color = Color.Black),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween,
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .background(color = Color.Red)
                .fillMaxWidth()
        ) {

            Text(
                text = state.text,
                modifier = Modifier
                    .padding(vertical = 50.dp),
                fontSize = 44.sp
            )
        }
        ButtonComponent(
            onSuccessClick = onSuccessClick,
            onErrorClick = onErrorClick,
            onNextClick = onNextClick,
        )
    }
}

@Composable
private fun InitialScreen(
    state: ScreenState.Initial,
    onSuccessClick: () -> Unit,
    onErrorClick: () -> Unit,
    onNextClick: () -> Unit,
) {
    Column(
        modifier = Modifier
            .background(color = Color.Black),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween,
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .background(color = Color.White)
                .fillMaxWidth()
        ) {

            Text(
                text = state.text,
                modifier = Modifier
                    .padding(vertical = 50.dp),
                fontSize = 44.sp
                )
        }
        ButtonComponent(
            onSuccessClick = onSuccessClick,
            onErrorClick = onErrorClick,
            onNextClick = onNextClick,
        )
    }
}

@Composable
private fun SuccessScreen(
    state: ScreenState.Success,
    onSuccessClick: () -> Unit,
    onErrorClick: () -> Unit,
    onNextClick: () -> Unit,
) {
    Column(
        modifier = Modifier
            .background(color = Color.Black),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween,
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .background(color = Color.Green)
                .fillMaxWidth()
        ) {

            Text(
                text = state.text,
                modifier = Modifier
                    .padding(vertical = 50.dp),
                fontSize = 44.sp
                )
        }
        ButtonComponent(
            onSuccessClick = onSuccessClick,
            onErrorClick = onErrorClick,
            onNextClick = onNextClick,
        )
    }
}

@Composable
private fun LoadingScreen() {
    CircularProgressIndicator(
        modifier = Modifier.padding(100.dp, 200.dp),
        color = Color.Red
    )
}

private fun Context.startDataActivity() {
    startActivity(DataActivity.newIntent(this))
}

@Composable
private fun ButtonComponent(
    onSuccessClick: () -> Unit,
    onErrorClick: () -> Unit,
    onNextClick: () -> Unit,
) {
    Column(
        modifier = Modifier
            .padding(horizontal = 10.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom
    ) {
        ButtonText(name = "Успех", onSuccessClick)
        ButtonText(name = "Ошибка", onErrorClick)
        ButtonText(name = "Следующий", onNextClick)
    }
}

@Composable
private fun ButtonText(
    name: String,
    onClick: () -> Unit,
) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .padding(vertical = 20.dp)
            .fillMaxWidth(),
    ) {
        Text(
            text = name,
            modifier = Modifier
                .padding(all = 10.dp),
            fontSize = 22.sp
        )
    }
}
