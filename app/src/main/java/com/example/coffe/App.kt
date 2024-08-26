@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.coffe

import TemperatureScreen
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.coffe.ui.theme.CoffeTheme
import com.example.coffe.ui.theme.Primary


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun App(modifier: Modifier) {
    val selectedRoute = remember {
        mutableStateOf(Routes.ConnectionPages.route)
    }
    Scaffold (
        topBar = {
            TopAppBar(
                title = { AppTitle() },
//                actions = {
//                    IconButton(onClick = { /* asd() */ }) {
//                        Icon(Icons.Filled.Favorite, contentDescription = null)
//                    }
//                },
//                navigationIcon = {
//                    IconButton(onClick = { /* asd() */ }) {
//                        Icon(Icons.Filled.Menu, contentDescription = null)
//                    }
//                },
                colors = TopAppBarDefaults.topAppBarColors(Primary)
            )
        },
        bottomBar = {
            NavBar(
                selectedRoute.value,
                onChange = { newRoute ->
                selectedRoute.value = newRoute
            })
        },
        ){
        innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            when(selectedRoute.value){
                Routes.ConnectionPages.route -> BluetoothScreen()
                Routes.SwitchPages.route -> DeviceControlScreen()
                Routes.LightsPages.route -> TurnLightsOnScreen()
                Routes.SensorPages.route -> TemperatureScreen()
            }
        }
    }
}


@Composable
fun AppTitle() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxWidth()
    ){
        Image(painter = painterResource(id = R.mipmap.logo_ardroid_icon), contentDescription = "logo")
    }
}

@Preview
@Composable
fun App_Preview() {
    CoffeTheme {
        App(Modifier)
    }
}