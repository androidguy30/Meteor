package com.kausthubhadhikari.transferwisetest.model.database.dao;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.kausthubhadhikari.transferwisetest.model.database.entity.PersistData;

/**
 * Created by kausthubhadhikari on 12/11/17.
 */
@Database(entities = {PersistData.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase appDatabase;

    public abstract PersistDataDAO persistDataDAO();
}
