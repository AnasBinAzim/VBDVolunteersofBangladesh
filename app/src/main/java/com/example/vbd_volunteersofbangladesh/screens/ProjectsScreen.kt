package com.example.vbd_volunteersofbangladesh.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage

data class Project(
    val title: String,
    val description: String,
    val imageUrl: String,
    val isOngoing: Boolean
)

@Composable
fun ProjectsScreen() {
    val projects = listOf(
        Project(
            "Winter Clothing Drive",
            "Distributing warm clothes to 1000+ families in northern districts",
            "https://example.com/winter.jpg",
            true
        ),
        Project(
            "Education for All",
            "Providing free education and supplies to underprivileged children",
            "https://example.com/education.jpg",
            true
        ),
        Project(
            "Food Distribution",
            "Completed: Distributed food packages to 500 families during Ramadan",
            "https://example.com/food.jpg",
            false
        )
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Our Projects",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(projects) { project ->
                ProjectCard(project)
            }
        }
    }
}

@Composable
fun ProjectCard(project: Project) {
    ElevatedCard(
        modifier = Modifier.fillMaxWidth()
    ) {
        Column {
            AsyncImage(
                model = project.imageUrl,
                contentDescription = project.title,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                contentScale = ContentScale.Crop
            )
            
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = project.title,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                    
                    if (project.isOngoing) {
                        SuggestionChip(
                            onClick = { },
                            label = { Text("Ongoing") }
                        )
                    }
                }
                
                Spacer(modifier = Modifier.height(8.dp))
                
                Text(text = project.description)
                
                Spacer(modifier = Modifier.height(8.dp))
                
                Button(
                    onClick = { /* TODO: Implement volunteer signup */ },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Volunteer for this project")
                }
            }
        }
    }
} 