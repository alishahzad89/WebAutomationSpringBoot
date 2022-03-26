package com.cucumber.springboot.utils.browsers;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class BrowserFactory {
    static Map<String, Browser> operationMap = new HashMap<>();

    static {
        operationMap.put("chrome", new Chrome());
        operationMap.put("edge", new IE());
        operationMap.put("firefox", new FireFox());
    }

    public static Optional<Browser> getOperation(String operator) {
        return Optional.ofNullable(operationMap.get(operator));
    }

}
