package giovane.giraldi.appimc
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import giovane.giraldi.appimc.ui.theme.AppIMCTheme
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppIMCTheme {
                Telainicial()
            }
        }
    }
}
@Composable
fun Telainicial() {

    var altura by remember { mutableStateOf(value = "") }
    var peso by remember { mutableStateOf(value = "") }
    var imc by remember { mutableStateOf(value = "") }

    fun calcularIMC(){
    try {


    var valorPeso = peso.toDouble()
    var valorAltura = altura.toDouble()
    var ValorIMC = valorPeso / Math.pow(valorAltura, 2.0)
    imc = String.format("%.2f",ValorIMC)
}
    catch(e: Exception) {
        imc = "valor incorreto"
    }
}
    Scaffold {
            innerPadding -> Column(modifier = Modifier.fillMaxWidth().padding(innerPadding)) {
            Text(text = "Altura")
            OutlinedTextField(
                value = altura,
                onValueChange = { altura = it },
                modifier = Modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            Text(text = "Peso")
            OutlinedTextField(
                value = peso,
                onValueChange = { peso = it },
                modifier = Modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            Button(onClick = {calcularIMC()}) {
                Text(text = "Calcular")
            }
            Text(
                text = imc, fontSize = 50.sp,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
            }
        }

}

@Preview(showBackground = true)
@Composable
fun TelaInicialPreview() {
    AppIMCTheme {
        Telainicial()
    }
}