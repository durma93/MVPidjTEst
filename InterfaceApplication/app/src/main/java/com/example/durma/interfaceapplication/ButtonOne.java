package com.example.durma.interfaceapplication;

public class ButtonOne {
    private MainActivityOne mainActivityOne;

    public ButtonOne() {
    }

    public void setMainActivityOne(MainActivityOne mainActivityOne) {
        this.mainActivityOne = mainActivityOne;
    }
    /**
     *
     * Fires when a user click this button.
     *
     *
     * */
    private void onClick(){
        mainActivityOne.onClick(getViewId());
    }


    public int getViewId() {
        return 123456;
    }
}
