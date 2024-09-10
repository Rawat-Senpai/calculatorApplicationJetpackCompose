package com.example.calculatorjetpackcompose

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class CalculatorViewModel:ViewModel() {

    var state by mutableStateOf(CalculatorState())
        private set


    fun onAction(action: CalculatorAction){

        when(action){
            CalculatorAction.Calculate -> performCalculation()

            CalculatorAction.Clear -> state = CalculatorState()

            CalculatorAction.Decimal -> enterDecimal()

            CalculatorAction.Delete -> performDeletion()

            is CalculatorAction.Number ->  enterNumber(action.number)

            is CalculatorAction.Operation -> enterOperation(action.operation)
        }
    }


    private fun enterDecimal() {

            if(state.operation == null){

                // Handle decimal for number1
                if (state.number1.isBlank()) {
                    // If number1 is empty, start with "0."
                    state = state.copy(
                        number1 = "0."
                    )
                } else if (!state.number1.contains(".")) {
                    // If number1 already has digits, append "."
                    state = state.copy(
                        number1 = state.number1 + "."
                    )
                }
            }else{
                // Handle decimal for number2
                if (state.number2.isBlank()) {
                    // If number2 is empty, start with "0."
                    state = state.copy(
                        number2 = "0."
                    )
                } else if (!state.number2.contains(".")) {
                    // If number2 already has digits, append "."
                    state = state.copy(
                        number2 = state.number2 + "."
                    )
                }

            }




    }

    private fun enterOperation(operation: CalculatorOperation) {

        if(state.number1.isNotBlank()){
            state = state.copy(operation = operation)
        }

    }

    private fun performDeletion() {

        when{
            state.number2.isNotBlank() -> state = state.copy(
                number2 = state.number2.dropLast(1)
            )

            state.operation != null -> state = state.copy(
                operation = null
            )

            state.number1.isNotBlank() -> state = state.copy(
                number1 =  state.number1.dropLast(1)
            )

        }

    }

    private fun enterNumber(number: Int) {

        if(state.operation == null){
            if(state.number1.length>=MAX_NUM_LENGTH){
                return
            }

            state =state.copy(
                number1=state.number1+number
            )
            return
        }

        if (state.number2.length>= MAX_NUM_LENGTH){
            return
        }

        state = state.copy(
            number2 = state.number2+number
        )


    }

    private fun performCalculation() {

        val number1 = state.number1.toDoubleOrNull()
        val number2= state.number2.toDoubleOrNull()

        if(number1 != null && number2!= null)
        {
            val result = when(state.operation){
                is CalculatorOperation.Add-> number1 + number2
                CalculatorOperation.Divide -> number1/ number2
                CalculatorOperation.Multiply -> number1 * number2
                CalculatorOperation.Subtract -> number1 - number2
                null -> return
            }

            state  = state.copy(
                number1 = result.toString().take(15),
                number2="",
                operation = null

            )

        }





    }

    companion object{
        private const val MAX_NUM_LENGTH=8
    }

}