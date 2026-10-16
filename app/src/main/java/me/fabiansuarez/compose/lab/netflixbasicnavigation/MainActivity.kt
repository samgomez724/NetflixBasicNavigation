package me.fabiansuarez.compose.lab.netflixbasicnavigation

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
import me.fabiansuarez.compose.lab.netflixbasicnavigation.ui.screen.HomeScreen
import me.fabiansuarez.compose.lab.netflixbasicnavigation.ui.screen.LoginScreen
import me.fabiansuarez.compose.lab.netflixbasicnavigation.ui.screen.RegisterScreen
import me.fabiansuarez.compose.lab.netflixbasicnavigation.ui.screen.RegisterStep2Screen
import me.fabiansuarez.compose.lab.netflixbasicnavigation.ui.screen.RegisterStep3Screen
import me.fabiansuarez.compose.lab.netflixbasicnavigation.ui.theme.NetflixBasicNavigationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val myNavController= rememberNavController()
            NavHost(
                navController = myNavController,
                startDestination = "Login",
                modifier = Modifier.fillMaxSize()
            ){
                composable(route = "Login"){
                    LoginScreen(onClickRegister =
                        {
                            myNavController.navigate(route = "Register")
                        }, onClickIniciarSesion = {
                        myNavController.navigate(route = "Home")
                    }
                    )
                }

                composable(route = "Register"){
                    RegisterScreen(onClickBack = {
                        myNavController.popBackStack()
                    }, onClickRegister2 = {
                        myNavController.navigate(route="Register2")
                    }, onClickLogin = {
                        myNavController.navigate(route = "Login")
                    }
                    )
                }

                composable(route = "Register2"){
                    RegisterStep2Screen(onClickBack = {
                        myNavController.popBackStack()
                    }, onClickRegister3 = {
                        myNavController.navigate(route = "Register3")
                    }
                    )
                }

                composable(route = "Register3"){
                    RegisterStep3Screen(onClickBack = {
                        myNavController.popBackStack()
                    }, onClickHome = {
                        myNavController.navigate(route = "Home")
                    }
                    )
                }

                composable(route = "Home"){
                    HomeScreen()
                }


            }
        }
    }
}