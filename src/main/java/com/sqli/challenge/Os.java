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
        Process process;
        while ((process = processList.poll()) != null) {
            Optional<String> execution = process.run(this.quantum);
            execution.ifPresent(execution_ -> {
                this.executionList.add(execution_);
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
