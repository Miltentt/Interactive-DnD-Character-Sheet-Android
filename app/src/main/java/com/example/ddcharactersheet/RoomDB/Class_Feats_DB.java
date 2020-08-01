package com.example.ddcharactersheet.RoomDB;


import com.example.ddcharactersheet.Model.Class_Feat_Entity;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = Class_Feat_Entity.class, version =1,exportSchema = false)
public abstract class Class_Feats_DB extends RoomDatabase {

    public abstract Class_Feat_Dao class_feat_dao();
    @Override
    public void clearAllTables() {

    }
}
