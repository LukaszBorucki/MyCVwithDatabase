package co.borucki.mycvwithdatabase.model;


public class ExperiencePeriod {
    private int id;
    private String periodFrom;
    private String periodTo;
    private String position;
    private String language;
    private int companyId;

    public ExperiencePeriod() {
    }

    public ExperiencePeriod(int id, String periodFrom, String periodTo, String position
            , String language, int companyId) {
        this.id = id;
        this.periodFrom = periodFrom;
        this.periodTo = periodTo;
        this.position = position;
        this.language = language;
        this.companyId = companyId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPeriodFrom() {
        return periodFrom;
    }

    public void setPeriodFrom(String periodFrom) {
        this.periodFrom = periodFrom;
    }

    public String getPeriodTo() {
        return periodTo;
    }

    public void setPeriodTo(String periodTo) {
        this.periodTo = periodTo;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }
}
