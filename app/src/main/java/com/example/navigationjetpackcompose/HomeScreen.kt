package com.example.navigationjetpackcompose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@Composable
fun HomeScreen(navController: NavController) {

    var text by rememberSaveable {
        mutableStateOf("")
    }

    Column (
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        TextField(value = text, onValueChange = { value ->
            text = value
        })
        Button(onClick = {
            // TODO #5: use the navController to do navigation actions.. use the next line and comment the rest for obligatory args and do the opposite for nullable args
            // TODO: do this according to what you're using in the NavHost
            navController.navigate(Navigation.SecondScreen.getRouteWithNonNullableArguments(name = text))
//            if(text.isNotEmpty()) navController.navigate(Navigation.SecondScreen.getRouteWithNullableArguments(name = text))
//            else navController.navigate(Navigation.SecondScreen.getRouteWithNullableArguments(name = null))
        }) {
            Text("Say Hello!")
        }
    }
}