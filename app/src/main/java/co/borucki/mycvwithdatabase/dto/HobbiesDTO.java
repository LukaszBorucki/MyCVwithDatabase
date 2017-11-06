package co.borucki.mycvwithdatabase.dto;


public class HobbiesDTO {
    private int id;
    private String namePl;
    private String nameEn;
    private String logo;

    public HobbiesDTO() {
    }

    public HobbiesDTO(int id, String namePl, String nameEn, String logo) {
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

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }
}
