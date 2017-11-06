package co.borucki.mycvwithdatabase.dto;



public class ExperienceBranchDTO {
    private int id;
    private String branchPl;
    private String branchEn;

    public ExperienceBranchDTO() {
    }

    public ExperienceBranchDTO(int id, String branchPl, String branchEn) {
        this.id = id;
        this.branchPl = branchPl;
        this.branchEn = branchEn;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBranchPl() {
        return branchPl;
    }

    public void setBranchPl(String branchPl) {
        this.branchPl = branchPl;
    }

    public String getBranchEn() {
        return branchEn;
    }

    public void setBranchEn(String branchEn) {
        this.branchEn = branchEn;
    }
}
