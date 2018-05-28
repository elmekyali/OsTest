package com.sqli.challenge;

public class OsFacade {

    private final Os os;
    private final TasksParser tasksParser;

    public OsFacade() {
        this.os = new Os();
        this.tasksParser = new DefaultTasksParser();
    }

    public void createProcess(String processName, String tasks) {
        this.os.add(new Process(processName, tasksParser.parse(tasks)));
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
