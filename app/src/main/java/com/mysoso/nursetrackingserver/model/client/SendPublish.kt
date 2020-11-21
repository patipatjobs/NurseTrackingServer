package com.mysoso.nursetrackingserver.model.client

import com.mysoso.nursetrackingserver.model.androidbox

data class SendPublish(
    val androidbox: androidbox,
    val itag: iTAG
)