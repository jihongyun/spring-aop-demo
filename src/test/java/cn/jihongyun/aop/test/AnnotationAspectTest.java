package cn.jihongyun.aop.test;


import cn.jihongyun.aop.service.AnnotationCutPointService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationAspectTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
        AnnotationCutPointService xm = context.getBean(AnnotationCutPointService.class);
        xm.normal(1L);
        xm.exception(11L);
    }
}
