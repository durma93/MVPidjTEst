package com.example.durma.interfaceapplication;

public class ButtonTwo {
    private OnWidgetClickListener onWidgetClickListener;

    public void setOnWidgetClickListener(OnWidgetClickListener onWidgetClickListener) {
        this.onWidgetClickListener = onWidgetClickListener;
    }

    public ButtonTwo() {
    }


    /**
     *
     * Fires when a user click this button.
     *
     *
     * */
    private void onClick(){
        onWidgetClickListener.onClick(getViewId());
    }


    public int getViewId() {
        return 123456;
    }
}
