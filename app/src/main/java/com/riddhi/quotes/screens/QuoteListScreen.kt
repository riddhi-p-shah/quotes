package com.riddhi.quotes.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.riddhi.quotes.R
import com.riddhi.quotes.models.Quote

@Composable
fun QuoteListScreen(data: Array<Quote>, onClick: (quote:Quote) -> Unit) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = "Quotes App",
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(8.dp, 24.dp),
            fontFamily = FontFamily(Font(R.font.montserrat_regular))
        )
        QuoteList(data = data, onClick)
    }
}