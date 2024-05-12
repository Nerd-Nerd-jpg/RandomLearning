package com.example.randomlearning

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MyViewModel @Inject constructor(
    private val useCases: ViewCashFlowRecordsPageUseCases
): ViewModel() {
    init {
        viewModelScope.launch(Dispatchers.IO) {
            insertCashFlowRecord()
        }
    }

    fun insertCashFlowRecord() {
        viewModelScope.launch(Dispatchers.IO) {
            val x = CashFlowRecord(
                timestamp = 11111111L,
                incomeOrNot = true,
                category = 1,
                amount = 10.00,
                comment = "Input 1"
            )
            val y = CashFlowRecord(
                timestamp = 22222222L,
                incomeOrNot = false,
                category = 2,
                amount = 20.00,
                comment = "Input 2"
            )
            useCases.insertCashFlowRecordUseCase(x)
            useCases.insertCashFlowRecordUseCase(y)
        }
    }

    fun getCashFlowRecords() {
        viewModelScope.launch(Dispatchers.IO) {
            val output = useCases.getCashFlowRecordsUseCase()
            Log.d("Ohoy", output.toString())
        }
    }

    fun deleteCashFlowRecords() {
        viewModelScope.launch(Dispatchers.IO) {
            useCases.deleteCashFlowRecordsUseCase()
        }
    }
}