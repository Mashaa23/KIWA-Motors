package com.dennis.kiwamotors.ui.theme.screens.cart

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.dennis.kiwamotors.navigation.ROUTE_PAYMENT


@RequiresApi(Build.VERSION_CODES.N)
@Composable
fun CartScreen(navController: NavHostController) {
    //cartItems: List<CartItem>, onCheckout: () -> Unit, onRemoveItem: (CartItem) -> Unit, onQuantityChange: (CartItem, Int) -> Unit) {
    val context = LocalContext.current
    Column {
        Text(
            "Your Cart",
            fontWeight = FontWeight.Bold,
            color = Color.Cyan,
            fontSize = 20.sp,
        )
        Spacer(modifier = Modifier.height(16.dp))

        // Display cart items with actions
        //  cartItems.forEach { item ->
        //    CartItemRow(item, onRemoveItem, onQuantityChange)

        Spacer(modifier = Modifier.height(20.dp))


        // Checkout button
        OutlinedButton(
            onClick = {
                navController.navigate(ROUTE_PAYMENT)
            },
            modifier = Modifier.width(200.dp),
            colors = ButtonDefaults.buttonColors(Color.Cyan)
        ) {


        Text(
            "Checkout",
            fontSize = 20.sp,
            fontWeight = FontWeight.Black,
            fontFamily = FontFamily.SansSerif,
            color= Color.Black
        )

    }
    }
}


        @Composable
        fun
                CartItemRow(
         //   cartItem: CartItem,
           // onRemoveItem: (CartItem) -> Unit,
            //onQuantityChange: (CartItem, Int) -> Unit
        ) {
            var quantity by remember { mutableStateOf(1) }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
        //        Text("${cartItem.name} - $${cartItem.price}")
                Spacer(modifier = Modifier
                    .height(10.dp))
                // Quantity adjuster
                Row {
          //          IconButton(onClick = { if (quantity > 1) onQuantityChange(cartItem, -1) }) {
                        Icon(
                            Icons.Default.KeyboardArrowDown,
                            contentDescription = "Decrease quantity"
                        )
                    }
                    Text("$quantity",
                        modifier = Modifier
                        .align(Alignment.CenterVertically))
            //        IconButton(onClick = { onQuantityChange(cartItem, 1) }) {
                        Icon(
                            Icons.Default.KeyboardArrowUp,
                            contentDescription = "Increase quantity"
                        )
                    }
                }
                // Remove item button
              //  IconButton(onClick = { onRemoveItem(cartItem) }) {
                //    Icon(Icons.Default.Delete, contentDescription = "Remove item")
                //}
            //}
        //}
    //}
@RequiresApi(Build.VERSION_CODES.N)
@Preview
@Composable
fun Cartprev() {
        CartScreen(navController = rememberNavController())
    }

