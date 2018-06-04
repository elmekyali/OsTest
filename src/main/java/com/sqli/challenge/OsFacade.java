package com.sqli.challenge;

public class OsFacade {
    private final Os os;

    public OsFacade() {
        this.os = new Os();
    }

    public void createProcess(String processName, String tasks) {
        this.os.add(new Process(processName, tasks));
    }

    public void run() {
        this.os.runAllProcess();
    }

    public String getExecutionResult() {
        return this.os.result();
    }

    public void useRoundRobin(int quantum) {
        this.os.addQuantum(quantum);
    }
}
