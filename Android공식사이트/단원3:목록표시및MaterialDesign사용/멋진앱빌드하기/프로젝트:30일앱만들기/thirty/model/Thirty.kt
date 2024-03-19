package com.jang.thirty.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Thirty(
    @StringRes val nameRes: Int,
    @StringRes val descriptionRes: Int,
    @DrawableRes val imageRes: Int
)
