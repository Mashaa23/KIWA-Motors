package com.dennis.kiwamotors.ui.theme.screens.splash

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.dennis.kiwamotors.R
import com.dennis.kiwamotors.navigation.ROUTE_LOGIN
import kotlinx.coroutines.delay

@Composable
fun splashscreen(navController: NavHostController) {
    val scale = remember {
        Animatable(0f)
    }

    // AnimationEffect
    LaunchedEffect(key1 = true) {
        scale.animateTo(
            targetValue = 0.7f,
            animationSpec = tween(
                durationMillis = 800,
                easing = {
                    OvershootInterpolator(4f).getInterpolation(it)
                })
        )
        delay(3000L)
        navController.navigate(ROUTE_LOGIN)
    }

    // Image
    Box(contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()) {
        Image(painter = painterResource(id = R.drawable.bikesplash),
            contentDescription = "Logo",
            modifier = Modifier
                .size(300.dp)
            .scale(scale.value))
    }
}

@Preview
@Composable
private fun SplashScreen() {
    splashscreen(navController = rememberNavController())
}
