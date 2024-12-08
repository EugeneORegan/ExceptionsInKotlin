package com.example.exceptions

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
import com.example.exceptions.ui.theme.ExceptionsTheme
import com.example.exceptions.ui.theme.MyException as MyException

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var today = 20241203
        var then = 20241103
        /**
         * Exception Handling
         * try ... catch blocks
         * 1. Try this code (which may be dangerous
         * 2. Catch the exception
         */

        try {
            /**
             *  a.  Precondition Function - If false, a specific
             *  Exception (in this case IllegalArgumentException
             *  will be provoked.
             */

            require(2 < 0) { "Code is wrong here" }
            /**
             * b. This block of code will throw the custom exception
             * , MyException. It may seem a bit weird, but needs to
             * be done in this manner as the JVM does not know what
             * are the conditions to provoke the exception.
             */
            if (today - then > 180)
                throw MyException()
        } catch (e: ArithmeticException) {
            println("Arithmetic Exception caused")
        } catch (e: IllegalArgumentException) {
            println("Illegal Argument Exception caused in MainActivity ")
            println(e.cause)
        } catch (e: MyException) {
            println("Custom Exception MyException Caught")
        }
        enableEdgeToEdge()
        setContent {
            ExceptionsTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )


                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ExceptionsTheme {
        Greeting("Android")
    }
}