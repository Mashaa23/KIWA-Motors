package com.dennis.kiwamotors.navigation

import android.os.Build
import android.window.SplashScreen
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.dennis.kiwamotors.ui.theme.screens.cart.CartScreen
import com.dennis.kiwamotors.ui.theme.screens.contactus.ContactusScreen
import com.dennis.kiwamotors.ui.theme.screens.home.HomeScreen
import com.dennis.kiwamotors.ui.theme.screens.login.LoginScreen
import com.dennis.kiwamotors.ui.theme.screens.payment.PaymentScreen
import com.dennis.kiwamotors.ui.theme.screens.products.AddProductsScreen
import com.dennis.kiwamotors.ui.theme.screens.products.AddProductsScreen
import com.dennis.kiwamotors.ui.theme.screens.products.ViewProductScreen
import com.dennis.kiwamotors.ui.theme.screens.signup.SignupScreen
import com.dennis.kiwamotors.ui.theme.screens.splash.splashscreen

@RequiresApi(Build.VERSION_CODES.N)
@Composable
fun AppNavHost(modifier: Modifier=Modifier,
               navController: NavHostController = rememberNavController(),
               startDestination:String= ROUTE_SPLASH) {

    NavHost(
        navController = navController,
        modifier = modifier,
        startDestination = startDestination
    ) {
        composable(ROUTE_HOME) {
            HomeScreen(navController)
        }
        composable(ROUTE_SPLASH) {
            splashscreen(navController)
        }
        composable(ROUTE_SIGNUP) {
            SignupScreen(navController)
        }
        composable(ROUTE_LOGIN) {
            LoginScreen(navController)
        }
        composable(ROUTE_CONTACTUS) {
            ContactusScreen(navController)
        }
        composable(ROUTE_CART){
            CartScreen(navController)
        }
        composable(ROUTE_PAYMENT){
            PaymentScreen(navController)
        }
        composable(ROUTE_VIEW_PRODUCT){
          ViewProductScreen(navController)
        }
        composable(ROUTE_ADD_PRODUCT){
            AddProductsScreen(navController)
        }


    }
    }