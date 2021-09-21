package dev.leonardom.firebasecrud.presentation.book_list.components

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import dev.leonardom.firebasecrud.ui.theme.Red100
import dev.leonardom.firebasecrud.ui.theme.Yellow600

@ExperimentalMaterialApi
@Composable
fun BookListItem() {
    Card(
        elevation = 0.dp
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
                .clickable {
                    TODO("ON ITEM CLICK")
                }
        ){
            Image(
                painter = rememberImagePainter(""),
                contentDescription = "",
                modifier = Modifier
                    .width(100.dp)
                    .height(160.dp)
                    .padding(8.dp)
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Title",
                    style = TextStyle(
                        fontWeight = FontWeight.Medium,
                        fontSize = 18.sp
                    )
                )

                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Author",
                    style = TextStyle(
                        fontWeight = FontWeight.Light,
                        fontSize = 14.sp,
                        color = Color.DarkGray
                    )
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Icon(
                        modifier = Modifier.size(18.dp),
                        imageVector = Icons.Default.Star,
                        contentDescription = "Start Icon",
                        tint = Yellow600
                    )

                    Text(
                        text = "4.5",
                        style = TextStyle(
                            color = Color.Black,
                            fontWeight = FontWeight.Black,
                            fontSize = 14.sp
                        )
                    )

                    Text(
                        text = "0 Descargas",
                        style = TextStyle(
                            color = Color.Black,
                            fontWeight = FontWeight.Light,
                            fontSize = 14.sp
                        )
                    )
                }

                Button(
                    onClick = {},
                    shape = RoundedCornerShape(50),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = Red100
                    )
                ) {
                    Text(
                        text = "Descargar",
                        color = Color.White
                    )
                }
            }
        }
    }
}