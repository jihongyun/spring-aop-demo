package cn.jihongyun.aop.test;

import cn.jihongyun.aop.service.XmlCutPointService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class XmlTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
        XmlCutPointService xm = (XmlCutPointService) context.getBean("xmlCutPointService");
        xm.normal(1L);
        xm.exception(11L);

    }
}
