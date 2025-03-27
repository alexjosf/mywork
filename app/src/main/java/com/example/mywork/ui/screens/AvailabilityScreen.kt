package com.example.mywork.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun AvailabilityScreen(navController: NavController) {

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ){
                IconButton(
                    onClick = { navController.popBackStack() }
                ) {
                    Icon(
                        Icons.Default.Close, contentDescription = "CLOSE"
                    )
                }
                Text(
                    "Enter Availability",
                    fontSize = 16.sp,
                    color = Color.Black,
                    modifier = Modifier
                )
                IconButton(
                    onClick = { navController.popBackStack() }
                ) {
                    Icon(
                        Icons.Default.Check, contentDescription = "ADD"
                    )
                }
            }
            AvailabilityCard("Monday")
            AvailabilityCard("Tuesday")
            AvailabilityCard("Wednesday")
            AvailabilityCard("Thursday")
            AvailabilityCard("Friday")
            AvailabilityCard("Saturday")
            AvailabilityCard("Sunday")
        }
    }
}

@Composable
fun AvailabilityCard(day: String, placeholder: String = "00:00") {
    var from by remember { mutableStateOf("") }
    var to by remember { mutableStateOf("") }
    Row(
        modifier = Modifier
            .padding(16.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(Color(0xFFecfacf))
            .fillMaxWidth()
            .padding(8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "$day :",
            fontSize = 18.sp,
            color = Color.Black,
            modifier = Modifier.width(110.dp)
        )
        BasicTextField(
            value = from,
            onValueChange = {newText ->
                if (newText.length <= 5 && newText.all { it.isDigit() || it == ':' }) {
                    from = newText
                }},
            textStyle = androidx.compose.ui.text.TextStyle(
                fontSize = 18.sp,
                color = Color.Black
            ),
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(Color(0xFFecfacf))
                .padding(12.dp)
                .width(60.dp),
            maxLines = 1,
            decorationBox = { innerTextField ->
                if (from.isEmpty()) {
                    Text(placeholder, color = Color.Gray)
                }
                innerTextField()
            }
        )
        Text("-")
        BasicTextField(
            value = to,
            onValueChange = {newText ->
                if (newText.length <= 5 && newText.all { it.isDigit() || it == ':' }) {
                    to = newText
                }},
            textStyle = androidx.compose.ui.text.TextStyle(
                fontSize = 18.sp,
                color = Color.Black
            ),
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(Color(0xFFecfacf))
                .padding(12.dp)
                .width(60.dp),
            decorationBox = { innerTextField ->
                if (to.isEmpty()) {
                    Text(placeholder, color = Color.Gray)
                }
                innerTextField()
            }
        )
    }
}


