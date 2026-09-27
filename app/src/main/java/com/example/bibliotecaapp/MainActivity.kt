package com.example.bibliotecaapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.LocalActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.bibliotecaapp.ui.theme.BibliotecaAppTheme

val FondoClaro = Color(0xFFE8DED0)
val FondoSombra = Color(0xFFC8B8A6)
val ColorBoton = Color(0xFFC57D56)

val ColorTexto = Color(0xFF5A4636)
val ColorTarjeta = Color(0xFFF5EFE7)
val ColorBordeImagen = Color(0xFFB49A7A)

@Composable
fun FondoBiblioteca(
    contenido: @Composable () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.horizontalGradient(
                    colors = listOf(
                        FondoSombra,
                        FondoClaro,
                        FondoClaro,
                        FondoSombra
                    )
                )
            )
    ) {
        contenido()
    }
}

@Composable
fun BotonBiblioteca(
    texto: String,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = ColorBoton,
            contentColor = Color.White
        )
    ) {
        Text(
            text = texto,
            fontSize = 17.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun PantallaInicio(navController: NavHostController) {

    FondoBiblioteca {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Text(
                text = "Biblioteca",
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                color = ColorTexto
            )

            Spacer(modifier = Modifier.height(18.dp))

            Image(
                painter = painterResource(id = R.drawable.biblioteca_inicio),
                contentDescription = "Biblioteca",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .border(
                        width = 2.dp,
                        color = ColorBordeImagen,
                        shape = RoundedCornerShape(16.dp)
                    ),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Los libros nos permiten aprender, imaginar y descubrir nuevos mundos.",
                fontSize = 19.sp,
                fontWeight = FontWeight.Bold,
                color = ColorTexto,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(28.dp))

            BotonBiblioteca(
                texto = "Catálogo",
                onClick = {
                    navController.navigate("menu")
                }
            )

            Spacer(modifier = Modifier.height(12.dp))

            BotonBiblioteca(
                texto = "Nosotros",
                onClick = {
                    navController.navigate("nosotros")
                }
            )

            Spacer(modifier = Modifier.height(12.dp))

            val activity = LocalActivity.current

            BotonBiblioteca(
                texto = "Cerrar",
                onClick = {
                    activity?.finish()
                }
            )
        }
    }
}

@Composable
fun PantallaMenu(navController: NavHostController) {

    FondoBiblioteca {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Text(
                text = "Menú",
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                color = ColorTexto
            )

            Spacer(modifier = Modifier.height(18.dp))

            Image(
                painter = painterResource(id = R.drawable.biblioteca_menu),
                contentDescription = "Libros de biblioteca",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(190.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .border(
                        width = 2.dp,
                        color = ColorBordeImagen,
                        shape = RoundedCornerShape(16.dp)
                    ),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.height(18.dp))

            Text(
                text = "Explora las opciones disponibles en nuestra biblioteca.",
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium,
                color = ColorTexto,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(24.dp))

            BotonBiblioteca(
                texto = "Nuestro catálogo",
                onClick = {
                    navController.navigate("catalogo")
                }
            )

            Spacer(modifier = Modifier.height(12.dp))

            BotonBiblioteca(
                texto = "Libros más vendidos",
                onClick = {}
            )

            Spacer(modifier = Modifier.height(12.dp))

            BotonBiblioteca(
                texto = "Préstamos de libros",
                onClick = {}
            )

            Spacer(modifier = Modifier.height(12.dp))

            BotonBiblioteca(
                texto = "Volver al inicio",
                onClick = {
                    navController.navigate("inicio") {
                        popUpTo("inicio") {
                            inclusive = true
                        }
                    }
                }
            )
        }
    }
}

data class Categoria(
    val nombre: String,
    val imagen: Int
)

@Composable
fun PantallaCatalogo(navController: NavHostController) {

    val categorias = listOf(
        Categoria("Literatura", R.drawable.literatura),
        Categoria("Ciencia", R.drawable.ciencia),
        Categoria("Tecnología", R.drawable.tecnologia),
        Categoria("Historia", R.drawable.historia),
        Categoria("Matemáticas", R.drawable.matematicas),
        Categoria("Infantil", R.drawable.infantil)
    )

    FondoBiblioteca {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 18.dp)
        ) {

            Spacer(modifier = Modifier.height(75.dp))

            Text(
                text = "Nuestro Catálogo",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                color = ColorTexto,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(18.dp))

            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier.weight(1f),
                contentPadding = PaddingValues(bottom = 12.dp),
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                items(categorias) { categoria ->

                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .border(
                                width = 1.5.dp,
                                color = ColorBordeImagen,
                                shape = RoundedCornerShape(14.dp)
                            ),
                        shape = RoundedCornerShape(14.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = ColorTarjeta
                        ),
                        elevation = CardDefaults.cardElevation(
                            defaultElevation = 5.dp
                        )
                    ) {

                        Column(
                            modifier = Modifier.padding(8.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {

                            Image(
                                painter = painterResource(id = categoria.imagen),
                                contentDescription = categoria.nombre,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(120.dp)
                                    .clip(RoundedCornerShape(10.dp)),
                                contentScale = ContentScale.Crop
                            )

                            Spacer(modifier = Modifier.height(8.dp))

                            Text(
                                text = categoria.nombre,
                                fontSize = 17.sp,
                                fontWeight = FontWeight.Bold,
                                color = ColorTexto,
                                textAlign = TextAlign.Center
                            )
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            BotonBiblioteca(
                texto = "Volver atrás",
                onClick = {
                    navController.popBackStack()
                }
            )

            Spacer(modifier = Modifier.height(18.dp))
        }
    }
}

@Composable
fun PantallaNosotros(navController: NavHostController) {

    FondoBiblioteca {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Text(
                text = "Nosotros",
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                color = ColorTexto
            )

            Spacer(modifier = Modifier.height(18.dp))

            Image(
                painter = painterResource(id = R.drawable.biblioteca_exterior),
                contentDescription = "Exterior de la biblioteca",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .border(
                        width = 2.dp,
                        color = ColorBordeImagen,
                        shape = RoundedCornerShape(16.dp)
                    ),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Nuestra biblioteca es un espacio dedicado al aprendizaje, la lectura y el conocimiento. Aquí buscamos que cada persona pueda descubrir nuevos temas y disfrutar de los libros.",
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium,
                color = ColorTexto,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(28.dp))

            BotonBiblioteca(
                texto = "Volver",
                onClick = {
                    navController.popBackStack()
                }
            )
        }
    }
}

@Composable
fun BibliotecaApp() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "inicio"
    ) {

        composable("inicio") {
            PantallaInicio(navController)
        }

        composable("menu") {
            PantallaMenu(navController)
        }

        composable("catalogo") {
            PantallaCatalogo(navController)
        }

        composable("nosotros") {
            PantallaNosotros(navController)
        }
    }
}

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {
            BibliotecaAppTheme {
                BibliotecaApp()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun InicioPreview() {
    BibliotecaAppTheme {
        val navController = rememberNavController()
        PantallaInicio(navController)
    }
}

@Preview(showBackground = true)
@Composable
fun MenuPreview() {
    BibliotecaAppTheme {
        val navController = rememberNavController()
        PantallaMenu(navController)
    }
}

@Preview(showBackground = true)
@Composable
fun CatalogoPreview() {
    BibliotecaAppTheme {
        val navController = rememberNavController()
        PantallaCatalogo(navController)
    }
}