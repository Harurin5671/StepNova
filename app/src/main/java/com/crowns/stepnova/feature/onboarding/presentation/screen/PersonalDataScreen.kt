package com.crowns.stepnova.feature.onboarding.presentation.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.crowns.stepnova.feature.onboarding.domain.model.Gender

@Composable
fun PersonalDataScreen(
    name: String,
    age: String,
    gender: Gender,
    onNameChange: (String) -> Unit,
    onAgeChange: (String) -> Unit,
    onGenderChange: (Gender) -> Unit,
    onNextClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Tell us about yourself", // Replace with string resource
            style = MaterialTheme.typography.headlineMedium,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(32.dp))

        OutlinedTextField(
            value = name,
            onValueChange = onNameChange,
            label = { Text("Name") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )
        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = age,
            onValueChange = onAgeChange,
            label = { Text("Age") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )
        Spacer(modifier = Modifier.height(24.dp))

        GenderSelector(selectedGender = gender, onGenderSelect = onGenderChange)

        Spacer(modifier = Modifier.weight(1f))

        Button(onClick = onNextClick) {
            Text(text = "Next") // Replace with string resource
        }
    }
}

@Composable
private fun GenderSelector(selectedGender: Gender, onGenderSelect: (Gender) -> Unit) {
    Column(horizontalAlignment = Alignment.Start, modifier = Modifier.fillMaxWidth()) {
        Text("Gender", style = MaterialTheme.typography.bodyMedium)
        Spacer(modifier = Modifier.height(8.dp))
        Row(horizontalArrangement = Arrangement.spacedBy(16.dp), modifier = Modifier.fillMaxWidth()) {
            Gender.entries.forEach { gender ->
                val isSelected = selectedGender == gender
                if (isSelected) {
                    Button(
                        onClick = { onGenderSelect(gender) },
                        modifier = Modifier.weight(1f)
                    ) {
                        Text(gender.name.replaceFirstChar { it.uppercase() })
                    }
                } else {
                    OutlinedButton(
                        onClick = { onGenderSelect(gender) },
                        modifier = Modifier.weight(1f)
                    ) {
                        Text(gender.name.replaceFirstChar { it.uppercase() })
                    }
                }
            }
        }
    }
}
