package com.hmduc.alarmapp

sealed class NavigationItem(var route: String, var icon: Int, var title: String) {
    object Alarm: NavigationItem("Alarm", R.drawable.ic_alarm_on,"Alarm")
    object Sleep: NavigationItem("Sleep", R.drawable.ic_sleep,"Sleep")
    object Timer: NavigationItem("Timer", R.drawable.ic_hourglass,"Timer")
    object Stopwatch: NavigationItem("Stopwatch", R.drawable.ic_stopwatch,"Stopwatch")
}
