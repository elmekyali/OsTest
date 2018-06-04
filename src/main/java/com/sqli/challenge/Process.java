package com.sqli.challenge;

import java.util.*;
import java.util.stream.Collectors;

class Process {
    private String processName;
    private Queue<String> tasks;

    Process(String processName, String tasks) {
        this.processName = processName;
        this.tasks = Arrays.stream(tasks.split(";")).collect(Collectors.toCollection(ArrayDeque::new));
    }

    Optional<String> run(int quantumValue) {
        quantumValue = (quantumValue == 0) ? tasks.size() : quantumValue;
        StringBuilder out = new StringBuilder();
        while (quantumValue-- > 0 && !tasks.isEmpty()) {
            String task = tasks.poll();
            out.append(execute(task));
        }
        return out.toString().equals("") ? Optional.empty() : Optional.of(out.toString());
    }

    private String execute(String task) {
        return String.format("<<%s>>%s", processName, task);
    }
}
