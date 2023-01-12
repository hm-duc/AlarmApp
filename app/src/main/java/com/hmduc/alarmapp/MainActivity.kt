package com.hmduc.alarmapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.hmduc.alarmapp.ui.theme.PrimaryTextColor
import com.hmduc.alarmapp.ui.theme.Roboto

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
        }
    }
}

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    Scaffold(
        topBar = { HeaderUI() },
        bottomBar = { BottomNavigation(navController, currentDestination) },
        backgroundColor = colorResource(id = R.color.background)
    ) {
        Box(modifier = Modifier.padding(it)) {
            Navigation(navController = navController)
        }
    }
}

@Composable
fun HeaderUI() {
    Row(modifier = Modifier
        .background(colorResource(id = R.color.primary))
        .fillMaxWidth()
        .padding(20.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically) {
        Text(
            text = "Alarm",
            fontFamily = Roboto,
            color = PrimaryTextColor,
            fontWeight = FontWeight.Medium
        )
        Image(painter = painterResource(
            id = R.drawable.ic_more_vert),
            contentDescription = "",
        )
    }
}

@Composable
fun BottomNavigation(
    navController: NavHostController,
    currentDestination: NavDestination?,
){
    var listItem = listOf(
        NavigationItem.Alarm,
        NavigationItem.Sleep,
        NavigationItem.Timer,
        NavigationItem.Stopwatch,
    )
    BottomNavigation(
        backgroundColor = colorResource(id = R.color.primary),
        contentColor = Color.White
    ) {
        listItem.forEach { screen ->
            BottomNavigationItem(
                selected = currentDestination?.hierarchy?.any {
                    it.route == screen.route
                } == true,
                onClick = {
                    navController.navigate(screen.route) {
                        navController.graph.startDestinationRoute?.let { route ->
                            popUpTo(route) {
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                icon = { Icon(painterResource(id = screen.icon), contentDescription = screen.title) },
                label = { Text(text = screen.title) },
                selectedContentColor = Color.White,
                unselectedContentColor = Color.White.copy(0.4f),
                alwaysShowLabel = true,
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun HeaderPreview() {
    HeaderUI()
}
