package com.github.mcgalanes.refiner.data.local.model.converter

import androidx.room.TypeConverter
import com.github.mcgalanes.refiner.data.local.model.GherkinLine.GherkinKey

class Converter {
    @TypeConverter fun toGherkinKey(value: String): GherkinKey = enumValueOf<GherkinKey>(value)
    @TypeConverter fun fromGherkinKey(key: GherkinKey): String = key.name
}
