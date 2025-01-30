package itacademy.annotation;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {NoXmlConfiguration.class})
public class PersonServiceImplTest extends TestCase {
    @Autowired
    private PersonService personService;

    @Test
    public void personTest() {
        Assert.assertEquals("6", personService.getPerson().getId());
        Assert.assertEquals("PersonService", personService.getPerson().getName());
    }

}