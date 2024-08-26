package com.example.coffe

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun DeviceControlScreen() {
    var isMotorOn by remember { mutableStateOf(false) }
    var isRelayOn by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Controlar dispositivos", fontSize = 28.sp, modifier = Modifier.padding(bottom = 16.dp))

            SwitchWithLabel(
                label = "Motor",
                isChecked = isMotorOn,
                onCheckedChange = { isMotorOn = it }
            )

            SwitchWithLabel(
                label = "Rele",
                isChecked = isRelayOn,
                onCheckedChange = { isRelayOn = it }
            )
        }
    }
}

@Composable
fun SwitchWithLabel(label: String, isChecked: Boolean, onCheckedChange: (Boolean) -> Unit) {
    Column(
        modifier = Modifier.padding(vertical = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = label, fontSize = 18.sp, modifier = Modifier.padding(bottom = 8.dp))
        Switch(
            checked = isChecked,
            onCheckedChange = onCheckedChange
        )
    }
}