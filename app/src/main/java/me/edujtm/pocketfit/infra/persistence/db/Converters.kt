package me.edujtm.pocketfit.infra.persistence.db

import androidx.room.TypeConverter
import me.edujtm.pocketfit.domain.entities.MajorGroup
import java.util.Date

class Converters {
    @TypeConverter
    fun fromTimestamp(value: Long?): Date? {
        return value?.let { Date(it) }
    }

    @TypeConverter
    fun dateToTimestamp(date: Date?): Long? {
        return date?.time
    }

    @TypeConverter
    fun fromMajorGroup(group: MajorGroup?): String? {
        return group?.groupName
    }

    @TypeConverter
    fun stringToMajorGroup(groupName: String?): MajorGroup? {
        return MajorGroup.values().find { it.groupName == groupName }
    }
}