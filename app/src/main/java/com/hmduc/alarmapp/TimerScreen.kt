package com.hmduc.alarmapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource

@Composable
fun TimerScreen() {
    Column(
        Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.primary))
            .wrapContentSize(Alignment.Center)
    ) {
        Text(text = " Timer Screen")
    }
}