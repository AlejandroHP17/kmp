package com.liftechnology.myfirstkmp.domain

import com.liftechnology.myfirstkmp.model.Expense
import com.liftechnology.myfirstkmp.model.ExpenseCategory

interface ExpenseRepository {
    fun getAllExpense(): List<Expense>
    fun addExpense(expense: Expense)
    fun editExpense(expense: Expense)
    fun getCategories(): List<ExpenseCategory>

    fun deleteExpense(expense: Expense): List<Expense>
}