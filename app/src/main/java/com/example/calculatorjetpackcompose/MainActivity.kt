package com.example.calculatorjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.calculatorjetpackcompose.ui.theme.CalculatorJetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalculatorJetpackComposeTheme {
                // A surface container using the 'background' color from the theme
                val viewModel = viewModel<CalculatorViewModel>()
                val state = viewModel.state
                val buttonSpacing = 8.dp

                Calculator(
                    state = state ,
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.LightGray),
                    buttonSpacing = buttonSpacing ,
                    onAction = viewModel::onAction
                )

            }
        }
    }
}

