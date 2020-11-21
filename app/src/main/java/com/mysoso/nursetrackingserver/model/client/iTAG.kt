package com.mysoso.nursetrackingserver.model.client

data class iTAG(
    val version: String,
    val itag_list: ArrayList<iTAGList>? = null
)