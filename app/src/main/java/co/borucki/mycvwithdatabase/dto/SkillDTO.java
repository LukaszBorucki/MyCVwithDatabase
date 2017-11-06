package co.borucki.mycvwithdatabase.dto;

public class SkillDTO {
    private int id;
    private String type;
    private String namePl;
    private String nameEn;
    private int level;

    public SkillDTO() {
    }

    public SkillDTO(int id, String type, String namePl, String nameEn, int level) {
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
