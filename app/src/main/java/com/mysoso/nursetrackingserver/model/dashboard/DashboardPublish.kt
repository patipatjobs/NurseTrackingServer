package com.mysoso.nursetrackingserver.model.dashboard

import com.mysoso.nursetrackingserver.model.androidbox
import com.mysoso.nursetrackingserver.model.layout.Layout

data class DashboardPublish(
    val androidbox: androidbox?,
    val layoutX: Layout,
    val layoutY: Layout
)