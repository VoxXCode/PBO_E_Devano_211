package com.praktikum.data;

public class Item {
    private String itemName;
    private String description;
    private String location;
    private String status;


    public Item(String itemName, String description, String location, String status) {
        if (itemName == null || itemName.trim().isEmpty()) {
            throw new IllegalArgumentException("Nama barang tidak boleh kosong");
        }
        this.itemName = itemName;
        this.description = description != null ? description : "";
        this.location = location != null ? location : "";
        this.status = status != null ? status : "Reported"; // Default status
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        if (itemName != null && !itemName.trim().isEmpty()) {
            this.itemName = itemName;
        }
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description != null ? description : "";
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location != null ? location : "";
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status != null ? status : "Reported";
    }
}