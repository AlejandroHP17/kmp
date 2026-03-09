package com.liftechnology.myfirstkmp.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.liftechnology.myfirstkmp.domain.ExpenseRepository
import com.liftechnology.myfirstkmp.model.Expense
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch


data class ExpenseUiState(
    val expenses: List<Expense> = emptyList(),
    val total: Double = 0.0
)
class ExpensesViewModel(private val expenseRepository: ExpenseRepository) : ViewModel() {

    private val _uiState = MutableStateFlow(ExpenseUiState())
    val uiState: StateFlow<ExpenseUiState> = _uiState.asStateFlow()

    private val allExpenses = expenseRepository.getAllExpense()

    init {
        viewModelScope.launch {
            getAllExpenses()
        }
    }

    private fun getAllExpenses(){
        _uiState.update { state ->
            state.copy(
                expenses = allExpenses,
                total = allExpenses.sumOf { it.amount }
            )
        }
    }

    fun addExpense(expense: Expense){
        viewModelScope.launch {
            expenseRepository.addExpense(expense)
            getAllExpenses()
        }
    }

    fun editExpense(expense: Expense){
        viewModelScope.launch {
            expenseRepository.editExpense(expense)
            getAllExpenses()
        }
    }

    fun deleteExpense(expense: Expense){
        viewModelScope.launch {
            expenseRepository.deleteExpense(expense)
            getAllExpenses()
        }
    }

    fun getExpenseWithId(id: Long): Expense?{
        return allExpenses.find { it.id == id }
    }

}