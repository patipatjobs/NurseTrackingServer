package com.mysoso.nursetrackingserver.model.layout

import com.mysoso.nursetrackingserver.model.dashboard.RoomList

data class Layout(
    val room_list: ArrayList<RoomList>? = null
)