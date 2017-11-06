package co.borucki.mycvwithdatabase.dto;


public class ForeignLanguageDTO {
    private int id;
    private String namePl;
    private String nameEn;
    private String level;
    private String logo;

    public ForeignLanguageDTO() {
    }

    public ForeignLanguageDTO(int id, String namePl, String nameEn, String level, String logo) {
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
