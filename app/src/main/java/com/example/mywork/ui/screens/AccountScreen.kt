package com.example.mywork.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.mywork.R

@Composable
fun AccountScreen(modifier: Modifier, navController: NavHostController) {
    Column(
        modifier = modifier
            .fillMaxSize()
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .border(1.dp, Color.Black, RoundedCornerShape(16.dp)),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    modifier = Modifier
                        .padding(16.dp)
                        .clip(CircleShape)
                        .size(30.dp),
                    painter = painterResource(id = R.drawable.clinkclubhouse),
                    contentDescription = null,
                )
                Text("Clink clubhouse")
            }
            OrganizationSelectorMenu(navController)
        }
        LazyColumn(
            modifier = Modifier
                .weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                DataDetails(navController)
            }
        }
        Button(
            shape = RectangleShape,
            colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                containerColor = Color.Black, contentColor = Color.White
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .height(50.dp)
                .clip(RoundedCornerShape(8.dp)),
            onClick = { /* Handle click */ }) {
            Text(
                "LOG OUT",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
            )
        }
    }
}

@Composable
fun DataDetails(navController: NavHostController) {

    Text(
        "PROFILE",
        modifier = Modifier.padding(8.dp),
        color = Color.Black,
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold,
    )
    Image(
        modifier = Modifier
            .padding(8.dp)
            .clip(CircleShape)
            .size(100.dp),
        painter = painterResource(id = R.drawable.dp),
        contentDescription = null,
    )
    Column(
        modifier = Modifier
            .padding(16.dp)
            .clip(RoundedCornerShape(32.dp))
            .background(Color(0xFFecfacf))
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.Start
    ) {
        Label("Name:")
        LabelValue("Alex Joseph")
        Label("Role:")
        LabelValue("Clerk")
        Label("Email:")
        LabelValue("alex1234@clinkclubhouse.com")
        Label("Phone number:")
        LabelValue("+1 437-563-2369")
        Label("Address:")
        LabelValue("Unit 54, 60 Street, London, UK")
    }
    Row(
        modifier = Modifier
            .padding(16.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(Color(0xFFecfacf))
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            "Availability",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
        )
        IconButton(
            onClick = { navController.navigate("availabilityScreen") }){
        Icon(
            Icons.AutoMirrored.Filled.ArrowForward, contentDescription = "ADD"
        )}
    }
}

@Composable
fun OrganizationSelectorMenu(navController: NavHostController) {
    var menuVisible by remember { mutableStateOf(false) }
    IconButton(
        onClick = { menuVisible = !menuVisible }) {
        Icon(
            Icons.Default.AddCircle, contentDescription = "ADD"
        )
        DropdownMenu(
            expanded = menuVisible, onDismissRequest = { menuVisible = false }) {
            DropdownMenuItem(text = {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        modifier = Modifier
                            .padding(end = 8.dp)
                            .clip(CircleShape)
                            .size(30.dp),
                        painter = painterResource(id = R.drawable.clinkclubhouse),
                        contentDescription = null
                    )
                    Text(
                        "Clink Clubhouse",
                        modifier = Modifier,
                        color = Color.Black,
                    )
                }
            }, onClick = { /* Do something... */ })
            DropdownMenuItem(text = {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        modifier = Modifier
                            .padding(end = 8.dp)
                            .clip(CircleShape)
                            .size(30.dp),
                        painter = painterResource(id = R.drawable.astrobar),
                        contentDescription = null
                    )
                    Text(
                        "Astro bar",
                        modifier = Modifier,
                        color = Color.Black,
                    )
                }

            }, onClick = { /* Do something... */ })
            DropdownMenuItem(text = {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        "Add another account", modifier = Modifier.padding(end = 8.dp)
                    )
                    Icon(
                        Icons.Default.Add, contentDescription = "ADD"
                    )
                }
            }, onClick = {navController.navigate("logIn")})
        }
    }

}

@Composable
fun Label(name: String) {
    Text(
        name,
        modifier = Modifier.padding(top = 8.dp),
        fontSize = 16.sp,
        fontWeight = FontWeight.Bold,
        color = Color.Black,
    )
}

@Composable
fun LabelValue(name: String) {
    Text(
        name,
        modifier = Modifier.padding(start = 16.dp),
        fontSize = 16.sp,
        color = Color.Black,
    )
}