package com.teamnoteff.noteff.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room.databaseBuilder
import androidx.room.RoomDatabase
import com.teamnoteff.noteff.entities.*


@Database(
    entities =
    [
        Note::class,
        NoteCategory::class,
        DataSegmentType::class
    ],
    version = 1
)
abstract class NoteffDatabase: RoomDatabase() {

    companion object{
        @Volatile
        private var INSTANCE: NoteffDatabase?=null

        fun getDatabase(context: Context): RoomDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = databaseBuilder(
                        context.applicationContext,
                        NoteffDatabase::class.java,
                        "subscriber_data_database"
                    ).build()
                }

                return instance
            }
        }
    }
}