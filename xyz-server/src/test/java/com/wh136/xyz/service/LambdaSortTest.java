package com.wh136.xyz.service;


import com.google.common.collect.Lists;
import com.wh136.xyz.XyzApplication;
import com.wh136.xyz.entity.Human;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = XyzApplication.class)
@ActiveProfiles("hzgreen")
@Slf4j
public class LambdaSortTest {

     /**
     * https://www.baeldung.com/java-8-sort-lambda
     * * Sorting a List in Reverse With Stream.sorted()
     * We can also use Stream.sorted() to sort a collection in reverse.
     *
     * First, let's see an example of how to combine the sorted() method with
     * Comparator.reverseOrder() to sort a list in the reverse natural order:
     *
     * */

     @Test
     public final void
     givenStreamNaturalOrdering_whenSortingEntitiesByNameReversed_thenCorrectlySorted() {
         List<String> letters = Lists.newArrayList("B", "A", "C");

         List<String> reverseSortedLetters = letters.stream()
                 .sorted(Comparator.reverseOrder())
                 .collect(Collectors.toList());

         assertThat(reverseSortedLetters.get(0), equalTo("C"));
     }

    @Test
    public final void
    givenStreamComparatorOrdering_whenSortingEntitiesByNameReversed_thenCorrectlySorted() {
        List<Human> humans = Lists.newArrayList(new Human("Sarah", 10), new Human("Jack", 12));

        List<Human> reverseSortedHumans = humans.stream()
                .sorted(Comparator.comparing(Human::getName, Comparator.reverseOrder()))
                .collect(Collectors.toList());

        assertThat(reverseSortedHumans.get(0), equalTo(new Human("Sarah", 10)));
    }

    @Test
    public final void
    sortWithStreamLambda() {
        List<Human> humans = Lists.newArrayList(new Human("Sarah", 10),
                new Human("Jack", 30), new Human("Ethan", 12),
                new Human("Tom", 40));
        List<Human> reversedResult = humans.stream()
                .sorted(Comparator.comparing(Human::getAge).reversed())
                .collect(Collectors.toList());
        log.info("[reversed] {} ", reversedResult.toString());

    }

}
