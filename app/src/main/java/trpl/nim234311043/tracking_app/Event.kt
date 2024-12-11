package trpl.nim234311043.tracking_app

import trpl.nim234311045.tracking_app.Daypart

// Data class Event setelah refactoring untuk menggunakan Daypart sebagai tipe pemisahan hari
data class Event(
    val title: String,
    val description: String? = null,  // Memberikan nilai default null
    val daypart: Daypart,
    val durationInMinutes: Int
)
