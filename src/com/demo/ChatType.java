package com.demo;

public enum ChatType {
    SECRET("", ""), GROUP("", ""), GROUP_SINGLE("", "");

    ChatType(String readAction, String newMessageAction) {
        this.readAction = readAction;
        this.newMessageAction = newMessageAction;
    }

    private String readAction;
    private String newMessageAction;

    public String readAction() {
        return readAction;
    }

    public String newMessageAction() {
        return newMessageAction;
    }
}
