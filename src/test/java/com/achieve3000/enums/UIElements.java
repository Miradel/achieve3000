package com.achieve3000.enums;

public enum UIElements {

    OurPartners("Our Partners") ;

    private String value;

    public String getValue() {
        return value;
    }

     private UIElements(String value) {
        this.value = value;
    }
}
