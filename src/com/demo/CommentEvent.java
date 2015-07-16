package com.demo;

public enum CommentEvent {
    LIKE("comment/like"),
    DISLIKE("comment/unlike"),
    REMOVE("comment/remove");

    private String cmd;

    private CommentEvent(String cmd) {
        this.cmd = cmd;
    }

    public String cmd() {
        return cmd;
    }
}
