package com.dutavo.tasklist.view

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.dutavo.tasklist.componentes.Botao
import com.dutavo.tasklist.componentes.CaixaDeTexto
import com.dutavo.tasklist.ui.theme.Purple40
import com.dutavo.tasklist.ui.theme.Radio_button_Green_Disable
import com.dutavo.tasklist.ui.theme.Radio_button_Green_Selected
import com.dutavo.tasklist.ui.theme.Radio_button_Red_Disable
import com.dutavo.tasklist.ui.theme.Radio_button_Red_Selected
import com.dutavo.tasklist.ui.theme.Radio_button_Yellow_Disable
import com.dutavo.tasklist.ui.theme.Radio_button_Yellow_Selected
import com.dutavo.tasklist.ui.theme.White

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SalvarTarefa(navController: NavController){
    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.mediumTopAppBarColors(containerColor = Purple40),
                title = {
                    Text(
                        text = "Salvar Tarefa",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = White
                    )
                }
            )
        }
    ){

        var tituloTarefa by remember {
            mutableStateOf("")
        }

        var descricaoTarafa by remember {
            mutableStateOf("")
        }

        var semPrioridadeTarefa by remember {
            mutableStateOf(false)
        }

        var prioridadeBaixa by remember {
            mutableStateOf(false)
        }

        var prioridadeMedia by remember {
            mutableStateOf(false)
        }

        var prioridadeAlta by remember {
            mutableStateOf(false)
        }

        Column(
            modifier = Modifier.fillMaxSize().verticalScroll(rememberScrollState())
        ) {

            CaixaDeTexto(
                value = tituloTarefa,
                onValueChange = {
                    tituloTarefa = it
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp, 80.dp, 20.dp, 0.dp),
                label = "Titulo Tarefa",
                maxLines = 1,
                keyboardType = KeyboardType.Text
            )

            CaixaDeTexto(
                value = descricaoTarafa,
                onValueChange = {
                    descricaoTarafa = it
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
                    .padding(20.dp, 20.dp, 10.dp, 0.dp),
                label = "Descrição",
                maxLines = 5,
                keyboardType = KeyboardType.Text
            )

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ){
               Text(text = "Nivel de Prioridade")

                RadioButton(
                    selected = prioridadeBaixa ,
                    onClick = {
                        prioridadeBaixa = !prioridadeBaixa
                    },
                    colors = RadioButtonDefaults.colors(
                        unselectedColor = Radio_button_Green_Disable,
                        selectedColor = Radio_button_Green_Selected
                    )
                )
                RadioButton(
                    selected = prioridadeMedia ,
                    onClick = {
                        prioridadeMedia = !prioridadeMedia
                    },
                    colors = RadioButtonDefaults.colors(
                        unselectedColor = Radio_button_Yellow_Disable,
                        selectedColor = Radio_button_Yellow_Selected
                    )
                )
                RadioButton(
                    selected = prioridadeAlta ,
                    onClick = {
                        prioridadeAlta = !prioridadeAlta
                    },
                    colors = RadioButtonDefaults.colors(
                        unselectedColor = Radio_button_Red_Disable,
                        selectedColor = Radio_button_Red_Selected
                    )
                )
            }

            Botao(
                onClick = {

                },
                modifier = Modifier.fillMaxWidth().height(80.dp).padding(20.dp),
                texto = "Salvar"
            )

        }
    }
}



