package com.example.crudapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.crudapplication.models.Alumno
import com.example.crudapplication.models.AlumnoViewModel
import com.example.crudapplication.ui.theme.CrudApplicationTheme

class MainActivity : ComponentActivity() {
    val viewModel by viewModels<AlumnoViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CrudApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    AppAlumnos(viewModel)
                }
            }
        }
    }
}

@Composable
fun AppCard(alumno: Alumno) {
    Card(modifier = Modifier
        .padding(all = 16.dp)
        .fillMaxWidth()) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Text(text = "Nombre: ${alumno.nombre}", color = Color.DarkGray, fontSize = 16.sp)
            Text(text = "Curso: ${alumno.curso} Matriculado", color = Color.Gray)
            Text(text = "Codigo: ${alumno.codigo.toString()} del alumno", color = Color.Gray)
        }//fin de la columna
    }//fin de la card
}//fin de la funcion

@Composable
fun AppAlumnos(viewModel : AlumnoViewModel) {
   val logo = painterResource(R.drawable.personas)
    /*val alumnos = listOf(
        Alumno("Pedro","23423432",121212),
        Alumno("Carlos","Perez",112434)
    )*/

    Box(modifier = Modifier.fillMaxSize()){
        Column() {
            Image(logo, contentDescription = "Alumnos",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(all = 32.dp)
                )

            LazyColumn(){
                items(viewModel.alumnos.value) { alumno ->
                    AppCard(alumno)
                }
            }//fin del lazy Column

        }
    }
}//fin de la funcion

/*
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CrudApplicationTheme {
        AppAlumnos(viewModel)
    }
}

*/
