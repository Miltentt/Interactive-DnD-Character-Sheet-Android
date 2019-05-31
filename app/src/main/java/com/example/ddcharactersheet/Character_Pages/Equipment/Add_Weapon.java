package com.example.ddcharactersheet.Character_Pages.Equipment;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.example.ddcharactersheet.Character;
import com.example.ddcharactersheet.Character_Databse;
import com.example.ddcharactersheet.Character_Pages.Equipment.Equipment;
import com.example.ddcharactersheet.EQ_Database;
import com.example.ddcharactersheet.Equipment_Entity;
import com.example.ddcharactersheet.R;

import java.util.LinkedList;
import java.util.List;

public class Add_Weapon extends AppCompatActivity {
private EditText name;
    private EditText bonus;
    private EditText dmg;
    private EditText crit;
    private EditText special;
    private EQ_Database EQDB;
    private int position;
    private List<Equipment_Entity> EQ = new LinkedList();
    private Character_Databse db;
    private List<Character> Characters = new LinkedList();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle extras = getIntent().getExtras();
        this.position = extras.getInt("position");
        setContentView(R.layout.add_weapon);
name = findViewById(R.id.name);
        bonus = findViewById(R.id.bonus);
        dmg = findViewById(R.id.dmg);
        crit = findViewById(R.id.crit);
        special = findViewById(R.id.special);
        EQDB = Room.databaseBuilder(getApplicationContext(), EQ_Database.class, "Charactersss")
                .allowMainThreadQueries()
                .build();

        db = Room.databaseBuilder(getApplicationContext(), Character_Databse.class, "Characters1")
                .allowMainThreadQueries()
                .build();
        Characters = db.characterdao().loadAllTasks();

    }
    void next(View v)
    { Equipment_Entity weaponn = new Equipment_Entity(1);
        weaponn.setName(name.getText().toString());
        weaponn.setBonus(bonus.getText().toString());
        weaponn.setCrit(crit.getText().toString());
        weaponn.setDmg(dmg.getText().toString());
        weaponn.setSpecial(special.getText().toString());
        EQDB.EQDao().Insert(weaponn);
        EQ = EQDB.EQDao().loadAllEQs();
        int lol = EQ.get(EQ.size()-1).getId();
        if (Characters.get(position).getIdw1() == -1) {
            Characters.get(position).setIdw1(lol);
            db.characterdao().updatechar(Characters.get(position));
        } else {
            if (Characters.get(position).getIdw2() == -1) {
                Characters.get(position).setIdw2(lol);
                db.characterdao().updatechar(Characters.get(position));
            } else {
                if (Characters.get(position).getIdw3() == -1) {
                    Characters.get(position).setIdw3(lol);
                    db.characterdao().updatechar(Characters.get(position));
                }
            }
        }
        Bundle extras = new Bundle();
        Intent i = new Intent(this, Equipment.class);
        extras.putInt("position", position);
        i.putExtras(extras);
        startActivity(i);
    }




}
