package com.example.onboardingapp.onBoardViews

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import com.example.onboardingapp.R
import com.example.onboardingapp.data.PageData
import com.example.onboardingapp.dataStore.StoreBoarding
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.rememberPagerState

@OptIn(ExperimentalPagerApi::class, ExperimentalFoundationApi::class)
@Composable
fun MainOnBoarding(navController: NavHostController, store: StoreBoarding) {
    val items = ArrayList<PageData>()

    items.add(
        PageData(
            R.raw.page1,
            titulo = "Titulo 1",
            descripcion = "Descripcion 1"
        )
    )

    items.add(
        PageData(
            R.raw.page2,
            titulo = "Titulo 2",
            descripcion = "Descripcion 2"
        )
    )

    items.add(
        PageData(
            R.raw.page3,
            titulo = "Titulo 3",
            descripcion = "Descripcion 3"
        )
    )

    items.add(
        PageData(
            R.raw.page4,
            titulo = "Titulo 4",
            descripcion = "Descripcion 4"
        )
    )

    val pagerState = rememberPagerState(
        pageCount = items.size,
        initialOffscreenLimit = 2,
        infiniteLoop = false,
        initialPage = 0
    )

    OnBoardingPager(
        item = items,
        pagerState = pagerState,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(Color.White),
        navController = navController,
        store = store
    )
}

