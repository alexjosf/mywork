package com.example.mywork

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mywork.ui.theme.MyworkTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyworkTheme {
                Greeting()
            }
        }
    }
}

@Composable
fun Greeting() {
    var selectedItem by remember { mutableIntStateOf(0) }
    val items = listOf(Icons.Default.Home, Icons.Default.DateRange, Icons.Default.Person)
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .padding()
            .navigationBarsPadding(), bottomBar = {
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
            1 -> HomeScreen(Modifier.padding(paddingValues))
            0 -> ScheduleScreen(Modifier.padding(paddingValues))
            2 -> AccountScreen(Modifier.padding(paddingValues))
        }
    }
}

@Composable
fun HomeScreen(modifier: Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Row(
            modifier = Modifier
                .background(Color(0xFFecfacf))
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Previous Week"
            )
            Text(
                "22/03/2025 - 28/02/2025",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
            )
            Icon(
                Icons.AutoMirrored.Filled.ArrowForward, contentDescription = "Next Week"
            )
        }
        LazyColumn(
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            item { DayCard("Mon", "22") }
            item { DayCard("Tue", "23") }
            item { DayCard("Wed", "24") }
            item { DayCard("Thu", "25") }
            item { DayCard("Fri", "26") }
            item { DayCard("Sat", "27") }
            item { DayCard("Sun", "28") }
        }
    }
}

@Composable
fun DayCard(day: String, date: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .background(
                Color(0xFFecfacf),
                RoundedCornerShape(16.dp)
            ),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .wrapContentSize()
        ) {
            Text(
                day,
                modifier = Modifier,
                color = Color.Black,
                fontSize = 16.sp,
            )
            Text(
                date,
                modifier = Modifier,
                color = Color.Black,
                fontSize = 16.sp,
            )
        }
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(
                    "9:00 - 17:00",
                    modifier = Modifier,
                    color = Color.Black,
                    fontSize = 16.sp,
                )
                Text(
                    "HMR Clerk",
                    modifier = Modifier,
                    color = Color.Black,
                    fontSize = 16.sp,
                )
            }
            Text(
                "8.00 hr",
                modifier = Modifier,
                color = Color.Black,
                fontSize = 16.sp,
            )
        }
    }
}

@Composable
fun ScheduleScreen(modifier: Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.Start,
    ) {
        Row(
            modifier = Modifier
                .background(Color(0xFFecfacf))
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Previous Week"
            )
            Text(
                "22/03/2025 - 28/02/2025",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
            )
            Icon(
                Icons.AutoMirrored.Filled.ArrowForward, contentDescription = "Next Week"
            )
        }
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            AdaptiveGrid()
        }
    }
}

@Composable
fun AdaptiveGrid() {
    val data: List<List<String>> = listOf(
        listOf("Alice Joseph", "9:00 - 17:00", "9:00 - 17:00", "9:00 - 17:00", "9:00 - 17:00", "9:00 - 17:00", "9:00 - 17:00", "9:00 - 17:00"),
        listOf("Bobby Chem", "9:00 - 17:00", "9:00 - 17:00", "9:00 - 17:00", "9:00 - 17:00", "9:00 - 17:00", "9:00 - 17:00", "9:00 - 17:00"),
        listOf("Charlie Puth", "9:00 - 17:00", "9:00 - 17:00", "9:00 - 17:00", "9:00 - 17:00", "9:00 - 17:00", "9:00 - 17:00", "9:00 - 17:00"),
        listOf("David John", "9:00 - 17:00", "9:00 - 17:00", "9:00 - 17:00", "9:00 - 17:00", "9:00 - 17:00", "9:00 - 17:00", "9:00 - 17:00"),
        listOf("Eve Smith", "9:00 - 17:00", "9:00 - 17:00", "9:00 - 17:00", "9:00 - 17:00", "9:00 - 17:00", "9:00 - 17:00", "9:00 - 17:00"),
        listOf("Frank Brown", "9:00 - 17:00", "9:00 - 17:00", "9:00 - 17:00", "9:00 - 17:00", "9:00 - 17:00", "9:00 - 17:00", "9:00 - 17:00"),
        listOf("Grace Lee", "9:00 - 17:00", "9:00 - 17:00", "9:00 - 17:00", "9:00 - 17:00", "9:00 - 17:00", "9:00 - 17:00", "9:00 - 17:00"),
    )

    LazyHorizontalGrid(
        rows = GridCells.Fixed(8), // Columns adjust based on screen width
        modifier = Modifier.fillMaxSize(),
        horizontalArrangement = Arrangement.Center,
        verticalArrangement = Arrangement.Center
    ) {
        item(span = { GridItemSpan(8) }) {
            Column(
            ) {
                NameCard("Employees")
                DayDateCard("Mon", "22")
                DayDateCard("Tue", "23")
                DayDateCard("Wed", "24")
                DayDateCard("Thu", "25")
                DayDateCard("Fri", "26")
                DayDateCard("Sat", "27")
                DayDateCard("Sun", "28")
            }
        }
        item (span = { GridItemSpan(8) }){
            Row(
            ) {
                data.forEach { row ->
                    Column (
                    ){
                        row.forEach { cell ->
                            if(row.first() == cell){
                                NameCard(cell)
                            }
                            else{
                                ShiftCard(cell, "Clerk")
                            }
                        }
                    }
                }
            }
        }
    }
}


@Composable
fun ShiftCard(time: String, position: String) {
    Column(
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .background(Color(0xFFecfacf))
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .width(100.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            time,
            modifier = Modifier,
            color = Color.Black,
            fontSize = 16.sp,
        )
            Text(
                position,
                modifier = Modifier,
                color = Color.Black,
                fontSize = 16.sp,
            )
    }
}

@Composable
fun DayDateCard(day: String, date: String) {
    Column(
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .background(Color(0xFFffe645))
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .width(100.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            day,
            modifier = Modifier,
            color = Color.Black,
            fontSize = 16.sp,
        )
        Text(
            date,
            modifier = Modifier,
            color = Color.Black,
            fontSize = 16.sp,
        )
    }
}

@Composable
fun NameCard(name: String) {
    Column(
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .background(Color(0xFFf7ad52))
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .width(100.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            name,
            modifier = Modifier,
            color = Color.Black,
            fontSize = 16.sp,
        )
    }
}


@Composable
fun AccountScreen(modifier: Modifier) {
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
            OrganizationSelectorMenu()
        }
        LazyColumn(
            modifier = Modifier
                .weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                DataDetails()
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
fun DataDetails() {
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
        Icon(
            Icons.AutoMirrored.Filled.ArrowForward, contentDescription = "ADD"
        )
    }
}

@Composable
fun OrganizationSelectorMenu() {
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
            }, onClick = { /* Do something... */ })
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

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyworkTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            Column(
                modifier = Modifier.padding(innerPadding)
            ) {
                ScheduleScreen(Modifier.padding(innerPadding))
            }
        }
    }
}