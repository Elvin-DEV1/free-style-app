package com.example.freestyleapp.presentation.onboarding

import androidx.annotation.DrawableRes
import com.example.freestyleapp.R

data class Page(
    val title: String,
    val description: String,
    @DrawableRes val image: Int
)

val pages = listOf(
    Page(
        title = "Afamily.vn",
        description = "TRANG THÔNG TIN ĐIỆN TỬ TỔNG HỢP",
        image = R.drawable.afamily
    ),
    Page(
        title = "Kenh14.vn",
        description = "TRANG THÔNG TIN ĐIỆN TỬ TỔNG HỢP",
        image = R.drawable.kenh14
    ),
    Page(
        title = "Soha.vn",
        description = "TRANG THÔNG TIN ĐIỆN TỬ TỔNG HỢP",
        image = R.drawable.soha
    ),
    Page(
        title = "Truyền hình thanh hóa",
        description = "ĐÀI PHÁT THANH VÀ TRUYỀN HÌNH THANH HÓA",
        image = R.drawable.thanhhoa
    ),
)