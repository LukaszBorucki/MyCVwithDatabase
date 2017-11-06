package co.borucki.mycvwithdatabase.dto;


public class ExperienceCompanyDTO {
    private int id;
    private int branchId;
    private String name;
    private String logotype;

    public ExperienceCompanyDTO() {
    }

    public ExperienceCompanyDTO(int id, int branchId, String name, String logotype) {
        this.id = id;
        this.branchId = branchId;
        this.name = name;
        this.logotype = logotype;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBranchId() {
        return branchId;
    }

    public void setBranchId(int branchId) {
        this.branchId = branchId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogotype() {
        return logotype;
    }

    public void setLogotype(String logotype) {
        this.logotype = logotype;
    }
}
