package com.example.mywork.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
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
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun LogInScreen(navController: NavController) {

    Scaffold (
        modifier = Modifier
            .fillMaxSize()
    ){ paddingValues ->
        Column (
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Text(
                "Enter Log In Credentials",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
            )
            Spacer(modifier = Modifier.height(32.dp))
            TextField("Login Id")
            Spacer(modifier = Modifier.height(16.dp))
            TextField("Password")
            Spacer(modifier = Modifier.height(16.dp))
            LoginButton(navController)
        }
    }
}

@Composable
fun TextField(placeholder : String){
    var text by remember { mutableStateOf("") }

    BasicTextField(
        value = text,
        onValueChange = { text = it },
        textStyle = androidx.compose.ui.text.TextStyle(
            fontSize = 18.sp,
            color = Color.Black
        ),
        modifier = Modifier
            .padding( horizontal = 16.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(Color(0xFFd3d3d3))
            .fillMaxWidth()
            .padding(16.dp),
        decorationBox = { innerTextField ->
            if (text.isEmpty()) {
                Text(placeholder, color = Color.Gray)
            }
            innerTextField()
        }
    )
}

@Composable
fun LoginButton(navController: NavController){
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
        onClick = {navController.navigate("bottomBar")}) {
        Text(
            "LOG IN",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
        )
    }
}