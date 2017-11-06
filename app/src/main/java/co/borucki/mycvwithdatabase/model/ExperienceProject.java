package co.borucki.mycvwithdatabase.model;



public class ExperienceProject {
    private int id;
    private String descriptionPl;
    private String descriptionEn;
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
