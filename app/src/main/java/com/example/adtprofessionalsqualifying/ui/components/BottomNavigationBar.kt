package com.example.adtprofessionalsqualifying.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.adtprofessionalsqualifying.R
import com.example.adtprofessionalsqualifying.navigation.NavRoutes

@Composable
fun BottomNavigationBar(
    modifier: Modifier = Modifier,
    onNavigate: (String) -> Unit
) {
    val colorScheme = MaterialTheme.colorScheme
    var selectedItem by remember { mutableStateOf("Sleep") }

    NavigationBar(
        modifier = modifier.height(72.dp),
        containerColor = colorScheme.surface
    ) {
        val items = listOf(
            Triple("Home", R.drawable.home, NavRoutes.HOME_SCREEN.route),
            Triple("Sleep", R.drawable.sleep_bottom, NavRoutes.SLEEP_SCREEN.route),
            Triple("Meditate", R.drawable.mediate, NavRoutes.MEDIATE_SCREEN.route),
            Triple("Music", R.drawable.music, NavRoutes.MUSIC_SCREEN.route),
            Triple("Afsar", R.drawable.afsar, NavRoutes.AFSAR_SCREEN.route)
        )

        items.forEach { (label, icon, route) ->
            NavigationBarItem(
                selected = selectedItem == label,
                onClick = {
                    selectedItem = label
                    onNavigate(route)
                },
                icon = {
                    Image(
                        painter = painterResource(id = icon),
                        contentDescription = label,
                        modifier = Modifier.size(22.dp)
                    )
                },
                label = { Text(label, fontSize = 11.sp) },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = colorScheme.primary,
                    selectedTextColor = colorScheme.primary,
                    unselectedIconColor = colorScheme.onSurface.copy(alpha = 0.7f),
                    unselectedTextColor = colorScheme.onSurface.copy(alpha = 0.7f)
                )
            )
        }
    }
}
