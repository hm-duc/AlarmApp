package com.hmduc.alarmapp

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = NavigationItem.Alarm.route,
    ) {
        composable(NavigationItem.Alarm.route) {
            AlarmScreen()
        }
        composable(NavigationItem.Sleep.route) {
            SleepScreen()
        }
        composable(NavigationItem.Timer.route) {
            TimerScreen()
        }
        composable(NavigationItem.Stopwatch.route) {
            StopwatchScreen()
        }
    }
}