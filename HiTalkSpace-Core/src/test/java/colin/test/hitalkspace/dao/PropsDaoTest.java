package colin.test.hitalkspace.dao;

import colin.test.hitalkspace.CommonDaoTest;
import colin.web.hitalkspace.core.dao.PropsDao;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author LinQiang on 2016/12/15.
 * @reviewer
 */
public class PropsDaoTest extends CommonDaoTest {

    @Autowired
    private PropsDao propsDap;

    @Test
    public void testGetPropsVal() {
        String result = propsDap.getPropsVal("test");
        System.out.println("查询到的结果是" + result);
        Assert.assertEquals("colin", result);
        String result2 = propsDap.getPropsVal("fakeName");
        System.out.println("查询到的结果是" + result2);
        Assert.assertEquals("colin", result2);
    }
}
