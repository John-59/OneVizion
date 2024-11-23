package com.john.projects.features.details.navigation

import androidx.navigation.NavHostController

/**
 * Навигация на экран с информацией об объекте.
 * @param itemId Идентификатор объекта.
 */
fun NavHostController.navigateToDetails(itemId: Long) {
    val route = "${DetailsDestination.route}/$itemId"
    navigate(route) {
        launchSingleTop = true
    }
}