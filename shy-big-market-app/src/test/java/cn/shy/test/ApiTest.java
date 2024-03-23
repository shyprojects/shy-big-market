package cn.shy.test;

import cn.shy.infrastructure.persistent.dao.IAwardDao;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class ApiTest {

    @Resource
    private IAwardDao awardDao;
    
    @Test
    public void test() {
        System.err.println(awardDao.queryAwardList());
        log.info("测试完成");
    }

}
