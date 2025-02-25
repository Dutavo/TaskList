package com.dutavo.tasklist.componentes


import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import com.dutavo.tasklist.ui.theme.Black
import com.dutavo.tasklist.ui.theme.Cyan
import com.dutavo.tasklist.ui.theme.ShapeEditText
import com.dutavo.tasklist.ui.theme.White

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CaixaDeTexto(
    value: String,
    onValueChange: (String) -> Unit,
    modifier : Modifier,
    label: String,
    maxLines: Int,
    keyboardType : KeyboardType


    ){
    OutlinedTextField(
        value = value,
        onValueChange,
        modifier,
        label = {
            Text(text = label)
        },
        maxLines = maxLines,
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedTextColor = Black,
            focusedBorderColor = Cyan,
            focusedLabelColor = Cyan,
            containerColor = White,
            cursorColor = Cyan
        ),
        shape = ShapeEditText.small,
        keyboardOptions = KeyboardOptions(
            keyboardType = keyboardType
        )
    )

}
