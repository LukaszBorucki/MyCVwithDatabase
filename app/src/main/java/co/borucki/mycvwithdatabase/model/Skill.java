package co.borucki.mycvwithdatabase.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "skill")
public class Skill {
    @DatabaseField(columnName = "id", index = true)
    private int id;
    @DatabaseField(columnName = "type")
    private String type;
    @DatabaseField(columnName = "namePl")
    private String namePl;
    @DatabaseField(columnName = "nameEn")
    private String nameEn;
    @DatabaseField(columnName = "level")
    private int level;

    public Skill() {
    }

    public Skill(int id, String type, String namePl, String nameEn, int level) {
        this.id = id;
        this.type = type;
        this.namePl = namePl;
        this.nameEn = nameEn;
        this.level = level;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
