package com.dutavo.tasklist.itemLista

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.dutavo.tasklist.R
import com.dutavo.tasklist.model.Tarefa
import com.dutavo.tasklist.ui.theme.Black
import com.dutavo.tasklist.ui.theme.Radio_button_Green_Selected
import com.dutavo.tasklist.ui.theme.Radio_button_Red_Selected
import com.dutavo.tasklist.ui.theme.Radio_button_Yellow_Selected
import com.dutavo.tasklist.ui.theme.ShapeCardPrioridade
import com.dutavo.tasklist.ui.theme.White



@Composable
fun TarefaItem(position: Int, listaTarefas: MutableList<Tarefa>){

    val tituloTarefa = listaTarefas[position].tarefa
    val descricaoTarefa = listaTarefas[position].descricao
    val prioridade = listaTarefas[position].prioridade

    var nivelDePrioridade: String = when(prioridade){
        0 -> {
            "Sem Prioridade"
        }
        1 -> {
            "Baixa"
        }
        2 -> {
            "Media"
        }
        else -> {
            "Prioridade Alta"
        }
    }

    val color = when(prioridade){
        0 -> {
            Black
        }
        1 -> {
            Radio_button_Green_Selected
        }
        2 -> {
            Radio_button_Yellow_Selected
        }
        else -> {
            Radio_button_Red_Selected
        }
    }

    Card(
        colors = CardColors(White, Black, Black, Black),
        modifier = Modifier.fillMaxWidth().padding(10.dp)
    ){
        ConstraintLayout(
            modifier = Modifier.padding(20.dp)
        ){
            val (txtTitulo, txtDescricao, cardPrioridade, txtPrioridade, btDeletar) = createRefs()
            Text(
                text = tituloTarefa.toString(),
                modifier = Modifier.constrainAs(txtTitulo){
                    top.linkTo(parent.top, margin = 10.dp)
                    start.linkTo(parent.start, margin = 10.dp)
                }
            )
            Text(
                text = descricaoTarefa.toString(),
                modifier = Modifier.constrainAs(txtDescricao){
                    top.linkTo(txtTitulo.bottom, margin = 10.dp)
                    start.linkTo(parent.start, margin = 10.dp)
                }
            )
            Text(
                    text = "Nivel de Prioridade",
                modifier = Modifier.constrainAs(txtPrioridade){
                    top.linkTo(txtDescricao.bottom, margin = 10.dp)
                    start.linkTo(parent.start, margin = 10.dp)
                    bottom.linkTo(parent.bottom, margin = 10.dp)
                }
            )
            Card(
                colors = CardColors(Radio_button_Green_Selected, Black, Black, Black),
                modifier = Modifier.size(30.dp).constrainAs(cardPrioridade){
                    top.linkTo(txtDescricao.bottom, margin = 10.dp)
                    start.linkTo(txtPrioridade.end, margin = 10.dp)
                    bottom.linkTo(parent.bottom, margin = 10.dp)
                }, shape = ShapeCardPrioridade.large
            ) {

            }

            IconButton(
                onClick = {

                },
                modifier = Modifier.constrainAs(btDeletar){
                    top.linkTo(txtDescricao.bottom, margin = 10.dp)
                    start.linkTo(cardPrioridade.end, margin = 30.dp)
                    end.linkTo(parent.end, margin = 10.dp)
                    bottom.linkTo(parent.bottom, margin = 10.dp)
                }
            ){
                Image(imageVector =  ImageVector.vectorResource(id = R.drawable.ic_delete), contentDescription = null)
            }
        }
    }
}

/* Preview do Tarefa
@Composable
@Preview
private fun TarefaItemPreview(){
    TarefaItem()
}
*/