package com.erinfan.easymock;

import com.sun.deploy.util.StringUtils;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertTrue;
import static org.easymock.EasyMock.*;

/**
 * Created by techops on 7/17/14.
 */
public class UserServiceTest {

    private UserService userService;
    private UserDao userDao;

    @Before
    public void setUp() throws Exception {
        userService = new UserService();
        userDao = createMock(UserDao.class);
        userService.setUserDao(userDao);
    }

    @Test
    public void should_register_user_success_if_vip_user() throws Exception {
        final User user = new User();
        user.type = "vip";

        expect(userDao.insertUser(user)).andReturn(true);

        replay(userDao);
        assertTrue(userService.registerUser(user));
        verify(userDao);
    }

    @Test
    public void should_TEst() throws Exception {
        List<String> string1 = createStrings("a", "b");
        List<String> string2 = createStrings("a", null);
        List<String> string3 = createStrings(null, "b");
        List<String> string4 = createStrings(null, null);

        System.out.println(StringUtils.join(string2, ", "));
        System.out.println(StringUtils.join(string2, ", "));
        System.out.println(StringUtils.join(string2, ", "));
        System.out.println(StringUtils.join(string2, ", "));


    }

    @Test
    public void should_replace_two_int_values() throws Exception {
        int first = 1;
        int second = 2;

        ActionErrors errors = new ActionErrors();
    }

    private List<String> createStrings(String a, String b) {
        List<String> first = new ArrayList<>();
        first.add(a);
        first.add(b);
        return first;
    }
}

SELECT C.NAME AS CUSTOMER_NAME, P.NAME AS PRODUCT_NAME, P.PRICE, PR.QUANTITY, P.PRICE * PR.QUANTITY AS TOTLE, PR.CREATE_TIME , sum(P.PRICE * PR.QUANTITY) FROM CUSTOMERS AS C LEFT JOIN PURCHASES AS PR ON PR.CUSTOMER_ID=C.CUSTOMER_NO LEFT JOIN PRODUCTS AS P ON P.ID = PR.PRODUCT_ID group by MONTH(PR.CREATE_TIME);
