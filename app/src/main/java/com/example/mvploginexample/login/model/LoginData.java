package com.example.mvploginexample.login.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginData {

    @SerializedName("TCID")
    @Expose
    private String tCID;
    @SerializedName("CP_FIRST_NAME")
    @Expose
    private String cPFIRSTNAME;
    @SerializedName("CP_LAST_NAME")
    @Expose
    private String cPLASTNAME;
    @SerializedName("CP_EMAIL")
    @Expose
    private String cPEMAIL;
    @SerializedName("CP_MOBILE_NUMBER")
    @Expose
    private String cPMOBILENUMBER;
    @SerializedName("CP_PHOTO_PATH")
    @Expose
    private String cPPHOTOPATH;
    @SerializedName("CP_RATING")
    @Expose
    private String cPRATING;
    @SerializedName("paymentMethodAdded")
    @Expose
    private Boolean paymentMethodAdded;

    public String getTCID() {
        return tCID;
    }

    public void setTCID(String tCID) {
        this.tCID = tCID;
    }

    public String getCPFIRSTNAME() {
        return cPFIRSTNAME;
    }

    public void setCPFIRSTNAME(String cPFIRSTNAME) {
        this.cPFIRSTNAME = cPFIRSTNAME;
    }

    public String getCPLASTNAME() {
        return cPLASTNAME;
    }

    public void setCPLASTNAME(String cPLASTNAME) {
        this.cPLASTNAME = cPLASTNAME;
    }

    public String getCPEMAIL() {
        return cPEMAIL;
    }

    public void setCPEMAIL(String cPEMAIL) {
        this.cPEMAIL = cPEMAIL;
    }

    public String getCPMOBILENUMBER() {
        return cPMOBILENUMBER;
    }

    public void setCPMOBILENUMBER(String cPMOBILENUMBER) {
        this.cPMOBILENUMBER = cPMOBILENUMBER;
    }

    public String getCPPHOTOPATH() {
        return cPPHOTOPATH;
    }

    public void setCPPHOTOPATH(String cPPHOTOPATH) {
        this.cPPHOTOPATH = cPPHOTOPATH;
    }

    public String getCPRATING() {
        return cPRATING;
    }

    public void setCPRATING(String cPRATING) {
        this.cPRATING = cPRATING;
    }

    public Boolean getPaymentMethodAdded() {
        return paymentMethodAdded;
    }

    public void setPaymentMethodAdded(Boolean paymentMethodAdded) {
        this.paymentMethodAdded = paymentMethodAdded;
    }

}