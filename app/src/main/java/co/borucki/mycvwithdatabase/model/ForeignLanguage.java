package co.borucki.mycvwithdatabase.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "foreignLanguage")
public class ForeignLanguage {
    @DatabaseField(columnName = "id", id = true)
    private int id;
    @DatabaseField(columnName = "namePl")
    private String namePl;
    @DatabaseField(columnName = "nameEn")
    private String nameEn;
    @DatabaseField(columnName = "level")
    private String level;
    @DatabaseField(columnName = "logo")
    private String logo;

    public ForeignLanguage() {
    }

    public ForeignLanguage(int id, String namePl, String nameEn, String level, String logo) {
        this.id = id;
        this.namePl = namePl;
        this.nameEn = nameEn;
        this.level = level;
        this.logo = logo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }
}
