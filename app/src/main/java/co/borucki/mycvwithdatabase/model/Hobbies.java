package co.borucki.mycvwithdatabase.model;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "hobbies")
public class Hobbies {
    @DatabaseField(columnName = "id", id = true)
    private int id;
    @DatabaseField(columnName = "namePl")
    private String namePl;
    @DatabaseField(columnName = "nameEn")
    private String nameEn;
    @DatabaseField(columnName = "logo", dataType = DataType.SERIALIZABLE)
    private byte[] logo;

    public Hobbies() {
    }

    public Hobbies(int id, String namePl, String nameEn, byte[] logo) {
        this.id = id;
        this.namePl = namePl;
        this.nameEn = nameEn;
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

    public byte[] getLogo() {
        return logo;
    }

    public void setLogo(byte[] logo) {
        this.logo = logo;
    }
}
