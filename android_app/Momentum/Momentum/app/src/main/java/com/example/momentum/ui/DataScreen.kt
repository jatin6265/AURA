package com.example.momentum.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun DataScreen(viewModel: MainViewModel) {
    var fromTime by remember { mutableStateOf("00:00:00") }
    var toTime by remember { mutableStateOf("00:00:00") }
    var label by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Data Labeling", style = androidx.compose.material3.MaterialTheme.typography.headlineMedium)
        Spacer(Modifier.height(16.dp))
        OutlinedTextField(
            value = fromTime,
            onValueChange = { fromTime = it },
            label = { Text("From (HH:mm:ss)") },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = toTime,
            onValueChange = { toTime = it },
            label = { Text("To (HH:mm:ss)") },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = label,
            onValueChange = { label = it },
            label = { Text("Label") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(Modifier.height(16.dp))
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            Button(onClick = { viewModel.applyWindowedLabels(fromTime, toTime, label) { count ->
                // Show toast or snackbar with result
            } }) {
                Text("Apply Label")
            }
            Button(onClick = { viewModel.deleteLabeledWindowsInRange(fromTime, toTime) { count ->
                // Show toast or snackbar with result
            } }) {
                Text("Delete Labels")
            }
        }
    }
}
