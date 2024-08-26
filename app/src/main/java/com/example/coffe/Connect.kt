package com.example.coffe

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.coffe.ui.theme.Background
import com.example.coffe.ui.theme.OnPrimary
import com.example.coffe.ui.theme.Primary
import com.example.coffe.ui.theme.Secondary

@Composable
fun BluetoothScreen() {
    var isConnected by remember { mutableStateOf(false) }
    var mockupData by remember { mutableStateOf("Sin Conexion") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Background)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Text(text = "Conectar dispositivo", fontSize = 24.sp, modifier = Modifier.padding(bottom = 16.dp), color = OnPrimary)
        Button(colors = ButtonColors(Primary, Secondary, Secondary, Primary),
            onClick = {
            isConnected = !isConnected
            mockupData = if (isConnected) "Conectado a Arduino Uno" else "Sin Conexion"
        }) {
            Text(text = if (isConnected) "Desconectar" else "Conectar")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = mockupData, fontSize = 18.sp, color = OnPrimary)
    }
}