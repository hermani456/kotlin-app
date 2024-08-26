
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.WaterDrop
import androidx.compose.material.icons.filled.WbSunny
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.coffe.ui.theme.Background
import com.example.coffe.ui.theme.OnPrimary
import com.example.coffe.ui.theme.OnSurface
import com.example.coffe.ui.theme.Secondary
import com.example.coffe.ui.theme.Surface

@Composable
fun TemperatureScreen() {
    // Mockup temperature data
    val temperature = remember { mutableFloatStateOf(25.0f) }
    val humidity = 60.0f

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Background)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Temperatura",
            fontSize = 28.sp,
            modifier = Modifier.padding(bottom = 16.dp),
            color = OnPrimary
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(bottom = 16.dp)
        ) {
            Text(
                text = "${temperature.floatValue} °C",
                fontSize = 38.sp,
                color = Secondary
            )
            Spacer(modifier = Modifier.width(8.dp))
            Icon(
                imageVector = Icons.Default.WbSunny,
                contentDescription = "Sun Icon",
                tint = Surface,
                modifier = Modifier.size(38.dp)
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Humedad",
            fontSize = 28.sp,
            modifier = Modifier.padding(bottom = 16.dp),
            color = OnPrimary
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(bottom = 16.dp)
        ) {
            Text(
                text = "$humidity %",
                fontSize = 38.sp,
                color = Secondary
            )
            Spacer(modifier = Modifier.width(8.dp))
            Icon(
                imageVector = Icons.Default.WaterDrop,
                contentDescription = "Sun Icon",
                tint = OnSurface,
                modifier = Modifier.size(38.dp)
            )
        }
    }
}