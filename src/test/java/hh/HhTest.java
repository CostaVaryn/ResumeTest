package hh;

import core.BaseTest;
import junit.framework.Assert;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static junit.framework.Assert.assertEquals;

public class HhTest extends BaseTest {
    private final static String URL = "https://hh.ru/applicant/resumes/view?resume=1edf0c93ff095811d20039ed1f6a3638497073";

    @Test
    public void checkAttributesHashMap(){
        HhResumePage hhResumePage = new HhResumePage(URL);
        Map<String,Object> expectedAttributes = new HashMap<>();
        expectedAttributes.put(HhResumePage.GENDER, "М");
        expectedAttributes.put(HhResumePage.AGE, "26");
        expectedAttributes.put(HhResumePage.CITY, "Санкт-Петербург");
        expectedAttributes.put(HhResumePage.CONFIRMED_PHONE, true);
        expectedAttributes.put(HhResumePage.READY_TO_RELOCATE, false);

        Map<String,Object> actualAttributes = hhResumePage.getAttributes();

        Assert.assertEquals(expectedAttributes,actualAttributes);
    }

    @Test
    public void checkAttributesClass(){
        HhResumePage hhResumePage = new HhResumePage(URL);
        Resume expectedAttributes = new Resume("М", 26,"Санкт-Петербург",
                true,false);
        Resume actualAttributes = new Resume(hhResumePage.getGender(),hhResumePage.getAge(),hhResumePage.getCity(),
                hhResumePage.isPhoneConfirmed(),hhResumePage.isReadyToRelocate());

        // 1 способ сравнения классов
        // Assert.assertTrue(EqualsBuilder.reflectionEquals(expectedAttributes,actualAttributes));

        // 2 способ сравнения отдельных переменных в классе
        assertEquals(expectedAttributes.getGender(),actualAttributes.getGender());
        assertEquals(expectedAttributes.getAge(),actualAttributes.getAge());
        assertEquals(expectedAttributes.getCity(),actualAttributes.getCity());
        assertEquals(expectedAttributes.isPhoneConfirmed(),actualAttributes.isPhoneConfirmed());
        assertEquals(expectedAttributes.isReadyToRelocate(),actualAttributes.isReadyToRelocate());


    }
}
