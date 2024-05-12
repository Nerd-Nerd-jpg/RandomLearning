package com.example.randomlearning.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.randomlearning.MyViewModel

@Composable
fun HiltRoomDemo(viewModel: MyViewModel = hiltViewModel(), ) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = { viewModel.getCashFlowRecords()}) {
            Text(text = "getCashFlowRecords")
        }

        Button(onClick = { viewModel.deleteCashFlowRecords()}) {
            Text(text = "deleteCashFlowRecords")
        }

        Button(onClick = { viewModel.insertCashFlowRecord()}) {
            Text(text = "insertCashFlowRecord")
        }
    }
}


