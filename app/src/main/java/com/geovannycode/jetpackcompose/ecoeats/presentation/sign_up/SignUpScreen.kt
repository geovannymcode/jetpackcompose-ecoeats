package com.geovannycode.jetpackcompose.ecoeats.presentation.sign_up

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.Text
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
import com.geovannycode.jetpackcompose.ecoeats.ui.theme.Secundary

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUpScreen(
    viewModel: SignUpViewModel = hiltViewModel(),
    onNavigateToLogin: () -> Unit
) {
    val state = viewModel.state
    val context = LocalContext.current

    LaunchedEffect(key1 = state.success, key2 = state.error) {
        if (state.success != null) {
            Toast.makeText(context, state.success, Toast.LENGTH_SHORT).show()
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
                    IconButton(onClick = { onNavigateToLogin() }) {
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
                .verticalScroll(rememberScrollState())
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                ImageBasic(
                    image = R.drawable.ecoeats_logo,
                    description = "Logo",
                    modifier = Modifier.size(80.dp)
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 24.dp, end = 24.dp, top = 16.dp)
            ) {
                TextBasic(
                    text = "Crear Cuenta",
                    style = TextStyle(
                        color = Primary,
                        fontSize = 28.sp,
                        fontWeight = FontWeight.Bold
                    )
                )
                SpacerComponent(modifier = Modifier.height(16.dp))
                OutlinedTextFieldBasic(
                    text = viewModel.formState.numeroDocumento,
                    onValueChange = { viewModel.onEvent(SignUpFormEvent.NumeroDocumentoChange(it)) },
                    textLabel = "Número de Documento",
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Number,
                        imeAction = ImeAction.Next
                    ),
                    keyboardActions = KeyboardActions(onNext = {}),
                    isError = false
                )
                SpacerComponent(modifier = Modifier.height(8.dp))
                OutlinedTextFieldBasic(
                    text = viewModel.formState.nombres,
                    onValueChange = { viewModel.onEvent(SignUpFormEvent.NombresChange(it)) },
                    textLabel = "Nombres",
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Next
                    ),
                    keyboardActions = KeyboardActions(onNext = {}),
                    isError = false
                )
                SpacerComponent(modifier = Modifier.height(8.dp))
                OutlinedTextFieldBasic(
                    text = viewModel.formState.apellidos,
                    onValueChange = { viewModel.onEvent(SignUpFormEvent.ApellidosChange(it)) },
                    textLabel = "Apellidos",
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Next
                    ),
                    keyboardActions = KeyboardActions(onNext = {}),
                    isError = false
                )
                SpacerComponent(modifier = Modifier.height(8.dp))
                OutlinedTextFieldBasic(
                    text = viewModel.formState.correo,
                    onValueChange = { viewModel.onEvent(SignUpFormEvent.CorreoChange(it)) },
                    textLabel = "Correo Electrónico",
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Email,
                        imeAction = ImeAction.Next
                    ),
                    keyboardActions = KeyboardActions(onNext = {}),
                    isError = false
                )
                SpacerComponent(modifier = Modifier.height(8.dp))
                OutlinedTextFieldBasic(
                    text = viewModel.formState.password,
                    onValueChange = { viewModel.onEvent(SignUpFormEvent.PasswordChange(it)) },
                    textLabel = "Contraseña",
                    keyboardOptions = KeyboardOptions(
                        keyboardType = if (viewModel.formState.passwordVisualTransformation) KeyboardType.Text else KeyboardType.Password,
                        imeAction = ImeAction.Done
                    ),
                    keyboardActions = KeyboardActions(onDone = {}),
                    trailingIcon = {
                        val image = if (viewModel.formState.passwordVisualTransformation) Icons.Filled.Visibility else Icons.Filled.VisibilityOff
                        IconButton(
                            onClick = {
                                viewModel.onEvent(SignUpFormEvent.PasswordVisualTransformationChange(!viewModel.formState.passwordVisualTransformation))
                            }
                        ) {
                            Icon(imageVector = image, contentDescription = "Toggle password")
                        }
                    },
                    visualTransformation = if (viewModel.formState.passwordVisualTransformation) VisualTransformation.None else PasswordVisualTransformation(),
                    isError = false
                )
                SpacerComponent(modifier = Modifier.height(24.dp))
                ButtonBasic(
                    text = "Registrarse",
                    onClick = { viewModel.onEvent(SignUpFormEvent.Submit) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                )
                SpacerComponent(modifier = Modifier.height(16.dp))
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    TextBasic(
                        text = "¿Ya tienes cuenta? Inicia Sesión",
                        style = TextStyle(
                            color = Secundary,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold
                        ),
                        modifier = Modifier.clickable { onNavigateToLogin() }
                    )
                }
                SpacerComponent(modifier = Modifier.height(24.dp))
            }
        }
    }
}
