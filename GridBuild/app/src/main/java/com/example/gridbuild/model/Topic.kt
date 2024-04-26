package com.example.gridbuild.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Topic(
    @StringRes val titleResourceId: Int,
    val score: Int,
    @DrawableRes val imageResourceId: Int
)
