package com.example.designa1

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.material3.Card
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.text.style.TextOverflow
import com.example.designa1.ui.theme.DesignTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DesignTheme {

                Surface() {
                    TwoMessageCardsWithTopBar()
                 }
            }
        }
    }
}
@Composable
fun TwoMessageCardsWithTopBar() {
    LazyColumn {
        item {
            SmallTopAppBarExample()
        }
        items(2) { index ->
            MessageCard(Message("Android", "Jetpack Compose"))
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)

@Composable
fun SmallTopAppBarExample() {
    TopAppBar(
        modifier = Modifier.fillMaxWidth(),
        title = {
            Text("Small Top App Bar")
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            titleContentColor = MaterialTheme.colorScheme.primary,)
    )
}



data class Message(val author: String, val body: String)

@Composable
fun MessageCard(msg: Message) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Row(modifier = Modifier.padding(all = 40.dp)) {
            Image(
                painter = painterResource(R.drawable.ic_launcher_background),
                contentDescription = null,
                modifier = Modifier
                    .size(70.dp)
                    .clip(CircleShape)
                    .border(1.5.dp, MaterialTheme.colorScheme.primary, CircleShape)
            )
            Spacer(modifier = Modifier.width(8.dp))

            Column {
                Text(
                    text = msg.author,
                    color = MaterialTheme.colorScheme.secondary,
                    style = MaterialTheme.typography.titleSmall
                )

                Spacer(modifier = Modifier.height(6.dp))

                Surface(shape = MaterialTheme.shapes.medium, shadowElevation = 3.dp) {
                    Text(
                        text = msg.body,
                        modifier = Modifier.padding(all = 10.dp),
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }
            Button(
                onClick = {
                },
                modifier = Modifier
                    .padding(top = 16.dp, bottom = 16.dp,start = 50.dp)
                    .size(70.dp)
            ) {
                Text(text = "Click me", color = MaterialTheme.colorScheme.primary)
            }
        }


    }
}

@Preview(name = "Light Mode")
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "Dark Mode"
)
@Composable
fun PreviewMessageCard() {
    DesignTheme {


                TwoMessageCardsWithTopBar()


    }
}