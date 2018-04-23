package com.sqli.challenge;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.stream.Collectors;

class TasksParser {
    static Queue<String> parse(String tasks) {
        return Arrays.stream(tasks.split(";")).collect(Collectors.toCollection(ArrayDeque::new));
    }
}
