package com.dennis.kiwamotors.ui.theme.screens.login

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
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
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.dennis.kiwamotors.data.AuthViewModel
import com.dennis.kiwamotors.navigation.ROUTE_SIGNUP

@Composable
fun LoginScreen(navController: NavHostController) {
    var email by remember { mutableStateOf(TextFieldValue("")) }
    var pass by remember { mutableStateOf(TextFieldValue("")) }
    var context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.DarkGray),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "KIWA MOTORS",
            fontSize = 30.sp,
            fontFamily = FontFamily.SansSerif,
            color = Color.Cyan,
            fontWeight = FontWeight.Bold,
        )


        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "Login",
            fontSize = 30.sp,
            fontFamily = FontFamily.SansSerif,
            color = Color.Cyan,
            fontWeight = FontWeight.Bold,
        )
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            leadingIcon = { Icon(imageVector = Icons.Default.Email, contentDescription = "")},
            label = {
                Text(
                    text = "Enter Email",
                    color = Color.White
                )
            },

            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),

            )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = pass,
            onValueChange = { pass = it },
            leadingIcon = { Icon(imageVector = Icons.Default.Lock, contentDescription = "")},
            label = {
                Text(
                    text = "Enter Password",
                    color = Color.White
                )
            },
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = {
             val mylogin= AuthViewModel(navController, context )
            mylogin.login(email.text.trim(),pass.text.trim())
        }, modifier = Modifier.fillMaxWidth()) {
            Text(text = "Log In")
        }
        Spacer(modifier = Modifier.height(20.dp))

        Text(text = "Don't have an account")

        TextButton(
            onClick = {
                navController.navigate(ROUTE_SIGNUP)
            },
            modifier = Modifier.fillMaxWidth(),
        ) {
            Text(
                "Click to Register",
                color = Color.White
            )

        }

    }
}

@Preview
@Composable
fun Loginprev() {
    LoginScreen(rememberNavController())
}