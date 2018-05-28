package com.sqli.challenge;

import java.util.*;
import java.util.stream.Collectors;

class DefaultTasksParser implements TasksParser {
    public Collection<String> parse(String tasks) {
        return Arrays.stream(tasks.split(";")).collect(Collectors.toList());
    }
}
