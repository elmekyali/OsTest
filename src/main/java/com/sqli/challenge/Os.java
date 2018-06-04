package com.sqli.challenge;

import java.util.*;

class Os {
    private int quantum;
    private Queue<Process> processList;
    private Collection<String> executionList;

    Os() {
        this.quantum = 0;
        this.processList = new ArrayDeque<>();
        this.executionList = new LinkedList<>();
    }

    void add(Process process) {
        this.processList.add(process);
    }

    void runAllProcess() {
        while (!processList.isEmpty()) {
            Process process = processList.poll();
            Optional<String> currentExecution = process.run(this.quantum);
            currentExecution.ifPresent(execution -> {
                this.executionList.add(execution);
                processList.add(process);
            });
        }
    }

    String result() {
        return String.join("", this.executionList);
    }

    void addQuantum(int quantum) {
        this.quantum = quantum;
    }
}
