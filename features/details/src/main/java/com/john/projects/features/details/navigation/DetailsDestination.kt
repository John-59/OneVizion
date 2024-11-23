package com.john.projects.features.details.navigation

import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.john.projects.core.navigation.Destination
import com.john.projects.features.details.DetailsArgs

/**
 * Цель навигации - экран с информацией об объекте.
 */
object DetailsDestination: Destination("details") {

    val routeWithArgs = "$route/{${DetailsArgs.itemIdArgName}}"

    val arguments = listOf(
        navArgument(DetailsArgs.itemIdArgName) {
            type = NavType.LongType
            defaultValue = -1
        }
    )
}