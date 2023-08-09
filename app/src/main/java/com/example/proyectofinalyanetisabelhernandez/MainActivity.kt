package com.example.proyectofinalyanetisabelhernandez

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.capitulo8.model.Dog
import com.example.capitulo8.model.DogsViewModel
import com.example.proyectofinalyanetisabelhernandez.ui.theme.ProyectoFinalYanetIsabelHernandezTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val dogsViewModel by viewModels<DogsViewModel> ()
        setContent {
            ProyectoFinalYanetIsabelHernandezTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                   ScreenMain(dogsViewModel = dogsViewModel)
                }
            }
        }
    }
}
@Composable
fun ScreenMain(dogsViewModel: DogsViewModel){
    var state = dogsViewModel.state
    Column(modifier = Modifier.fillMaxSize()) {
        Spacer(modifier = Modifier.height(40.dp))
        LazyColumn(modifier = Modifier
            .fillMaxWidth()
            .height(350.dp)){
            items(state.dogs){
                    dog ->
                Spacer(modifier = Modifier.height(15.dp))
                TarjetaDog(dog = dog)
            }
        }
        Spacer(modifier = Modifier.height(25.dp))
        Button(onClick = { dogsViewModel.changeStateDogs() }) {
            Text(text = "Obtener Perros")
        }

    }
}
@Composable
fun TarjetaDog( dog : Dog){
    Row(modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center

    ) {
        Box(modifier = Modifier
            .size(350.dp)
            .clip(RectangleShape)
            .background(Color.LightGray)
            .padding(10.dp)) {
            Row(
                modifier= Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.Top,
                horizontalArrangement = Arrangement.Start ) {
                AsyncImage(
                    model = dog.urlImage ,
                    contentDescription = "perro",
                    modifier = Modifier
                        .size(150.dp)
                        .clip(CircleShape)
                        .border(2.dp, Color.Blue, CircleShape)
                )
                Spacer(modifier = Modifier.width(30.dp))
                Column {
                    Text(
                        text = dog.name,
                        fontSize = 25.sp,
                        fontStyle = FontStyle.Normal,
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily.Monospace,
                        modifier = Modifier.offset(x=10.dp)

                    )
                    Spacer(modifier = Modifier.height(15.dp))
                    Text(
                        text = "Vida Máxima: ".plus(dog.maxLife).plus(" años"),
                        fontSize = 20.sp,
                        fontStyle = FontStyle.Normal,
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily.Monospace
                    )

                }

            }

            Row(verticalAlignment = Alignment.Top, horizontalArrangement = Arrangement.Center,
                modifier = Modifier.align(
                    Alignment.Center
                )) {
                Text(text = dog.description, fontSize = 15.sp, modifier = Modifier.offset(y=40.dp))
            }


        }

    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ProyectoFinalYanetIsabelHernandezTheme {
        Greeting("Android")
    }
}