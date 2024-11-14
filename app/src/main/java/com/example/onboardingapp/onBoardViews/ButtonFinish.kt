package com.example.onboardingapp.onBoardViews

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.onboardingapp.dataStore.StoreBoarding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import androidx.compose.runtime.rememberCoroutineScope
import kotlinx.coroutines.launch

@Composable
fun ButtonFinish(currentPage: Int, navController: NavController, store: StoreBoarding) {
    val coroutineScope = rememberCoroutineScope()

    Row(
        modifier = Modifier
            .padding(bottom = 20.dp)
            .fillMaxWidth(),
        horizontalArrangement = if (currentPage != 2) Arrangement.SpaceBetween
        else Arrangement.Center
    ) {
        if (currentPage == 2) {
            OutlinedButton(onClick = {
                // Guardar en DataStore que el onboarding ha sido completado
                coroutineScope.launch {
                    store.saveBoarding(true)
                }
                navController.navigate("home") {
                    popUpTo(0) { inclusive = true }
                }
            }) {
                Text(
                    text = "Entrar",
                    modifier = Modifier
                        .padding(vertical = 8.dp, horizontal = 40.dp),
                    color = Color.Gray
                )
            }
        }
    }
}
