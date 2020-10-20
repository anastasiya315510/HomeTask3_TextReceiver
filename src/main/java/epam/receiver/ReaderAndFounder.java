package epam.receiver;


import com.sun.source.tree.IdentifierTree;
import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReaderAndFounder {

    @SneakyThrows
    public static  Map<String, Long>  wordsReader(File file){
        BufferedReader br = new BufferedReader(new FileReader(file));


        return br.lines().flatMap(line -> Arrays.stream(line.split(" ")))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream().sorted((e1,e2)->
                        Long.compare(e2.getValue(), e1.getValue()))
                .limit(3)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (e1, e2) -> e1, LinkedHashMap::new));


    }
}
