package com.geovannycode.jetpackcompose.ecoeats.presentation.reset_password

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.geovannycode.jetpackcompose.ecoeats.R
import com.geovannycode.jetpackcompose.ecoeats.presentation.common.ButtonBasic
import com.geovannycode.jetpackcompose.ecoeats.presentation.common.ImageBasic
import com.geovannycode.jetpackcompose.ecoeats.presentation.common.OutlinedTextFieldBasic
import com.geovannycode.jetpackcompose.ecoeats.presentation.common.SpacerComponent
import com.geovannycode.jetpackcompose.ecoeats.presentation.common.TextBasic
import com.geovannycode.jetpackcompose.ecoeats.ui.theme.Primary

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ResetPasswordScreen(
    email: String,
    otp: String,
    viewModel: ResetPasswordViewModel = hiltViewModel(),
    onBack: () -> Unit,
    onNavigateToLogin: () -> Unit
) {
    val state = viewModel.state
    val context = LocalContext.current

    LaunchedEffect(key1 = state.success, key2 = state.error) {
        if (state.success != null) {
            Toast.makeText(context, "Contraseña restablecida exitosamente", Toast.LENGTH_SHORT).show()
            onNavigateToLogin()
        }
        if (state.error != null) {
            Toast.makeText(context, state.error, Toast.LENGTH_SHORT).show()
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("") },
                navigationIcon = {
                    IconButton(onClick = { onBack() }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "Volver"
                        )
                    }
                }
            )
        }
    ) { paddingValues ->
        if (state.isLoading) {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                ImageBasic(
                    image = R.drawable.ecoeats_logo,
                    description = "Logo",
                    modifier = Modifier.size(120.dp)
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 24.dp, end = 24.dp, top = 32.dp)
            ) {
                TextBasic(
                    text = "Nueva Contraseña",
                    style = TextStyle(
                        color = Primary,
                        fontSize = 28.sp,
                        fontWeight = FontWeight.Bold
                    )
                )
                SpacerComponent(modifier = Modifier.height(8.dp))
                TextBasic(
                    text = "Ingresa tu nueva contraseña",
                    style = TextStyle(fontSize = 14.sp)
                )
                SpacerComponent(modifier = Modifier.height(24.dp))
                OutlinedTextFieldBasic(
                    text = viewModel.newPassword,
                    onValueChange = { viewModel.newPassword = it },
                    textLabel = "Nueva Contraseña",
                    keyboardOptions = KeyboardOptions(
                        keyboardType = if (viewModel.passwordVisualTransformation) KeyboardType.Text else KeyboardType.Password,
                        imeAction = ImeAction.Next
                    ),
                    keyboardActions = KeyboardActions(onNext = {}),
                    trailingIcon = {
                        val image = if (viewModel.passwordVisualTransformation) Icons.Filled.Visibility else Icons.Filled.VisibilityOff
                        IconButton(
                            onClick = { viewModel.passwordVisualTransformation = !viewModel.passwordVisualTransformation }
                        ) {
                            Icon(imageVector = image, contentDescription = "Toggle password")
                        }
                    },
                    visualTransformation = if (viewModel.passwordVisualTransformation) VisualTransformation.None else PasswordVisualTransformation(),
                    isError = false
                )
                SpacerComponent(modifier = Modifier.height(8.dp))
                OutlinedTextFieldBasic(
                    text = viewModel.confirmPassword,
                    onValueChange = { viewModel.confirmPassword = it },
                    textLabel = "Confirmar Contraseña",
                    keyboardOptions = KeyboardOptions(
                        keyboardType = if (viewModel.passwordVisualTransformation) KeyboardType.Text else KeyboardType.Password,
                        imeAction = ImeAction.Done
                    ),
                    keyboardActions = KeyboardActions(onDone = {}),
                    trailingIcon = {
                        val image = if (viewModel.passwordVisualTransformation) Icons.Filled.Visibility else Icons.Filled.VisibilityOff
                        IconButton(
                            onClick = { viewModel.passwordVisualTransformation = !viewModel.passwordVisualTransformation }
                        ) {
                            Icon(imageVector = image, contentDescription = "Toggle password")
                        }
                    },
                    visualTransformation = if (viewModel.passwordVisualTransformation) VisualTransformation.None else PasswordVisualTransformation(),
                    isError = false
                )
                SpacerComponent(modifier = Modifier.height(32.dp))
                ButtonBasic(
                    text = "Restablecer Contraseña",
                    onClick = { viewModel.resetPassword(email, otp) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                )
            }
        }
    }
}
