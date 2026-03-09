package com.liftechnology.myfirstkmp.previews

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.liftechnology.myfirstkmp.data.ExpenseManager
import com.liftechnology.myfirstkmp.getColorsTheme
import com.liftechnology.myfirstkmp.ui.AllExpensesHeader
import com.liftechnology.myfirstkmp.ui.ExpenseItem
import com.liftechnology.myfirstkmp.ui.ExpensesTotalHeader

@Preview(showBackground = true)
@Composable
fun PreviewsScreen(){
    val color = getColorsTheme()
    Column {
        ExpensesTotalHeader(total = 1028.8, color)
        AllExpensesHeader()
        ExpenseItem(
            expense = ExpenseManager.fakeExpenseList[0],
            onExpenseClick = {}
        )
    }

}