package com.sqli.challenge;

import java.util.*;

public class OsFacade {

    private static final int DEFAULT_QUANTUM_VALUE = 0;
    private List<Process> processList;
    private List<String> executionList;
    private int quantumValue;

    public OsFacade() {
        this.processList = new LinkedList<>();
        this.executionList = new LinkedList<>();
        this.quantumValue = DEFAULT_QUANTUM_VALUE;
    }

    public void createProcess(String processName, String tasks) {
        processList.add(new Process(processName, TasksParser.parse(tasks)));
    }

    public void run() {
        int index = 0;
        do {
            index = index % processList.size();
            Optional<String> execution = processList.get(index).run(quantumValue);
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
        quantumValue = number;
    }
}
