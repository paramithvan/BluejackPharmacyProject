package com.example.bluejackpharmacyproject.data;

public class MedicineData {

    private int MedId;
    private int img;
    private String name;
    private String pabrik;
    private int price;
    private String medDesc;

    public int getMedId() {
        return MedId;
    }

    public void setMedId(int medId) {
        MedId = medId;
    }
    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPabrik() {
        return pabrik;
    }

    public void setPabrik(String pabrik) {
        this.pabrik = pabrik;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getMedDesc() {
        return medDesc;
    }

    public void setMedDesc(String medDesc) {
        this.medDesc = medDesc;
    }

    public MedicineData(int MedId, int img, String name, String pabrik, int price, String medDesc) {
        this.MedId = MedId;
        this.img = img;
        this.name = name;
        this.pabrik = pabrik;
        this.price = price;
        this.medDesc = medDesc;
    }
}

