package cn.jihongyun.aop.service;

import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class AnnotationCutPointService {

    private final static Logger log = Logger.getLogger("AnnotationCutPointService");

    public Boolean normal(Long normal) {
        log.info("normal() execute!");
        return Boolean.TRUE;
    }

    public Boolean exception(Long exception) {
        log.info("exception() execute!");
        throw new RuntimeException("unknown");
    }
}
