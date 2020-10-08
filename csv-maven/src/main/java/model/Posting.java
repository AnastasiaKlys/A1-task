package model;

import java.sql.Date;
import java.util.Objects;

public class Posting {
    private Long id;
    private String matDoc;
    private String item;
    private String docDate;
    private String pstngDate;
    private String materialDescription;
    private String quantity;
    private String bun;
    private String amountLc;
    private String crcy;
    private String userName;
    private Boolean authorizedDelivery;

    public Posting(String matDoc, String item, String docDate, String pstngDate, String materialDescription, String quantity, String bun, String amountLc, String crcy, String userName, Boolean authorizedDelivery) {
        this.matDoc = matDoc;
        this.item = item;
        this.docDate = docDate;
        this.pstngDate = pstngDate;
        this.materialDescription = materialDescription;
        this.quantity = quantity;
        this.bun = bun;
        this.amountLc = amountLc;
        this.crcy = crcy;
        this.userName = userName;
        this.authorizedDelivery = authorizedDelivery;
    }

    public Posting(String matDoc, String item, String docDate, String pstngDate, String materialDescription, String quantity, String bun, String amountLc, String crcy, String userName) {
        this.matDoc = matDoc;
        this.item = item;
        this.docDate = docDate;
        this.pstngDate = pstngDate;
        this.materialDescription = materialDescription;
        this.quantity = quantity;
        this.bun = bun;
        this.amountLc = amountLc;
        this.crcy = crcy;
        this.userName = userName;
    }

    public Boolean getAuthorizedDelivery() {
        return authorizedDelivery;
    }

    public String getDocDate() {
        return docDate;
    }

    public void setDocDate(String docDate) {
        this.docDate = docDate;
    }

    public String getPstngDate() {
        return pstngDate;
    }

    public void setPstngDate(String pstngDate) {
        this.pstngDate = pstngDate;
    }

    public void setAuthorizedDelivery(Boolean authorizedDelivery) {
        this.authorizedDelivery = authorizedDelivery;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public String getCrcy() {
        return crcy;
    }

    public void setCrcy(String crcy) {
        this.crcy = crcy;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMatDoc() {
        return matDoc;
    }

    public void setMatDoc(String matDoc) {
        this.matDoc = matDoc;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getMaterialDescription() {
        return materialDescription;
    }

    public void setMaterialDescription(String materialDescription) {
        this.materialDescription = materialDescription;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getBun() {
        return bun;
    }

    public void setBun(String bun) {
        this.bun = bun;
    }

    public String getAmountLc() {
        return amountLc;
    }

    public void setAmountLc(String amountLc) {
        this.amountLc = amountLc;
    }
}
