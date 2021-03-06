package com.alibaba.cacher.cases;

import com.alibaba.cacher.cases.base.TestBase;
import com.alibaba.cacher.domain.User;
import com.alibaba.cacher.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * @author jifang
 * @since 16/7/20 上午10:51.
 */
public class SingleTest extends TestBase {

    @Autowired
    private UserService service;

    @Test
    public void testSingleKey() throws InterruptedException {
        int id = 1;
        User user = service.singleKey(id, "ff-no-key", "no-key");
        user = service.singleKey(id, "ff-no-key", "ls");

        //Thread.sleep(10000000);
    }

    @Test
    public void testRemoveSingleKey() {
        int id = 1;
        String name = "fq";
        service.singleRemove(id, name, "not`non");
    }

    @Test
    public void testUpdateSingleKey() {
        User user = new User();
        user.setId(1);
        String name = "fq";
        service.updateUser(user, name, "not");
    }

    @Test
    public void testSpEL() {
        User user = new User(1, "feiqing", new Date(), 1, "hangz");
        service.spelCompose(user);
    }
}
