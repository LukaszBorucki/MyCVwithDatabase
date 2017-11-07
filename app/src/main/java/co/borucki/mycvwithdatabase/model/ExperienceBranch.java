package co.borucki.mycvwithdatabase.model;


import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "experienceBranch")
public class ExperienceBranch {
    @DatabaseField(columnName = "id", index = true)
    private int id;
    @DatabaseField(columnName = "branchPl")
    private String branchPl;
    @DatabaseField(columnName = "branchEn")
    private String branchEn;

    public ExperienceBranch() {
    }

    public ExperienceBranch(int id, String branchPl, String branchEn) {
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
