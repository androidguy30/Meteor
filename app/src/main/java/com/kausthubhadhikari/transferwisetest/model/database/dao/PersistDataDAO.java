package com.kausthubhadhikari.transferwisetest.model.database.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.kausthubhadhikari.transferwisetest.model.database.entity.PersistData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kausthubhadhikari on 12/11/17.
 */
@Dao
public interface PersistDataDAO {

    @Query("Select * from PersistData")
    List<PersistData> getHomeData();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(ArrayList<PersistData> data);

    @Query("Delete from PersistData")
    void clearData();

}
