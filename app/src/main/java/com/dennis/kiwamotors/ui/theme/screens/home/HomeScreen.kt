package com.dennis.kiwamotors.ui.theme.screens.home

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.dennis.kiwamotors.data.productviewmodel
import com.dennis.kiwamotors.navigation.ROUTE_ADD_PRODUCT
import com.dennis.kiwamotors.navigation.ROUTE_VIEW_PRODUCT


//@SuppressLint("SuspiciousIndentation")
@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun  HomeScreen(navController: NavHostController) {
    @Composable
    fun ScrollContent(innerPadding: androidx.compose.foundation.layout.PaddingValues) {


        //Column(
          //  modifier = Modifier
            //    .fillMaxSize()
              //  .background(Color.White),
            //horizontalAlignment = Alignment.CenterHorizontally
        //) {
           // var context = LocalContext.current


            //@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
            //@Composable
            //fun CenterAlignedTopAppBar(
            //colors: Any,
            //title: @Composable () -> Unit,
            //navigationIcon: @Composable Any,
            //actions: @Composable () -> Unit,
            //scrollBehavior: TopAppBarScrollBehavior
            //  ) {

            val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())
            Scaffold(
                modifier = Modifier
                    .nestedScroll(scrollBehavior.nestedScrollConnection),
                topBar = {
                    CenterAlignedTopAppBar(
                        colors = TopAppBarDefaults.topAppBarColors(
                            containerColor = MaterialTheme.colorScheme.primaryContainer,
                            titleContentColor = MaterialTheme.colorScheme.primary,
                        ),
                        title = {
                            Text(
                                "KIWA MOTORS",
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis
                            )
                        },
                        navigationIcon = {
                            IconButton(onClick = { /*TODO*/ }) {
                                Icon(
                                    imageVector = Icons.Filled.ArrowBack,
                                    contentDescription = ""
                                )

                            }
                        },
                        actions = {
                            IconButton(onClick = { /*TODO*/ }) {
                                Icon(
                                    imageVector = Icons.Filled.Search,
                                    contentDescription = ""
                                )

                            }



                            IconButton(onClick = { /*TODO*/ }) {
                                Icon(
                                    imageVector = Icons.Filled.Menu,
                                    contentDescription = ""
                                )

                            }
                        },

                        scrollBehavior = scrollBehavior,
                    )


                },
            ) { innerPadding -> ScrollContent(innerPadding) }
        }


        @Composable
        fun HomeScreen(navController: NavHostController) {
            Column(
                modifier = Modifier
                .fillMaxSize()
                   .background(Color.DarkGray),
                 horizontalAlignment = Alignment.CenterHorizontally
            ) {
                var context = LocalContext.current
                //var productdata= productviewmodel(navController,context)

                Text(
                    text = "Welcome to Home page",
                    color = Color.Cyan,
                    fontFamily = FontFamily.Cursive,
                    fontSize = 30.sp,
                )
                Spacer(modifier = Modifier.height(100.dp))

                Button(onClick = {
                    navController.navigate(ROUTE_ADD_PRODUCT)
                }, modifier = Modifier.fillMaxWidth()) {
                    Text(text = "Add Product")
                }
                Spacer(modifier = Modifier.height(100.dp))

                Button(onClick = {
                    navController.navigate(ROUTE_VIEW_PRODUCT)
                }, modifier = Modifier.fillMaxWidth()) {
                    Text(text = "View Product")
                }
                Spacer(modifier = Modifier.height(100.dp))

            }

        }




@Preview
@Composable
fun Homeprev() {
    HomeScreen(rememberNavController())
}


// inafaa kukuwa na search bar-inafaa kukuletea the specific item,
// button ya contact us-inakupeleka contact screen,
// button ya cart-cartscreen, na background colour ikuwe white.