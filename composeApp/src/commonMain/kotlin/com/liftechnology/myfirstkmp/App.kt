package com.liftechnology.myfirstkmp

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.liftechnology.myfirstkmp.data.ExpenseManager
import com.liftechnology.myfirstkmp.presentation.ExpenseUiState
import com.liftechnology.myfirstkmp.ui.ExpensesScreen
import moe.tlaster.precompose.PreComposeApp

@Composable
@Preview
fun App() {
    PreComposeApp {
        val colors = getColorsTheme()


        AppTheme {
            ExpensesScreen(
                uiState = ExpenseUiState(
                    expenses = ExpenseManager.fakeExpenseList,
                    total = 1052.2
                ),
                onExpenseClick = {}
            )

        }
    }
}