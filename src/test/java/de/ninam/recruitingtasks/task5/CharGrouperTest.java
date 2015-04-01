package de.ninam.recruitingtasks.task5;

import de.ninam.recruitingtasks.TasksConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TasksConfig.class)
public class CharGrouperTest {

    @Autowired
    private CharGrouper charGrouper;

    @Test
    public void testGroup() {

        assertEquals("a4bins2uz", charGrouper.group("abzuaaissna"));
    }
}