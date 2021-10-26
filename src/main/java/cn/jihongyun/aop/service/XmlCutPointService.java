package cn.jihongyun.aop.service;

import java.util.logging.Logger;

public class XmlCutPointService {

    private final static Logger log = Logger.getLogger("XmlCutPointService");

    public Boolean normal(Long normal) {
        log.info("normal() execute!");
        return Boolean.TRUE;
    }

    public Boolean exception(Long exception) {
        log.info("exception() execute!");
        throw new RuntimeException("unknown");
    }
}
