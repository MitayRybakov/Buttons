package com.example.buttonstest.presentation.ui.mainScreen.compose

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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.buttonstest.R
import com.example.buttonstest.presentation.ui.dataScreen.DataActivity
import com.example.buttonstest.presentation.ui.mainScreen.MainViewModel
import com.example.buttonstest.presentation.ui.mainScreen.ScreenState

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
                onSuccessClick = { viewModel.setSuccessState() },
                onErrorClick = { viewModel.setErrorState() },
                onNextClick = {
                    viewModel.generateDigit()
                    context.startDataActivity()
                },
            )
        }

        is ScreenState.Initial -> {
            InitialScreen(
                state = immutableState,
                onSuccessClick = { viewModel.setSuccessState() },
                onErrorClick = { viewModel.setErrorState() },
                onNextClick = {
                    viewModel.generateDigit()
                    context.startDataActivity()
                },
            )
        }

        is ScreenState.Error -> {
            ErrorScreen(
                state = immutableState,
                onSuccessClick = { viewModel.setSuccessState() },
                onErrorClick = { viewModel.setErrorState() },
                onNextClick = {
                    viewModel.generateDigit()
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
        TextScreenComponent(text = state.text)

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
        TextScreenComponent(text = state.text)

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
        TextScreenComponent(text = state.text)

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
private  fun TextScreenComponent(text:String) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .background(color = Color.White)
            .fillMaxWidth()
    ) {
        Text(
            text = text,
            modifier = Modifier
                .padding(vertical = 50.dp),
            fontSize = 44.sp
        )
    }
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
        ButtonText(name = stringResource(id = R.string.button_success), onSuccessClick)
        ButtonText(name = stringResource(id = R.string.button_error), onErrorClick)
        ButtonText(name = stringResource(id = R.string.button_next), onNextClick)
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
