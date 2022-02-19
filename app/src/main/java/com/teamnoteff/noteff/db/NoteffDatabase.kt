package com.teamnoteff.noteff.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.teamnoteff.noteff.entities.*


@Database(
    entities =
    [
        Note::class,
        NoteCategory::class,
        PlainTextDataSegment::class,
        ImportantTextDataSegment::class,
        LinkDataSegment::class,
        PhoneNumberDataSegment::class,
        ImageDataSegment::class,
        UserConfig::class
    ],
    version = 1,
    exportSchema = false
)
abstract class NoteffDatabase: RoomDatabase() {

    abstract val noteDao: NoteDao
    abstract val noteCategoryDao: NoteCategoryDao
    abstract val userConfigDao: UserConfigDao
    abstract val plainTextDataSegmentDao: PlainTextDataSegmentDao
    abstract val importantTextDataSegmentDao: ImportantTextDataSegmentDao
    abstract val phoneNumberDataSegmentDao: PhoneNumberDataSegmentDao
    abstract val linkDataSegmentDao: LinkDataSegmentDao
    abstract val imageDataSegmentDao: ImageDataSegmentDao

    companion object {
        @Volatile
        private var INSTANCE:NoteffDatabase? = null
        fun getInstance(context: Context): NoteffDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        NoteffDatabase::class.java,
                        "noteff_data_database"
                    ).build()
                }
                return instance
            }
        }
    }
}