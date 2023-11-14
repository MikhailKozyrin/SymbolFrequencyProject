package com.example.symbolfrequencyproject.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class SymbolFrequencyController {

    @PostMapping("/calculationFrequency")
    public ResponseEntity<Map<Character, Integer>> calculationFrequency(@RequestBody Map<String, String> stringMap) {
        String inputString = stringMap.get("inputString");
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : inputString.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> sortedFrequencyMap = frequencyMap.entrySet().stream()
                .sorted(Map.Entry.<Character, Integer>comparingByValue().reversed())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        return ResponseEntity.ok(sortedFrequencyMap);

    }


}
