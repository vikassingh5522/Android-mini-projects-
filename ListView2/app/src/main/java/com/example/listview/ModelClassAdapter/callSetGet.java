package com.example.listview.ModelClassAdapter;

public class callSetGet {
    private String name;
    private String contactNumber;
    private String callCount;  // Added field for call count

    public callSetGet(String name, String contactNumber, String callCount) {
        this.name = name;
        this.contactNumber = contactNumber;
        this.callCount = callCount;
    }

    public String getName() {
        return name;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public String getCallCount() {
        return callCount;
    }
}
