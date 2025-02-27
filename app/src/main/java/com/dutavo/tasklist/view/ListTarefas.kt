package com.dutavo.tasklist.view

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.dutavo.tasklist.R
import com.dutavo.tasklist.itemLista.TarefaItem
import com.dutavo.tasklist.model.Tarefa
import com.dutavo.tasklist.ui.theme.Purple40


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListaTarefas(
    navController: NavController
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Lista de Tarefas",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                },
                colors = TopAppBarDefaults.mediumTopAppBarColors(containerColor = Purple40)
            )
        },
        containerColor = Color.Black,
        floatingActionButton = {
            FloatingActionButton(onClick = {
                navController.navigate("salvarTarefa")
            },
            containerColor = Purple40 ) {
                Image(
                    imageVector = ImageVector.vectorResource(id = R.drawable.ic_add),
                    contentDescription = "Icone de salvar tarefa"
                    )
            }
        }
    ) {
        val listaTarefas: MutableList<Tarefa> = mutableListOf(
            Tarefa(
                "Jogar",
                "Jogar uma partida",
                0
            ),
            Tarefa(
                "Academia",
                "Ir executar treino de superiores",
                1
            ),
            Tarefa(
                "Programar",
                "Desenvolver um aplicativo",
                2
            ),
            Tarefa(
                "Cozinhar",
                "Fazer as marmita da semana",
                3
            )
        )
        LazyColumn {
            itemsIndexed(listaTarefas){ position, _ ->
                TarefaItem(position, listaTarefas)
            }
        }
    }
}