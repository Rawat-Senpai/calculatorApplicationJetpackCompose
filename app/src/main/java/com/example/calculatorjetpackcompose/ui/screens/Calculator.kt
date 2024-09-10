package com.example.calculatorjetpackcompose.ui.screens

import AutoResizingText
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.calculatorjetpackcompose.CalculatorAction
import com.example.calculatorjetpackcompose.widgets.CalculatorButton
import com.example.calculatorjetpackcompose.CalculatorOperation
import com.example.calculatorjetpackcompose.CalculatorState
import com.example.calculatorjetpackcompose.ui.theme.Orange


@Composable
fun Calculator(
    state: CalculatorState,
    modifier: Modifier = Modifier,
    buttonSpacing: Dp = 8.dp,
    onAction: (CalculatorAction) -> Unit
) {

    Box(modifier = Modifier
        .fillMaxSize()
        .background(
            Brush.verticalGradient(
                colors = listOf(Color(0xFF1E1E1E), Color(0xFF121212))
            )
        )) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter),
            verticalArrangement = Arrangement.spacedBy(buttonSpacing)
        ) {
            AutoResizingText(
                text = state.number1 + (state.operation?.symbol ?: "") + state.number2,
                modifier = Modifier
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                CalculatorButton(symbol = "AC", modifier = Modifier
                    .background(Color.LightGray)
                    .aspectRatio(2f)
                    .weight(2f),
                    onClick = {
                        onAction(CalculatorAction.Clear)
                    }
                )

                CalculatorButton(symbol = "Del", modifier = Modifier
                    .background(Color.LightGray)
                    .aspectRatio(1f)
                    .weight(1f),
                    onClick = {
                        onAction(CalculatorAction.Delete)
                    }
                )

                CalculatorButton(symbol = "/", modifier = Modifier
                    .background(Orange)
                    .aspectRatio(1f)
                    .weight(1f),
                    onClick = {
                        onAction(CalculatorAction.Operation(CalculatorOperation.Divide))
                    }
                )

            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                CalculatorButton(symbol = "7", modifier = Modifier
                    .background(Color.DarkGray)
                    .aspectRatio(1f)
                    .weight(1f),
                    onClick = {
                        onAction(CalculatorAction.Number(7))
                    }

                )


                CalculatorButton(symbol = "8", modifier = Modifier
                    .background(Color.DarkGray)
                    .aspectRatio(1f)
                    .weight(1f),
                    onClick = {
                        onAction(CalculatorAction.Number(8))
                    }

                )


                CalculatorButton(symbol = "9", modifier = Modifier
                    .background(Color.DarkGray)
                    .aspectRatio(1f)
                    .weight(1f),
                    onClick = {
                        onAction(CalculatorAction.Number(9))
                    }

                )


                CalculatorButton(symbol = "x", modifier = Modifier
                    .background(Orange)
                    .aspectRatio(1f)
                    .weight(1f),
                    onClick = {
                        onAction(CalculatorAction.Operation(CalculatorOperation.Multiply))
                    }

                )


            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                CalculatorButton(symbol = "4", modifier = Modifier
                    .background(Color.DarkGray)
                    .aspectRatio(1f)
                    .weight(1f),
                    onClick = {
                        onAction(CalculatorAction.Number(4))
                    }

                )


                CalculatorButton(symbol = "5", modifier = Modifier
                    .background(Color.DarkGray)
                    .aspectRatio(1f)
                    .weight(1f),
                    onClick = {
                        onAction(CalculatorAction.Number(5))
                    }

                )


                CalculatorButton(symbol = "6", modifier = Modifier
                    .background(Color.DarkGray)
                    .aspectRatio(1f)
                    .weight(1f),
                    onClick = {
                        onAction(CalculatorAction.Number(6))
                    }

                )


                CalculatorButton(symbol = "-", modifier = Modifier
                    .background(Orange)
                    .aspectRatio(1f)
                    .weight(1f),
                    onClick = {
                        onAction(CalculatorAction.Operation(CalculatorOperation.Subtract))
                    }

                )


            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                CalculatorButton(symbol = "3", modifier = Modifier
                    .background(Color.DarkGray)
                    .aspectRatio(1f)
                    .weight(1f),
                    onClick = {
                        onAction(CalculatorAction.Number(3))
                    }
                )


                CalculatorButton(symbol = "2", modifier = Modifier
                    .background(Color.DarkGray)
                    .aspectRatio(1f)
                    .weight(1f),
                    onClick = {
                        onAction(CalculatorAction.Number(2))
                    }
                )


                CalculatorButton(symbol = "1", modifier = Modifier
                    .background(Color.DarkGray)
                    .aspectRatio(1f)
                    .weight(1f),
                    onClick = {
                        onAction(CalculatorAction.Number(1))
                    }
                )


                CalculatorButton(symbol = "+", modifier = Modifier
                    .background(Orange)
                    .aspectRatio(1f)
                    .weight(1f),
                    onClick = {
                        onAction(CalculatorAction.Operation(CalculatorOperation.Add))
                    }
                )


            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                CalculatorButton(symbol = "0", modifier = Modifier
                    .background(Color.DarkGray)
                    .aspectRatio(2f)
                    .weight(2f),
                    onClick = {
                        onAction(CalculatorAction.Number(0))
                    }

                )


                CalculatorButton(symbol = ".", modifier = Modifier
                    .background(Color.DarkGray)
                    .aspectRatio(1f)
                    .weight(1f),
                    onClick = {
                        onAction(CalculatorAction.Decimal)
                    }

                )


                CalculatorButton(symbol = "=", modifier = Modifier
                    .background(Orange )
                    .aspectRatio(1f)
                    .weight(1f),
                    onClick = {
                        onAction(CalculatorAction.Calculate)
                    }

                )

 
                
            }

        }

    }

}

