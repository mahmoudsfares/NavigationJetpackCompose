package com.example.navigationjetpackcompose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@Composable
fun SecondScreen(navController: NavController) {

    val arguments = navController.currentBackStackEntry?.arguments
    val name by remember {
        val name = arguments?.getString("name")
        mutableStateOf(name)
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Hello " + (name ?: "there") + "!")
        Button(onClick = {
            // TODO #6: pop actions
            // pop back until
            navController.navigate(Navigation.HomeScreen.getRoute()) {
                popUpTo(Navigation.HomeScreen.getRoute()) {
                    inclusive = true
                }
            }
            // pop
            // navController.popBackStack()
        }) {
            Text("Go back")
        }
    }
}