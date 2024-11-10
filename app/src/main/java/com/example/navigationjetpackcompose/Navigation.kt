package com.example.navigationjetpackcompose

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

// TODO #1: define mere route names, make this private to force the clients to pass the arguments
private object RouteNames {
    const val HOME = "home"
    const val SECOND = "second"
}

sealed class Navigation {
    // TODO #2: define mere route names, add the method getRoute to customize passed arguments.. notice the differences between the methods according to the passed arguments
    data object HomeScreen: Navigation() {
        fun getRoute(): String {
            return RouteNames.HOME
        }
    }
    data object SecondScreen: Navigation() {
        fun getRouteWithNonNullableArguments(name: String): String {
            return RouteNames.SECOND + "/$name"
        }
        fun getRouteWithNullableArguments(name: String?): String {
            return RouteNames.SECOND + "?name=$name"
        }
    }
}

// TODO #3: create a NavGraph composable.. this defines each route in the app and the required arguments for each destination
@Composable
fun NavGraph() {
    // carries out the navigation with commands like navigate, pop,...
    // must be passed to all the screens in which a navigation action will take place
    val navController = rememberNavController()
    // a container for all the destinations in the app
    NavHost(navController = navController, startDestination = Navigation.HomeScreen.getRoute()) {
        // home screen: initial, no arguments
        composable(route = RouteNames.HOME) {
            HomeScreen(navController = navController)
        }
        // second screen: has arguments
        // TODO: use the first one and comment the second for obligatory args, use the second for optional args
        // TODO: do this according to what you're calling in the HomeScreen
        composable(
            route = RouteNames.SECOND + "/{name}",
            arguments = listOf(
                navArgument(name = "name"){
                    type = NavType.StringType
                    nullable = false
                }
            )
        ) {
            SecondScreen(navController)
        }
//        composable(
//            route = RouteNames.SECOND + "?name={name}",
//            arguments = listOf(
//                navArgument(name = "name"){
//                    type = NavType.StringType
//                    nullable = true
//                }
//            )
//        ) {
//            SecondScreen(navController)
//        }
    }
}

