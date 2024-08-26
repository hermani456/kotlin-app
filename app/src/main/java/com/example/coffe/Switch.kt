package com.example.coffe

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.RadioButtonUnchecked
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.coffe.ui.theme.Accent
import com.example.coffe.ui.theme.Background
import com.example.coffe.ui.theme.OnPrimary
import com.example.coffe.ui.theme.Secondary

@Composable
fun DeviceControlScreen() {
    var isMotorOn by remember { mutableStateOf(false) }
    var isRelayOn by remember { mutableStateOf(false) }
    var isLabadoraOn by remember { mutableStateOf(false) }
    var isMicroondasOn by remember { mutableStateOf(false) }
    var isCamaOn by remember { mutableStateOf(false) }


    Box(
        modifier = Modifier
            .background(Background)
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Controlar dispositivos", fontSize = 28.sp, modifier = Modifier.padding(bottom = 16.dp), color = OnPrimary)

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

            SwitchWithLabel(
                label = "Labadora",
                isChecked = isLabadoraOn,
                onCheckedChange = { isLabadoraOn = it }
            )

            SwitchWithLabel(
                label = "Microondas",
                isChecked = isMicroondasOn,
                onCheckedChange = { isMicroondasOn = it }
            )

            SwitchWithLabel(
                label = "Cama",
                isChecked = isCamaOn,
                onCheckedChange = { isCamaOn = it }
            )
        }
    }
}

@Composable
fun SwitchWithLabel(label: String, isChecked: Boolean, onCheckedChange: (Boolean) -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        Text(text = label, fontSize = 18.sp, modifier = Modifier.weight(1f), color = OnPrimary)
        Switch(
            checked = isChecked,
            onCheckedChange = onCheckedChange
        )
        Spacer(modifier = Modifier.width(8.dp))
        Icon(
            imageVector = if (isChecked) Icons.Default.CheckCircle else Icons.Default.RadioButtonUnchecked,
            contentDescription = null,
            tint = if (isChecked) Secondary else Color.Gray,
            modifier = Modifier.size(24.dp)
        )
    }
}