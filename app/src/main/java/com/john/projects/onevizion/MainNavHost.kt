package com.john.projects.onevizion

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.john.projects.features.details.navigation.DetailsDestination
import com.john.projects.features.details.DetailsScreen
import com.john.projects.features.details.navigation.navigateToDetails
import com.john.projects.features.items.navigation.ItemsDestination
import com.john.projects.features.items.ItemsScreen

/**
 * Навигация.
 */
@Composable
fun MainNavHost() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = ItemsDestination.route
    ) {
        composable(ItemsDestination.route) {
            ItemsScreen(
                navigateToDetails = navController::navigateToDetails
            )
        }
        composable(
            route = DetailsDestination.routeWithArgs,
            arguments = DetailsDestination.arguments
        ) {
            DetailsScreen()
        }
    }
}