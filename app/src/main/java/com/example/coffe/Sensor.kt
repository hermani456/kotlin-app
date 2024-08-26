
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TemperatureScreen() {
    // Mockup temperature data
    val temperature = remember { mutableFloatStateOf(25.0f) }
    val humidity = 60.0f

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Temperatura", fontSize = 28.sp, modifier = Modifier.padding(bottom = 16.dp))
        Text(text = "${temperature.value} °C", fontSize = 38.sp)
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Humedad", fontSize = 28.sp, modifier = Modifier.padding(bottom = 16.dp))
        Text(text = "$humidity %", fontSize = 38.sp)
    }
}