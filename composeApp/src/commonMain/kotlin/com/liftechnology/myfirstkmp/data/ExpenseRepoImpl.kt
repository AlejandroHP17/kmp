package com.liftechnology.myfirstkmp.data

import com.liftechnology.myfirstkmp.domain.ExpenseRepository
import com.liftechnology.myfirstkmp.model.Expense
import com.liftechnology.myfirstkmp.model.ExpenseCategory

class ExpenseRepoImpl(
    private val expenseManager : ExpenseManager
) : ExpenseRepository{
    override fun getAllExpense(): List<Expense> {
        return expenseManager.fakeExpenseList
    }

    override fun addExpense(expense: Expense) {
        expenseManager.addNewExpense(expense)
    }

    override fun editExpense(expense: Expense) {
        expenseManager.editExpense(expense)
    }

    override fun getCategories(): List<ExpenseCategory> {
        return expenseManager.getCategories()
    }
}