package com.example.adtprofessionalsqualifying.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.adtprofessionalsqualifying.R

@Composable
fun CategoryItem(name: String, selected: Boolean) {
    val colorScheme = MaterialTheme.colorScheme
    val iconId = when (name.lowercase()) {
        "all" -> R.drawable.all
        "my" -> R.drawable.my
        "anxious" -> R.drawable.anxious
        "sleep" -> R.drawable.sleep
        "kids" -> R.drawable.kids
        else -> R.drawable.all
    }

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Box(
            modifier = Modifier
                .size(64.dp)
                .background(
                    color = if (selected) colorScheme.primary else colorScheme.surface,
                    shape = RoundedCornerShape(20.dp)
                ),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = iconId),
                contentDescription = name,
                modifier = Modifier.size(28.dp)
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = name,
            color = colorScheme.onBackground,
            fontSize = 13.sp
        )
    }
}
