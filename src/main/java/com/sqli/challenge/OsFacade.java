package com.sqli.challenge;

import java.util.*;

public class OsFacade {

    private List<Process> processList;
    private List<String> executionList;
    private int roundRobinValue;

    public OsFacade() {
        this.processList = new LinkedList<>();
        this.executionList = new LinkedList<>();
        this.roundRobinValue = 0;
    }

    public void createProcess(String processName, String tasks) {
        processList.add(new Process(processName, TasksParser.parse(tasks)));
    }

    public void run() {
        int index = 0;
        do {
            index = index % processList.size();
            Optional<String> execution = processList.get(index).run(roundRobinValue);
            if (execution.isPresent()) {
                executionList.add(execution.get());
            } else {
                processList.remove(index);
            }
            index++;
        } while (processList.size() != 0);
    }

    public String getExecutionResult() {
        return String.join("", executionList);
    }

    public void useRoundRobin(int number) {
        roundRobinValue = number;
    }
}
