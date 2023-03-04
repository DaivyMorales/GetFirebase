package com.example.crudapplication.models
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObjects
import com.google.firebase.ktx.Firebase

class AlumnoViewModel : ViewModel() {

    //1. Creamos la variable de estado que almacenara la clase Alumno
    private val _alumnos = mutableStateOf<List<Alumno>>(emptyList())


    //2. Para poder consultarla debemos crear un metodo get de la clase
    val alumnos : State<List<Alumno>>

        get() = _alumnos

    //3. Creamos una variable para el query a la coleccion de la BD
    private val query = Firebase.firestore.collection("alumnos")

    //4. Creamos el metodo constructor del viewModel que leera los alumnos
    init {
        query.addSnapshotListener{ value, _ ->
            if( value != null ) {
                _alumnos.value = value.toObjects()
            }// fin del if
        } //fin del listener
    } //fin del constructor

}// fin de la clase