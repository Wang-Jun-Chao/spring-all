package com.example.spring.boot.batch;

import com.example.spring.boot.domain.Person;
import org.springframework.batch.item.validator.ValidatingItemProcessor;
import org.springframework.batch.item.validator.ValidationException;

/**
 * Author: 王俊超
 * Date: 2017-07-20 07:50
 * All Rights Reserved !!!
 */
public class CsvItemProcessor extends ValidatingItemProcessor<Person> {
    @Override
    public Person process(Person item) throws ValidationException {
        super.process(item);

        if (item.getNation().equals("汉族")) {
            item.setNation("01");
        } else {
            item.setNation("02");
        }

        return item;
    }
}
