package com.apex.client

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private const val MINECRAFT_PACKAGE = "com.mojang.minecraftpe"

private val ApexBlue = Color(0xFF8B5CFF)
private val DeepBackground = Color(0xFF080812)
private val Panel = Color(0xFF151326)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme(
                colorScheme = darkColorScheme(
                    primary = ApexBlue,
                    onPrimary = Color(0xFF00131D),
                    background = DeepBackground,
                    surface = Panel,
                    onSurface = Color(0xFFEAF7FF),
                    secondary = Color(0xFFB35CFF)
                )
            ) {
                ApexHome()
            }
        }
    }
}

@Composable
private fun ApexHome() {
    val context = LocalContext.current
    var minecraftInstalled by remember {
        mutableStateOf(isMinecraftInstalled(context))
    }
    var launchMessage by remember { mutableStateOf<String?>(null) }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = DeepBackground
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text(
                    text = "APEX",
                    color = ApexBlue,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Black,
                    letterSpacing = 5.sp
                )
                Text(
                    text = "CLIENT",
                    color = Color.White,
                    fontSize = 38.sp,
                    fontWeight = FontWeight.ExtraBold,
                    letterSpacing = 1.sp
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Your Minecraft, your way.",
                    color = Color(0xFF9CB2C5),
                    fontSize = 14.sp
                )

                Spacer(modifier = Modifier.height(36.dp))

                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(20.dp),
                    colors = CardDefaults.cardColors(containerColor = Panel)
                ) {
                    Column(modifier = Modifier.padding(20.dp)) {
                        Text(
                            text = "GAME STATUS",
                            color = ApexBlue,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold,
                            letterSpacing = 2.sp
                        )
                        Spacer(modifier = Modifier.height(12.dp))
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(
                                text = if (minecraftInstalled) "Minecraft detected" else "Minecraft not found",
                                color = Color.White,
                                fontSize = 18.sp,
                                fontWeight = FontWeight.SemiBold
                            )
                        }
                        Spacer(modifier = Modifier.height(6.dp))
                        Text(
                            text = if (minecraftInstalled) {
                                "Bedrock Edition is installed on this device."
                            } else {
                                "Install Minecraft Bedrock, then reopen Apex Client."
                            },
                            color = Color(0xFF9CB2C5),
                            fontSize = 13.sp
                        )
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(20.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(0xFF0C1420))
                ) {
                    Column(modifier = Modifier.padding(20.dp)) {
                        Text(
                            text = "BUILT TO STAY LIGHT",
                            color = ApexBlue,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold,
                            letterSpacing = 1.5.sp
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = "A lightweight launcher with a clean client-style design.",
                            color = Color(0xFFB8C9D8),
                            fontSize = 14.sp
                        )
                    }
                }
            }

            Column {
                Button(
                    onClick = {
                        val launchIntent = context.packageManager
                            .getLaunchIntentForPackage(MINECRAFT_PACKAGE)
                        if (launchIntent != null) {
                            launchIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                            context.startActivity(launchIntent)
                            launchMessage = null
                        } else {
                            minecraftInstalled = false
                            launchMessage = "Minecraft could not be opened. Check that it is installed."
                        }
                    },
                    enabled = minecraftInstalled,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(58.dp),
                    shape = RoundedCornerShape(16.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = ApexBlue,
                        contentColor = Color(0xFF00131D),
                        disabledContainerColor = Color(0xFF263544),
                        disabledContentColor = Color(0xFF8295A6)
                    )
                ) {
                    Text(
                        text = "LAUNCH MINECRAFT",
                        fontWeight = FontWeight.ExtraBold,
                        letterSpacing = 1.sp
                    )
                }

                launchMessage?.let {
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(text = it, color = Color(0xFFFFB4AB), fontSize = 12.sp)
                }

                Spacer(modifier = Modifier.height(18.dp))
                Text(
                    text = "APEX CLIENT  •  v0.1.0",
                    modifier = Modifier.fillMaxWidth(),
                    color = Color(0xFF607487),
                    fontSize = 11.sp
                )
            }
        }
    }
}

private fun isMinecraftInstalled(context: Context): Boolean {
    return try {
        context.packageManager.getApplicationInfo(MINECRAFT_PACKAGE, 0)
        true
    } catch (_: PackageManager.NameNotFoundException) {
        false
    }
}
