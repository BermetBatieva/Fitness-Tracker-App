package com.example.fitnesstrackerapp.data;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "way_table")
public class Way {
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "speed")
    private String speed;

    @ColumnInfo(name = "length")
    private String length;

    @ColumnInfo(name = "time")
    private long time;

    public Way() {

    }

    public Way(String speed, String length, long time) {
        this.speed = speed;
        this.length = length;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }
}