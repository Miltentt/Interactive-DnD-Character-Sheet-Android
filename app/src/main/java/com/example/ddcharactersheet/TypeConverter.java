package com.example.ddcharactersheet;

import android.arch.persistence.room.TypeConverters;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;

public class TypeConverter  {
    Gson gson = new Gson();

    @android.arch.persistence.room.TypeConverter
    public  List<String> stringToSomeObjectList(String data) {
        if (data == null) {
            return Collections.emptyList();
        }

        Type listType = new TypeToken<List<String>>() {}.getType();

        return gson.fromJson(data, listType);
    }

    @android.arch.persistence.room.TypeConverter
    public  String someObjectListToString(List<String> someObjects) {
        return gson.toJson(someObjects);
    }
}

