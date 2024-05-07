package com.dennis.kiwamotors.ui.theme.screens.signup

import androidx.compose.foundation.Image
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
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Button
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
import androidx.compose.ui.res.painterResource
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
import com.dennis.kiwamotors.R
import com.dennis.kiwamotors.data.AuthViewModel
import com.dennis.kiwamotors.navigation.ROUTE_LOGIN
import com.dennis.kiwamotors.navigation.ROUTE_SIGNUP

@Composable
fun SignupScreen(navController: NavHostController) {
    var name by remember { mutableStateOf("")}
    var contact by remember { mutableStateOf("")}
    var email by remember { mutableStateOf(TextFieldValue("")) }
    var pass by remember { mutableStateOf(TextFieldValue("")) }
    var confirmpass by remember { mutableStateOf(TextFieldValue("")) }
    var context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.DarkGray),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(text = "Create an account",
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.SansSerif,
            fontSize = 30.sp,
            color = Color.Cyan
        )

        Spacer(modifier = Modifier.height(10.dp))

       Image(painter = painterResource(id = R.drawable.bikesplash),
           contentDescription ="",
           modifier = Modifier
               .height(100.dp)
               .width(200.dp))

        Spacer(modifier = Modifier.height(10.dp))
        OutlinedTextField(value = name,
            onValueChange = {name=it},
            leadingIcon = { Icon(imageVector = Icons.Default.Person, contentDescription = "") },
            label = { Text(text = " Username",
                color = Color.White,
                fontSize = 20.sp)
            },
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),

            )

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(value = contact,
            onValueChange = {contact=it},
            leadingIcon = { Icon(imageVector = Icons.Default.Phone, contentDescription = "") },
            label = { Text(text = " Contact",
                color = Color.White,
                fontSize = 20.sp)
            },
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),

            )

        Spacer(modifier = Modifier.height(10.dp))

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
        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            value = pass,
            onValueChange = { pass = it },
            leadingIcon = { Icon(imageVector = Icons.Default.Lock, contentDescription = "")},
            label = {
                Text(
                    text = "Enter password",
                    color = Color.White
                )
            },
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )
        Spacer(modifier = Modifier.height(10.dp))
        OutlinedTextField(
            value = confirmpass,
            onValueChange = {
                confirmpass = it },
            leadingIcon = { Icon(imageVector = Icons.Default.CheckCircle, contentDescription = "")},
            label = {
                Text(
                    text = "Enter Confirm Pass",
                    color = Color.White
                )
            },

            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )
        Spacer(modifier = Modifier.height(10.dp))


        Button(onClick = {
            val myregister= AuthViewModel(navController,context)
            myregister.signup(email.text.trim(),pass.text.trim(),confirmpass.text.trim())


        }, modifier = Modifier.fillMaxWidth()) {
            Text(text = "Register ")
        }
        Spacer(modifier = Modifier.height(10.dp))

       // Button(onClick = {
         //   navController.navigate(ROUTE_LOGIN)
        //}, modifier = Modifier.fillMaxWidth()) {
          //  Text(text = "Have an Account? Click to Login")

        Text(text = "Don't have an account")

        TextButton(
            onClick = {
                navController.navigate(ROUTE_LOGIN)
            },
            modifier = Modifier.fillMaxWidth(),
        ) {
            Text(
                "Click to Login",
                color = Color.White
            )

        }


    }
}



@Preview
@Composable
fun signup() {
    SignupScreen(rememberNavController())
}