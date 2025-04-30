package com.meliskarci.expensetracking.ui.tracking

import androidx.compose.ui.tooling.preview.PreviewParameterProvider

class TrackingScreenPreviewProvider : PreviewParameterProvider<TrackingContract.UiState> {
    override val values: Sequence<TrackingContract.UiState>
        get() = sequenceOf(
            TrackingContract.UiState(
                isLoading = true,
                list = emptyList(),
            ),
            TrackingContract.UiState(
                isLoading = false,
                list = emptyList(),
            ),
            TrackingContract.UiState(
                isLoading = false,
                list = listOf("Item 1", "Item 2", "Item 3")
            ),
        )
}