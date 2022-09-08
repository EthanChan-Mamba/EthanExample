package com.ethanExample.springBatchExample.processor;

import com.ethanExample.springBatchExample.model.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

/**
 * @author chen
 * @version 1.0.0
 * @ClassName PersonItemProcessor.java
 * @Description TODO
 * @createTime 2022-09-08 11:19
 */
public class PersonItemProcessor
        implements ItemProcessor<Person, String> {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(PersonItemProcessor.class);

    @Override
    public String process(Person person) throws Exception {
        String greeting = "Hello " + person.getFirstName() + " "
                + person.getLastName() + "!";

        LOGGER.info("converting '{}' into '{}'", person, greeting);
        return greeting;
    }
}
