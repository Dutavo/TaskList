package com.dutavo.tasklist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.dutavo.tasklist.ui.theme.TaskListTheme
import com.dutavo.tasklist.view.ListaTarefas
import com.dutavo.tasklist.view.SalvarTarefa

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            TaskListTheme {

                val navController = rememberNavController()

                NavHost(navController = navController, startDestination = "listaTarefas" ){
                    composable( route = "listaTarefas"){
                        ListaTarefas(navController)

                    }
                    composable(route = "salvarTarefa"){
                        SalvarTarefa(navController)
                    }
                }

            }
        }
    }
}


