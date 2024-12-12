package com.example.vbd_volunteersofbangladesh

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Assignment
import com.example.vbd_volunteersofbangladesh.screens.HomeScreen
import com.example.vbd_volunteersofbangladesh.screens.ProjectsScreen
import com.example.vbd_volunteersofbangladesh.ui.theme.VBDVolunteersOfBangladeshTheme
import com.example.vbd_volunteersofbangladesh.screens.AboutScreen
import com.example.vbd_volunteersofbangladesh.screens.DonateScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            VBDVolunteersOfBangladeshTheme {
                MainScreen()
            }
        }
    }
}

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    var selectedItem by remember { mutableStateOf(0) }
    
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            NavigationBar {
                NavigationBarItem(
                    selected = selectedItem == 0,
                    onClick = { 
                        selectedItem = 0
                        navController.navigate("home") {
                            popUpTo("home") { inclusive = true }
                        }
                    },
                    icon = { Icon(Icons.Default.Home, contentDescription = "Home") },
                    label = { Text("Home") }
                )
                NavigationBarItem(
                    selected = selectedItem == 1,
                    onClick = { 
                        selectedItem = 1
                        navController.navigate("projects") {
                            popUpTo("home")
                        }
                    },
                    icon = { Icon(Icons.Default.Assignment, contentDescription = "Projects") },
                    label = { Text("Projects") }
                )
                NavigationBarItem(
                    selected = selectedItem == 2,
                    onClick = { 
                        selectedItem = 2
                        navController.navigate("donate") {
                            popUpTo("home")
                        }
                    },
                    icon = { Icon(Icons.Default.Favorite, contentDescription = "Donate") },
                    label = { Text("Donate") }
                )
                NavigationBarItem(
                    selected = selectedItem == 3,
                    onClick = { 
                        selectedItem = 3
                        navController.navigate("about") {
                            popUpTo("home")
                        }
                    },
                    icon = { Icon(Icons.Default.Info, contentDescription = "About") },
                    label = { Text("About") }
                )
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = "home",
            modifier = Modifier.padding(innerPadding)
        ) {
            composable("home") { 
                HomeScreen(
                    onDonateClick = { 
                        selectedItem = 2
                        navController.navigate("donate")
                    },
                    onProjectsClick = {
                        selectedItem = 1
                        navController.navigate("projects")
                    }
                )
            }
            composable("projects") { ProjectsScreen() }
            composable("donate") { DonateScreen() }
            composable("about") { AboutScreen() }
        }
    }
}