package co.borucki.mycvwithdatabase.model;


import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "experienceProject")
public class ExperienceProject {
    @DatabaseField(columnName = "id", id = true)
    private int id;
    @DatabaseField(columnName = "descriptionPl")
    private String descriptionPl;
    @DatabaseField(columnName = "descriptionEn")
    private String descriptionEn;
    @DatabaseField(columnName = "companyId")
    private int companyId;

    public ExperienceProject() {
    }

    public ExperienceProject(int id, String descriptionPl, String descriptionEn, int companyId) {
        this.id = id;
        this.descriptionPl = descriptionPl;
        this.descriptionEn = descriptionEn;
        this.companyId = companyId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescriptionPl() {
        return descriptionPl;
    }

    public void setDescriptionPl(String descriptionPl) {
        this.descriptionPl = descriptionPl;
    }

    public String getDescriptionEn() {
        return descriptionEn;
    }

    public void setDescriptionEn(String descriptionEn) {
        this.descriptionEn = descriptionEn;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }
}
