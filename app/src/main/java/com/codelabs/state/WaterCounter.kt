package com.codelabs.state

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun StatelessCounter(count: Int, onIncrement: () -> Unit, modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(vertical = 8.dp).fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        Button(onClick = onIncrement, enabled = count < 10) {
            Text("Выпить стакан")
        }
        if (count == 0) {
            Text("Пей воду!")
        } else {
            Text("Вы выпили $count стаканов.")
        }
    }
}

@Composable
fun StatefulCounter(modifier: Modifier = Modifier) {
    var count by rememberSaveable { mutableIntStateOf(0) }
    StatelessCounter(count, { count++ }, modifier)
}