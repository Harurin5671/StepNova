package com.crowns.stepnova.feature.onboarding.presentation.screen

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.crowns.stepnova.feature.onboarding.presentation.util.arePermissionsGranted
import com.crowns.stepnova.feature.onboarding.presentation.util.getRequiredPermissions

@Composable
fun PermissionsScreen(onNextClick: () -> Unit) {
    val context = LocalContext.current

    // Check if permissions are already granted when the screen is shown
    // If so, navigate to the next screen immediately.
    LaunchedEffect(Unit) {
        if (arePermissionsGranted(context)) {
            onNextClick()
        }
    }

    val permissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestMultiplePermissions(),
        onResult = {
            // The user has responded to the permission request.
            // For this flow, we will navigate to the next screen regardless of the outcome.
            onNextClick()
        }
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Enable essential features", // Replace with string resource
            style = MaterialTheme.typography.headlineMedium,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(16.dp))

        // Explanation for Activity permission
        Text(
            text = "To track your steps and progress, StepNova needs access to your physical activity data.", // Replace with string resource
            style = MaterialTheme.typography.bodyLarge,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(16.dp))

        // Explanation for Notification permission
        Text(
            text = "We'd also like to send you notifications to celebrate milestones and remind you to stay active.", // Replace with string resource
            style = MaterialTheme.typography.bodyLarge,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(32.dp))

        Button(onClick = { permissionLauncher.launch(getRequiredPermissions().toTypedArray()) }) {
            Text(text = "Grant Permissions") // Replace with string resource
        }
    }
}
