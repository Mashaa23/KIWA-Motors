package com.dennis.kiwamotors.ui.theme.screens.products

import android.annotation.SuppressLint
import android.app.ProgressDialog
import android.content.Context
import android.net.Uri
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.dennis.kiwamotors.data.AuthViewModel
import com.dennis.kiwamotors.model.Upload
import com.dennis.kiwamotors.navigation.ROUTE_LOGIN
import com.google.android.gms.analytics.ecommerce.Product
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.storage.FirebaseStorage

@SuppressLint("SuspiciousIndentation")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun  ViewProductScreen(navController: NavHostController) {
    fun ScrollContent(innerPadding: androidx.compose.foundation.layout.PaddingValues) {

    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var context = LocalContext.current


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

        Spacer(modifier = Modifier.height(10.dp))

        class productviewmodel(var navController: NavHostController, var context: Context) {
            var authRepository: AuthViewModel
            var progress: ProgressDialog

            init {
                authRepository = AuthViewModel(navController, context)
                if (!authRepository.isloggedin()) {
                    navController.navigate(ROUTE_LOGIN)
                }
                progress = ProgressDialog(context)
                progress.setTitle("Loading")
                progress.setMessage("Please wait...")
            }


            fun saveProduct(productName: String, productQuantity: String, productPrice: String) {
                var id = System.currentTimeMillis().toString()
                var productData =
                    com.dennis.kiwamotors.model.Product(
                        productName,
                        productQuantity,
                        productPrice,
                        id
                    )
                var productRef = FirebaseDatabase.getInstance().getReference()
                    .child("Products/$id")
                progress.show()
                productRef.setValue(productData).addOnCompleteListener {
                    progress.dismiss()
                    if (it.isSuccessful) {
                        Toast.makeText(context, "Saving successful", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(
                            context,
                            "ERROR: ${it.exception!!.message}",
                            Toast.LENGTH_SHORT
                        )
                            .show()
                    }
                }
            }

            fun viewProducts(
                product: MutableState<Product>,
                products: SnapshotStateList<Product>
            ): SnapshotStateList<Product> {
                var ref = FirebaseDatabase.getInstance().getReference().child("Products")

                progress.show()
                ref.addValueEventListener(object : ValueEventListener {
                    override fun onDataChange(snapshot: DataSnapshot) {
                        progress.dismiss()
                        products.clear()
                        for (snap in snapshot.children) {
                            val value = snap.getValue(Product::class.java)
                            product.value = value!!
                            products.add(value)
                        }
                    }

                    override fun onCancelled(error: DatabaseError) {
                        Toast.makeText(context, error.message, Toast.LENGTH_SHORT).show()
                    }
                })
                return products
            }

            fun deleteProduct(id: String) {
                var delRef = FirebaseDatabase.getInstance().getReference()
                    .child("Products/$id")
                progress.show()
                delRef.removeValue().addOnCompleteListener {
                    progress.dismiss()
                    if (it.isSuccessful) {
                        Toast.makeText(context, "Product deleted", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(context, it.exception!!.message, Toast.LENGTH_SHORT).show()
                    }
                }
            }

            fun updateProduct(name: String, quantity: String, price: String, id: String) {
                var updateRef = FirebaseDatabase.getInstance().getReference()
                    .child("Products/$id")
                progress.show()
                var updateData = com.dennis.kiwamotors.model.Product(name, quantity, price, id)
                updateRef.setValue(updateData).addOnCompleteListener {
                    progress.dismiss()
                    if (it.isSuccessful) {
                        Toast.makeText(context, "Update successful", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(context, it.exception!!.message, Toast.LENGTH_SHORT).show()
                    }
                }
            }

            fun saveProductWithImage(
                productName: String,
                productQuantity: String,
                productPrice: String,
                filePath: Uri
            ) {
                var id = System.currentTimeMillis().toString()
                var storageReference =
                    FirebaseStorage.getInstance().getReference().child("Uploads/$id")
                progress.show()

                storageReference.putFile(filePath).addOnCompleteListener {
                    progress.dismiss()
                    if (it.isSuccessful) {
                        // Proceed to store other data into the db
                        storageReference.downloadUrl.addOnSuccessListener {
                            var imageUrl = it.toString()
                            var houseData = Upload(
                                productName, productQuantity,
                                productPrice, imageUrl, id
                            )
                            var dbRef = FirebaseDatabase.getInstance()
                                .getReference().child("Uploads/$id")
                            dbRef.setValue(houseData)
                            Toast.makeText(context, "Upload successful", Toast.LENGTH_SHORT).show()
                        }
                    } else {
                        Toast.makeText(context, it.exception!!.message, Toast.LENGTH_SHORT).show()
                    }
                }
            }


            fun viewUploads(
                upload: MutableState<Upload>,
                uploads: SnapshotStateList<Upload>
            ): SnapshotStateList<Upload> {
                var ref = FirebaseDatabase.getInstance().getReference().child("Uploads")

                progress.show()
                ref.addValueEventListener(object : ValueEventListener {
                    override fun onDataChange(snapshot: DataSnapshot) {
                        progress.dismiss()
                        uploads.clear()
                        for (snap in snapshot.children) {
                            val value = snap.getValue(Upload::class.java)
                            upload.value = value!!
                            uploads.add(value)
                        }
                    }

                    override fun onCancelled(error: DatabaseError) {
                        Toast.makeText(context, error.message, Toast.LENGTH_SHORT).show()
                    }
                })
                return uploads
            }


        }
    }
}

@Preview
@Composable
fun ViewProductprev() {
    ViewProductScreen(rememberNavController())
}
