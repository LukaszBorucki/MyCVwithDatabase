package co.borucki.mycvwithdatabase.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "additional")
public class Additional {
    @DatabaseField(columnName = "id", id = true)
    private int id;
    @DatabaseField(columnName = "date")
    private String date;
    @DatabaseField(columnName = "namePl")
    private String namePl;
    @DatabaseField(columnName = "nameEn")
    private String nameEn;

    public Additional() {
    }

    public Additional(int id, String date, String namePl, String nameEn) {
        this.id = id;
        this.date = date;
        this.namePl = namePl;
        this.nameEn = nameEn;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getNamePl() {
        return namePl;
    }

    public void setNamePl(String namePl) {
        this.namePl = namePl;
    }

    public String getNameEn() {
        return nameEn;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }
}

