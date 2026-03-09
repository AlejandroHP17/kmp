package com.liftechnology.myfirstkmp.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.liftechnology.myfirstkmp.DarkModeColor
import com.liftechnology.myfirstkmp.getColorsTheme
import com.liftechnology.myfirstkmp.model.Expense
import com.liftechnology.myfirstkmp.presentation.ExpenseUiState

@Composable
fun ExpensesScreen(
    uiState: ExpenseUiState,
    onExpenseClick: (expense: Expense) -> Unit
){
    val colors = getColorsTheme()

    LazyColumn (
        modifier = Modifier.padding( 16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        stickyHeader {
            Column (
                modifier = Modifier.background(color = colors.backgroundColor)
            ){
                ExpensesTotalHeader(total = uiState.total, colors)
                AllExpensesHeader()
            }
        }

        items(uiState.expenses){ expense ->
            ExpenseItem(
                expense = expense,
                onExpenseClick = { onExpenseClick }
            )
        }
    }
}

@Composable
fun ExpensesTotalHeader(total: Double, colors: DarkModeColor){
    Card(
        shape = RoundedCornerShape(30),
        colors = CardDefaults.cardColors(
            containerColor = colors.backgroundColor,
            contentColor = colors.backgroundColor,
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 5.dp)
    ){
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(130.dp)
                .padding(16.dp),
            contentAlignment = Alignment.CenterStart
        ){
            Text(
                text= "$$total",
                fontSize = 30.sp,
                fontWeight = FontWeight.ExtraBold,
                color = colors.textColor
            )
            Text(
                modifier = Modifier.align ( Alignment.CenterEnd ),
                text= "USD",
                color = Color.Gray
            )
        }
    }
}

@Composable
fun AllExpensesHeader(){
    val colors = getColorsTheme()

    Row(
        modifier = Modifier.padding(vertical = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ){
        Text(
            modifier = Modifier.weight(1f),
            text= "All exppenses",
            fontWeight = FontWeight.ExtraBold,
            fontSize = 20.sp,
            color = colors.textColor
        )
        Button(
            shape = RoundedCornerShape(50),
            onClick = {},
            colors = ButtonDefaults.buttonColors(
                containerColor = colors.backgroundColor
            ),
            enabled = false
        ){
            Text(text = "View All")
        }
    }
}

@Composable
fun ExpenseItem(
    expense : Expense,
    onExpenseClick: (expense: Expense) -> Unit
){
    val colors = getColorsTheme()

    Card (
        modifier = Modifier.fillMaxWidth()
            .padding(horizontal = 2.dp)
            .clickable{onExpenseClick(expense)},
        shape = RoundedCornerShape(30),
        colors = CardDefaults.cardColors(
            containerColor = colors.backgroundColor,
            contentColor = colors.backgroundColor,
        ),
    ){
        Row(
            modifier = Modifier.padding(horizontal = 4.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ){
            Surface(
                modifier = Modifier.size(5.dp),
                shape = RoundedCornerShape(50.dp),
                color = colors.purple
            ) {
                Image(
                    modifier = Modifier.padding(10.dp),
                    imageVector = expense.icon,
                    colorFilter = ColorFilter.tint(Color.White),
                    contentScale = ContentScale.Crop,
                    contentDescription = "Imagen Icono Expense Item"
                )
            }

            Column(
                modifier = Modifier.padding(start = 8.dp)
                    .weight(1f)
            ){
                Text(
                    text = expense.category.name,
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 18.sp,
                    color = colors.textColor
                )
                Text(
                    text = expense.description,
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 15.sp,
                    color = Color.Gray
                )
            }

            Text(
                text = "$${expense.amount}",
                fontWeight = FontWeight.ExtraBold,
                fontSize = 20.sp,
                color = colors.textColor
            )
        }
    }
}