package me.vavra.multimoduleactivitynavigationsample.feature1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import me.vavra.multimoduleactivitynavigationsample.common.ui.theme.MultimoduleActivityNavigationSampleTheme
import me.vavra.multimoduleactivitynavigationsample.common.ui.theme.Typography

class Feature1Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MultimoduleActivityNavigationSampleTheme {
                Scaffold(
                    topBar = { TopAppBar(title = { Text("Feature 1") }) },
                    content = {
                        Content(null)
                    }
                )
            }
        }
    }

    @Composable
    fun Content(result: String?) {
        var argument by remember { mutableStateOf("") }
        Column {
            TextField(
                value = argument,
                onValueChange = { argument = it },
                label = { Text("Argument") },
                modifier = Modifier.padding(top = 16.dp, start = 16.dp, end = 16.dp)
            )
            Button(
                onClick = {},
                content = { Text("Navigate to Feature 2") },
                modifier = Modifier.padding(top = 16.dp, start = 16.dp, end = 16.dp)
            )
            if (result != null) {
                Divider(modifier = Modifier.padding(top = 16.dp))
                Text(
                    "Result from Feature 2:",
                    modifier = Modifier.padding(top = 16.dp, start = 16.dp, end = 16.dp)
                )
                Text(
                    result,
                    style = Typography.body2,
                    modifier = Modifier.padding(start = 16.dp, end = 16.dp)
                )
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun ContentNoResult() {
        Content(null)
    }

    @Preview(showBackground = true)
    @Composable
    fun ContentWithResult() {
        Content("Value")
    }
}