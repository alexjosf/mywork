package com.example.mywork

import com.example.mywork.ui.screens.HomeScreen
import com.example.mywork.ui.screens.ScheduleScreen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mywork.ui.screens.AccountScreen
import com.example.mywork.ui.screens.AvailabilityScreen
import com.example.mywork.ui.screens.LogInScreen
import com.example.mywork.ui.screens.SwapScreen
import com.example.mywork.ui.theme.MyworkTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyworkTheme {
                MainScreen()
            }
        }
    }
}

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "swapScreen",
    ) {
        composable("logIn") { LogInScreen(navController) }
        composable("bottomBar") { BottomNavigationBar(navController) }
        composable("availabilityScreen") { AvailabilityScreen(navController) }
        composable("swapScreen") { SwapScreen(navController) }
    }

}

@Composable
fun BottomNavigationBar(navController: NavHostController) {
    var selectedItem by remember { mutableIntStateOf(0) }
    val items = listOf(Icons.Default.Home, Icons.Default.DateRange, Icons.Default.Person)

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .padding()
            .navigationBarsPadding(),
        bottomBar = {
            NavigationBar(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp), containerColor = Color.White
            ) {
                items.forEachIndexed { index, item ->
                    NavigationBarItem(
                        icon = { Icon(imageVector = item, contentDescription = null) },
                        enabled = true,
                        selected = selectedItem == index,
                        onClick = { selectedItem = index },
                        colors = NavigationBarItemDefaults.colors(
                            // ✅ Remove oval effect
                            selectedIconColor = Color.Black,
                            unselectedIconColor = Color.Gray,
                            indicatorColor = Color.Transparent,
                        )
                    )
                }
            }
        }) { paddingValues ->
        when (selectedItem) {
            0 -> HomeScreen(Modifier.padding(paddingValues), navController)
            1 -> ScheduleScreen(Modifier.padding(paddingValues), navController)
            2 -> AccountScreen(Modifier.padding(paddingValues), navController)
        }
    }
}