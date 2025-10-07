package com.example.adtprofessionalsqualifying.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.adtprofessionalsqualifying.R
import com.example.adtprofessionalsqualifying.ui.components.CategoryItem
import com.example.adtprofessionalsqualifying.ui.components.StoryCard
import com.example.adtprofessionalsqualifying.ui.components.BottomNavigationBar

@Composable
fun SleepScreen(
    nextScreen: (String) -> Unit
) {
    val colorScheme = MaterialTheme.colorScheme
    val categories = listOf("All", "My", "Anxious", "Sleep", "Kids")
    val stories = listOf(
        Pair("Night Island", R.drawable.image_moon_clouds),
        Pair("Sweet Sleep", R.drawable.image_sweet_sleep),
        Pair("Night Sleep", R.drawable.image_night_sleep),
        Pair("Sweet Wleap", R.drawable.image_sweet_wleep)
    )

    Box(modifier = Modifier.fillMaxSize()) {
        // Верхний фон
        Image(
            painter = painterResource(id = R.drawable.top_sleep_screen),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp),
            contentScale = ContentScale.Crop
        )

        // Контент
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            contentPadding = PaddingValues(bottom = 90.dp)
        ) {
            item {
                Spacer(modifier = Modifier.height(70.dp))

                Text(
                    text = "Sleep Stories",
                    color = colorScheme.onBackground,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "Soothing bedtime stories to help you fall\ninto a deep and natural sleep",
                    color = colorScheme.onBackground.copy(alpha = 0.9f),
                    fontSize = 14.sp,
                    textAlign = TextAlign.Center,
                    lineHeight = 20.sp
                )

                Spacer(modifier = Modifier.height(24.dp))

                // Горизонтальный список категорий
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                    contentPadding = PaddingValues(horizontal = 16.dp)
                ) {
                    items(categories) { category ->
                        CategoryItem(
                            name = category,
                            selected = category == "All"
                        )
                    }
                }

                Spacer(modifier = Modifier.height(32.dp))

                // Большой блок "The Ocean Moon"
                Box(
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .fillMaxWidth()
                        .clip(MaterialTheme.shapes.medium)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.bigimage),
                        contentDescription = "The Ocean Moon",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxWidth()
                    )

                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(24.dp),
                        horizontalAlignment = Alignment.Start
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.lock),
                                contentDescription = "Lock",
                                modifier = Modifier.size(18.dp)
                            )
                            Spacer(modifier = Modifier.width(6.dp))
                            Text(
                                text = "The Ocean Moon",
                                color = colorScheme.primaryContainer, // нежно-желтый
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }

                        Spacer(modifier = Modifier.height(6.dp))

                        Text(
                            text = "Non-stop 8-hour mixes of our\nmost popular sleep audio",
                            color = colorScheme.onBackground,
                            fontSize = 13.sp
                        )

                        Spacer(modifier = Modifier.height(12.dp))

                        Button(
                            onClick = {},
                            colors = ButtonDefaults.buttonColors(
                                containerColor = colorScheme.surface,
                                contentColor = colorScheme.onSurface
                            ),
                            shape = MaterialTheme.shapes.large
                        ) {
                            Text(text = "START", fontSize = 13.sp)
                        }
                    }
                }

                Spacer(modifier = Modifier.height(32.dp))

                // Горизонтальный список карточек
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                    contentPadding = PaddingValues(horizontal = 16.dp)
                ) {
                    items(stories) { (title, image) ->
                        StoryCard(title = title, image = image)
                    }
                }
            }
        }

        // Нижняя панель навигации
        BottomNavigationBar(
            modifier = Modifier.align(Alignment.BottomCenter),
            onNavigate = nextScreen
        )
    }
}
