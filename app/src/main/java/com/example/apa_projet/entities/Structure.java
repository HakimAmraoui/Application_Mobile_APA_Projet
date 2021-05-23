package com.example.apa_projet.entities;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Structure {

    @PrimaryKey(autoGenerate = true)
    private Long id;
    @NonNull
    private String name;
    @NonNull
    private String discipline;
    @NonNull
    private String pathologyList;

    public Structure() {
    }

    public Structure(Long id, @NonNull String name, @NonNull String discipline, @NonNull String pathologyList) {
        this.id = id;
        this.name = name;
        this.discipline = discipline;
        this.pathologyList = pathologyList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @NonNull
    public String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    @NonNull
    public String getDiscipline() {
        return discipline;
    }

    public void setDiscipline(@NonNull String discipline) {
        this.discipline = discipline;
    }

    @NonNull
    public String getPathologyList() {
        return pathologyList;
    }

    public void setPathologyList(@NonNull String pathologyList) {
        this.pathologyList = pathologyList;
    }

    @Override
    public String toString() {
        return "Structure{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", discipline='" + discipline + '\'' +
                ", pathologyList='" + pathologyList + '\'' +
                '}';
    }
}
