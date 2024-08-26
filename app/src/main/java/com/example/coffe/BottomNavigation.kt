package com.example.coffe

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bluetooth
import androidx.compose.material.icons.filled.Lightbulb
import androidx.compose.material.icons.filled.Sensors
import androidx.compose.material.icons.filled.ToggleOn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.coffe.ui.theme.OnPrimary
import com.example.coffe.ui.theme.Primary
import com.example.coffe.ui.theme.Secondary


data class NavPage(var name: String, var icon: ImageVector, var route: String)

object Routes {
    var ConnectionPages = NavPage("Conexion", Icons.Filled.Bluetooth, "conexion" )
    var SwitchPages = NavPage("Switchs", Icons.Filled.ToggleOn, "switchs" )
    var LightsPages = NavPage("Lights", Icons.Filled.Lightbulb, "lights" )
    var SensorPages = NavPage("Sensors", Icons.Filled.Sensors, "sensors" )

    var pages = listOf(ConnectionPages, SwitchPages, LightsPages, SensorPages)
}

@Preview
@Composable
fun NavPrev(){
    NavBarItem(page = Routes.SwitchPages)
}

@Composable
fun NavBar(
    selectedRoute: String = Routes.ConnectionPages.route,
    onChange: (String) -> Unit
) {
    val insets = WindowInsets.navigationBars.asPaddingValues()
    val bottomPadding = if (insets.calculateBottomPadding() == 0.dp) {
        16.dp
    } else {
        insets.calculateBottomPadding()
    }

    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = Modifier
            .fillMaxWidth()
            .background(Primary)
            .padding(vertical = bottomPadding)
    ) {
        for (page in Routes.pages) {
            NavBarItem(
                page = page,
                selected = selectedRoute == page.route,
                modifier = Modifier.clickable {
                    onChange(page.route)
                }
            )
        }
    }
}

@Composable
fun NavBarItem(page: NavPage, selected: Boolean = false, modifier: Modifier = Modifier) {
    Column(horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.padding(horizontal = 12.dp)) {
        Image(
            imageVector = page.icon,
            contentDescription = page.name,
            colorFilter = ColorFilter.tint(
                if (selected) Secondary else OnPrimary
            ),
            modifier = Modifier
                .padding(bottom = 8.dp)
                .size(24.dp)
        )
        Text(page.name,
            fontSize = 12.sp,
            color = if (selected) Secondary else OnPrimary
        )
    }
}