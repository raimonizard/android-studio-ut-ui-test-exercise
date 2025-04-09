package com.example.android_studio_test_exercice.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TriStateCheckbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.android_studio_test_exercice.viewmodel.MainViewModel

@Composable
fun MainView(myViewModel: MainViewModel, modifier: Modifier = Modifier) {
    val estatSwitch by myViewModel.estatSwitch.observeAsState(true)
    val esVegetaria by myViewModel.esVegetaria.observeAsState(true)
    val esVega by myViewModel.esVega.observeAsState(false)
    val esCarnivor by myViewModel.esCarnivor.observeAsState(true)
    val triStateStatus by myViewModel.triStateStatus.observeAsState(ToggleableState.Off)
    val selectedOption by myViewModel.selectedOption.observeAsState("Messi")

    Box(
        modifier = Modifier
            .fillMaxSize(1f) // El Box ocupa tot l'espai de la pantalla
            .padding(20.dp, 60.dp)
    ){

        Column(
            modifier = Modifier
                //.fillMaxSize(0.5f) // El Column ocupa tot l'espai del component superior
                .fillMaxWidth(1f)
                .fillMaxHeight(1f)
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth(1f)
                //.fillMaxHeight(0.3f)
            ){

                Text(text = "Activar Wi-Fi: ",
                    modifier = Modifier
                        .fillMaxWidth(0.6f) // Fem que el component Text sigui responsive ocupi el 60% de l'amplada del component superior
                        .padding(0.dp, 10.dp),
                    fontSize = 25.sp // La unitat sp es refereix a scaled pixels i s'adapta a la mida del text que tingui configurat l'usuar@
                )

                Switch(
                    checked = estatSwitch,
                    onCheckedChange = {myViewModel.toggleEstatSwitch()}, // Invertim el valor de la variable al interactuar amb el Switch
                    modifier = Modifier
                        .fillMaxWidth(0.4f), // Fem que el component Switch sigui responsive ocupi el 40% de l'amplada del component superior
                    enabled = true,
                    colors = SwitchDefaults.colors(
                        uncheckedThumbColor = Color.LightGray,
                        checkedThumbColor = Color.Black
                    )
                )

            }

            Column(
                modifier = Modifier
                    .fillMaxWidth(1f)
                    .wrapContentSize()
                    .padding(0.dp, 20.dp)
            ){

                Text(text = "Opcions de menú:",
                    modifier = Modifier
                        .fillMaxWidth(1f), // Fem que el component Text sigui responsive ocupi el 60% de l'amplada del component superior
                    fontSize = 25.sp // La unitat sp es refereix a scaled pixels i s'adapta a la mida del text que tingui configurat l'usuar@
                )

                Row(modifier = Modifier
                    .fillMaxWidth(1f)
                    .padding(0.dp, 10.dp)
                    //.fillMaxHeight(0.1f)
                    //.wrapContentSize()
                    //.wrapContentWidth()
                )
                {
                    Text("Carnívor/a",
                        modifier = Modifier
                            .align(CenterVertically)
                            .fillMaxWidth(0.33f)
                    )

                    Text("Vegetarià/na",
                        modifier = Modifier
                            .align(CenterVertically)
                            .fillMaxWidth(0.6f)
                    )

                    Text("Vegà/na",
                        modifier = Modifier
                            .align(CenterVertically)
                            .fillMaxWidth(1f)
                    )
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth(1f)
                        //.fillMaxHeight(1f) Comentem aquesta propietat per tal de que la fila no ocupi tot l'espai del contenidor superior
                        //.wrapContentSize()
                        .wrapContentWidth()
                ){

                    Checkbox(
                        checked = esCarnivor,
                        onCheckedChange = {myViewModel.toggleEsCarnivor()}, // Invertim el valor de la variable al interactuar amb el Checkbox
                        modifier = Modifier
                            .fillMaxWidth(0.20f), // Fem que el component Switch sigui responsive ocupi el 40% de l'amplada del component superior
                        enabled = false,
                        colors = CheckboxDefaults.colors(
                            uncheckedColor = Color.LightGray,
                            checkmarkColor = Color.Black)
                    )

                    Checkbox(
                        checked = esVegetaria,
                        onCheckedChange = { TODO() }, // Invertim el valor de la variable al interactuar amb el Checkbox
                        modifier = Modifier
                            .fillMaxWidth(0.33f), // Fem que el component Switch sigui responsive ocupi el 40% de l'amplada del component superior
                        enabled = true,
                        colors = CheckboxDefaults.colors(
                            uncheckedColor = Color.LightGray,
                            checkmarkColor = Color.Black)
                    )

                    Checkbox(
                        checked = esVega,
                        onCheckedChange = { TODO() }, // Invertim el valor de la variable al interactuar amb el Checkbox
                        modifier = Modifier
                            .fillMaxWidth(0.33f), // Fem que el component Switch sigui responsive ocupi el 40% de l'amplada del component superior
                        enabled = true,
                        colors = CheckboxDefaults.colors(
                            uncheckedColor = Color.LightGray,
                            checkmarkColor = Color.Black)
                    )

                }
            }

            Column(modifier = Modifier
                .fillMaxWidth(1f)
            ){

                Text("TriState",
                    modifier = Modifier
                        .fillMaxWidth(1f),
                    fontSize = 20.sp
                )

                TriStateCheckbox(state = triStateStatus,
                    onClick = { myViewModel.toggleTriStateStatus() }
                )
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalAlignment = Alignment.Start
            ) {

                Text(text = "Pilota d'Or:",
                    fontSize = 20.sp
                )

                Row(verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(
                        selected = selectedOption == "Vinicius",
                        onClick = { TODO() },
                        enabled = false,
                        colors = RadioButtonDefaults.colors(
                            selectedColor = Color.Black,
                            unselectedColor = Color.LightGray
                        )
                    )

                    Text(text = "Vinicius", modifier = Modifier.padding(start = 8.dp))
                }

                Row(verticalAlignment = Alignment.CenterVertically) {
                    RadioButton(
                        selected = selectedOption == "Lamine Yamal",
                        onClick = { TODO() },
                        colors = RadioButtonDefaults.colors(
                            selectedColor = Color.Black,
                            unselectedColor = Color.LightGray
                        )
                    )
                    Text(text = "Lamine Yamal", modifier = Modifier.padding(start = 8.dp))
                }

                Row(verticalAlignment = Alignment.CenterVertically) {
                    RadioButton(
                        selected = selectedOption == "Raphina",
                        onClick = { TODO() },
                        colors = RadioButtonDefaults.colors(
                            selectedColor = Color.Black,
                            unselectedColor = Color.LightGray
                        )
                    )
                    Text(text = "Raphina", modifier = Modifier.padding(start = 8.dp))
                }
            }
        }
    }
}