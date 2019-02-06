package org.paumard.lambdamasterclass.part2;

import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Test08_StreamingMaps {

    private List<String> sonnet = List.of(
            "From fairest creatures we desire increase,",
            "That thereby beauty's rose might never die,",
            "But as the riper should by time decease,",
            "His tender heir might bear his memory:",
            "But thou contracted to thine own bright eyes,",
            "Feed'st thy light's flame with self-substantial fuel,",
            "Making a famine where abundance lies,",
            "Thy self thy foe, to thy sweet self too cruel:",
            "Thou that art now the world's fresh ornament,",
            "And only herald to the gaudy spring,",
            "Within thine own bud buriest thy content,",
            "And, tender churl, mak'st waste in niggarding:",
            "Pity the world, or else this glutton be,",
            "To eat the world's due, by the grave and thee.",
            "to to thy");

    /**
     * Find the most frequently occurring words in the Sonnet
     */
    @Test
    public void streamingMaps_1() {

        Pattern pattern = Pattern.compile(("[ ,':\\-]+"));

        Map<String, Long> wordFrequencies = sonnet.stream()
                .map(String::toLowerCase)
                .flatMap(pattern::splitAsStream)
                .collect(
                        Collectors.groupingBy(
                                word -> word,
                                Collectors.counting()
                        )
                );
        wordFrequencies.forEach(
                (word, frequency) -> System.out.println(String.format("[%d] <= %s", frequency, word))
        );

        Map.Entry<String, Long> mostFrequentWord = wordFrequencies.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .orElseThrow();

        System.out.println(String.format("%slongest word is %s", "\n", mostFrequentWord));
    }
}
