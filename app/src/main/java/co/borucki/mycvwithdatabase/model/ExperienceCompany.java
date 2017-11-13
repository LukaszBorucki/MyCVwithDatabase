package co.borucki.mycvwithdatabase.model;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "experienceCompany")
public class ExperienceCompany {
    @DatabaseField(columnName = "id", id = true)
    private int id;
    @DatabaseField(columnName = "branchId")
    private int branchId;
    @DatabaseField(columnName = "name")
    private String name;
    @DatabaseField(columnName = "logotype", dataType = DataType.SERIALIZABLE)
    private byte[] logotype;

    public ExperienceCompany() {
    }

    public ExperienceCompany(int id, int branchId, String name, byte[] logotype) {
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

    public byte[] getLogotype() {
        return logotype;
    }

    public void setLogotype(byte[] logotype) {
        this.logotype = logotype;
    }
}
