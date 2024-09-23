package com.geovannycode.jetpackcompose.ecoeats.presentation.sign_in

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.geovannycode.jetpackcompose.ecoeats.R
import com.geovannycode.jetpackcompose.ecoeats.presentation.common.ButtonBasic
import com.geovannycode.jetpackcompose.ecoeats.presentation.common.ImageBasic
import com.geovannycode.jetpackcompose.ecoeats.presentation.common.OutlinedTextFieldBasic
import com.geovannycode.jetpackcompose.ecoeats.presentation.common.SpacerComponent
import com.geovannycode.jetpackcompose.ecoeats.presentation.common.TextBasic
import com.geovannycode.jetpackcompose.ecoeats.presentation.previews.PreviewDefault
import com.geovannycode.jetpackcompose.ecoeats.ui.theme.Primary

@Composable
fun SingInScreen(
    modifier: Modifier = Modifier,
    viewModel: SignInViewModel = viewModel()
) {

    val state = viewModel.state
    val context = LocalContext.current


    if (state.isLoading) {
        CircularProgressIndicator()
    }

    if (state.success != null) {
        //    println(state.success?.email)
        Toast.makeText(context, state.success?.email, Toast.LENGTH_SHORT).show()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.5f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            SignInHeader()
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(3f)
                .padding(start = 24.dp, end = 24.dp, top = 24.dp)
        ) {
            SignInContext(viewModel = viewModel)
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(3f)
        ) {

        }
    }
}

@Composable
fun SignInHeader(modifier: Modifier = Modifier) {
    ImageBasic(
        image = R.drawable.ecoeats_logo,
        description = "Logo",
        modifier = modifier.size(150.dp)
    )
}

@Composable
fun SignInContext(
    modifier: Modifier = Modifier,
    viewModel: SignInViewModel
) {

    var email by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }

    var passwordVisible by remember {
        mutableStateOf(false)
    }
    TextBasic(
        text = "Login",
        style = TextStyle(
            color = Primary,
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold
        ),
        modifier = modifier
    )
    SpacerComponent(modifier = Modifier.height(16.dp))
    OutlinedTextFieldBasic(
        text = email,
        onValueChange = {
            email = it
        },
        textLabel = "Email",
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Next
        ),
        keyboardActions = KeyboardActions(
            onNext = { }
        ),
        trailingIcon = {
            IconButton(onClick = { email = "" }) {
                Icon(
                    imageVector = Icons.Filled.Clear,
                    contentDescription = "Clear"
                )
            }
        },
        isError = false
    )
    SpacerComponent(modifier = Modifier.height(8.dp))
    OutlinedTextFieldBasic(
        text = password,
        onValueChange = {
            password = it
        },
        textLabel = "Password",
        keyboardOptions = KeyboardOptions(
            keyboardType = if (passwordVisible) KeyboardType.Text else KeyboardType.Password,
            imeAction = ImeAction.Next
        ),
        keyboardActions = KeyboardActions(
            onNext = { }
        ),
        trailingIcon = {
            val image = if (passwordVisible) Icons.Filled.Visibility else Icons.Filled.VisibilityOff
            val description = if (passwordVisible) "Hide password" else "Show password"
            IconButton(
                onClick = {
                    passwordVisible = !passwordVisible
                }
            ) {
                Icon(
                    imageVector = image,
                    contentDescription = description
                )
            }
        },
        visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(), // Controla la visibilidad del texto
        isError = false
    )
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.BottomCenter
    ) {
        ButtonBasic(
            text = "Ingresar",
            onClick = {
                viewModel.signIn(email, password)
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
        )
    }

}

/*@PreviewDefault
@Composable
fun SingInScreenPreview() {
    SingInScreen()
}*/