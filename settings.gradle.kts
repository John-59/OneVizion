pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "OneVizion"
include(":app")
include(":core:backend")
include(":core:repository")
include(":core:domain")
include(":services:backend")
include(":services:repository")
include(":features:items")
include(":features:details")
include(":core:navigation")
include(":usecases")
include(":core:ui")
include(":core:utils")
