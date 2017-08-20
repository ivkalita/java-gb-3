package com.kalita_ivan.gb.lesson2.command;

class CommandResult {
    private boolean abort = false;
    private String result;

    CommandResult(String result) {
        this.result = result;
    }

    CommandResult(String result, boolean abort) {
        this.result = result;
        this.abort = abort;
    }

    boolean isAbort() {
        return abort;
    }

    String getResult() {
        return result;
    }
}
