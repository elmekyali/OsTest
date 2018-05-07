package com.sqli.challenge;

import java.util.Optional;
import java.util.Queue;

class Process {
    private String processName;
    private Queue<String> tasks;

    Process(String processName, Queue<String> tasks) {
        this.processName = processName;
        this.tasks = tasks;
    }

    Optional<String> run(int quantumValue) {
        quantumValue = quantumValue == 0 ? tasks.size() : quantumValue;
        StringBuilder out = new StringBuilder();
        String task;
        while (quantumValue-- > 0 && (task = tasks.poll()) != null) {
            out.append(execute(task));
        }
        return out.toString().equals("") ? Optional.empty() : Optional.of(out.toString());
    }

    private String execute(String task) {
        return String.format("<<%s>>%s", processName, task);
    }
}
