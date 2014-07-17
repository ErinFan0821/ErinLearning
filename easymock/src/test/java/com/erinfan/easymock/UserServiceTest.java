package com.erinfan.easymock;

import org.junit.Before;
import org.junit.Test;

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
}
