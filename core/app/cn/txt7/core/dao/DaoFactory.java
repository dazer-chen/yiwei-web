package cn.txt7.core.dao;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * Created with IntelliJ IDEA.
 * User: shijinkui
 * Date: 13-10-8
 * Time: 下午10:18
 * To change this template use File | Settings | File Templates.
 */
public class DaoFactory {
    private final static BeanFactory bf;

    static {
        Resource resource = new ClassPathResource("dao-beans.xml");
        bf = new XmlBeanFactory(resource);
    }

    public static ArticleDao getArticleDao() {
        return bf.getBean("articleDao", ArticleDao.class);
    }

}
