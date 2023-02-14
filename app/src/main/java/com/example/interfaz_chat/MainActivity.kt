package com.example.interfaz_chat


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MyLazyColumn()
                }
            }
        }
    }



// https://www.youtube.com/watch?v=_JO4Xxx0vb0





@Preview
@Composable
fun MyLazyColumn() {

    Text(text = stringResource(id = R.string.app_name))
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = stringResource(id = R.string.app_name)) })
        },


        ){
        /* scaffold pasa como parámetro de la lambda content los valores de padding que genera
        con los elementos que añade alrededor de este contenido */

        LazyColumn(
            Modifier
                .fillMaxSize()
                .padding(it),
            // state = rememberLazyListState(),  //
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            items(messages) { message -> MyComponent(message) }
        }


    }

}

enum class User {LOCAL, REMOTE}

@Composable
fun MyComponent(message: MyMessage) {

    val conditionalBackgroundColor = if (message.sender == User.LOCAL) {
        Color.Cyan
    } else {
        Color.LightGray
    }



    val conditionalhorizontalAlignment = if (message.sender==User.LOCAL) Alignment.Start else Alignment.End

    val conditionalCornerShapetopStart = if (message.sender==User.LOCAL) 20.dp else 20.dp
    val conditionalCornerShapetopEnd = if (message.sender==User.LOCAL) 20.dp else 20.dp
    val conditionalCornerShapebottomEnd = if (message.sender==User.LOCAL) 20.dp else 0.dp
    val conditionalCornerShapebottomStart = if (message.sender==User.LOCAL) 0.dp else 20.dp


    Column(Modifier.fillMaxWidth()) {

        Card(
            shape = RoundedCornerShape(
                topStart = conditionalCornerShapetopStart,
                topEnd = conditionalCornerShapetopEnd,
                bottomEnd = conditionalCornerShapebottomEnd,
                bottomStart = conditionalCornerShapebottomStart,
            ),
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth(.9f)
                .align(conditionalhorizontalAlignment),
            backgroundColor = conditionalBackgroundColor
        )

        {
            Text(
                message.body,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
            )
            }
    }




}

val formatter: DateTimeFormatter =
    DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")

data class MyMessage(val sender: User, val body: String, val timestamp: LocalDateTime )

val messages: List<MyMessage> = listOf(
    MyMessage(
        sender= User.LOCAL,
        body = "Hola, ¿has oido hablar de la programación reactiva en Android?",
        LocalDateTime.parse("01/01/2021 10:00", formatter)),
    MyMessage(
        sender= User.REMOTE,
        body = "You can think of Modifiers as implementations of the decorator pattern",
        LocalDateTime.parse("01/01/2021 10:05", formatter)),
    MyMessage(
        sender= User.LOCAL,
        body = "You can think of Modifiers as implementations of the decorator pattern",
        LocalDateTime.parse("01/01/2021 10:10", formatter)),
    MyMessage(
        sender= User.REMOTE,
        body = "You can think of Modifiers as implementations of the decorator pattern",
        LocalDateTime.parse("01/01/2021 10:20", formatter)),
    MyMessage(
        sender= User.LOCAL,
        body = "You can think of Modifiers as implementations of the decorator pattern",
        LocalDateTime.parse("01/01/2021 10:30", formatter)),
    MyMessage(
        sender= User.REMOTE,
        body = "You can think of Modifiers as implementations of the decorator pattern",
        LocalDateTime.parse("01/01/2021 10:40", formatter)),
    MyMessage(
        sender= User.LOCAL,
        body = "You can think of Modifiers as implementations of the decorator pattern",
        LocalDateTime.parse("01/01/2021 10:50", formatter)),
    MyMessage(
        sender= User.REMOTE,
        body = "You can think of Modifiers as implementations of the decorator pattern",
        LocalDateTime.parse("01/01/2021 10:55", formatter)),
    MyMessage(
        sender= User.LOCAL,
        body = "You can think of Modifiers as implementations of the decorator pattern",
        LocalDateTime.parse("01/01/2021 10:56", formatter)),
    MyMessage(
        sender= User.REMOTE,
        body = "You can think of Modifiers as implementations of the decorator pattern",
        LocalDateTime.parse("01/01/2021 10:57", formatter)),
    MyMessage(
        sender= User.LOCAL,
        body = "You can think of Modifiers as implementations of the decorator pattern",
        LocalDateTime.parse("01/01/2021 10:58", formatter)),
    MyMessage(
        sender= User.REMOTE,
        body = "You can think of Modifiers as implementations of the decorator pattern",
        LocalDateTime.parse("01/01/2021 10:59", formatter)),
)