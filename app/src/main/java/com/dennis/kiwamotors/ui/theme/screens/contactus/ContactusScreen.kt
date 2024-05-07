package com.dennis.kiwamotors.ui.theme.screens.contactus

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun ContactusScreen(navController: NavHostController) {
    var email by remember { mutableStateOf(TextFieldValue("")) }
    var contact by remember { mutableStateOf(TextFieldValue("")) }
    var context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.DarkGray),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Contact Us",
            color = Color.Cyan,
            fontFamily = FontFamily.SansSerif,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
        )
        //  Text(text = "Phone: 0710720970")
        //  Text(text = "Email: dennoh540@gmail.com")
        Spacer(modifier = Modifier.height(20.dp))
        
            TextButton(onClick = {
                val phone="0710720970"
                val intent=Intent(Intent.ACTION_DIAL, Uri.fromParts("tel",phone,null))
                context.startActivity(intent)
            },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(Color.Black) ) {
                Text(
                    "Phone: 0710720970",
                    color = Color.White
                )

            }
        Spacer(modifier = Modifier.height(20.dp))
        
            TextButton(onClick = {
                val emailIntent=
                    Intent(Intent.ACTION_SENDTO,Uri.fromParts("mailto","dennoh540@gmail.com",null))
                emailIntent.putExtra(Intent.EXTRA_SUBJECT,"Subject")
                emailIntent.putExtra(Intent.EXTRA_TEXT,"Body")
                context.startActivity(Intent.createChooser(emailIntent,"Send email..."))
            },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(Color.Black)){
                Text("Email: dennoh540@gmail.com",
                    color = Color.White)
            }
        }
    }


@Preview
@Composable
fun Contactusprev() {
    ContactusScreen(rememberNavController())
}