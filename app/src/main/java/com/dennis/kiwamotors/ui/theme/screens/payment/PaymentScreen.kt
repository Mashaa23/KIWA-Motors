package com.dennis.kiwamotors.ui.theme.screens.payment

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
fun PaymentScreen(navController: NavHostController) {
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.DarkGray),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "I have been waiting for you sir/madam",
            color = Color.Cyan,
            fontFamily = FontFamily.SansSerif,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
        )


        Spacer(modifier = Modifier.height(20.dp))

        OutlinedButton(
            onClick = {
                val simToolKitLaunchIntent =
                    context.packageManager.getLaunchIntentForPackage("com.android.stk")
                simToolKitLaunchIntent?.let { context.startActivity(it) }
            },
            modifier = Modifier.width(200.dp),
            colors = ButtonDefaults.buttonColors(Color.Cyan)
        ) {


        Text(
            "SIM ToolKit",
            fontSize = 10.sp,
            fontFamily = FontFamily.SansSerif,
            color = Color.Black,
            fontWeight = FontWeight.Black,
        )
    }
    }
}

@Preview
@Composable
fun Paymentprev() {
    PaymentScreen(rememberNavController())
}