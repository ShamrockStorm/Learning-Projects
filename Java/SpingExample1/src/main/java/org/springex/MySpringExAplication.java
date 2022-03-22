package org.springex;

import org.springex.config.MySpringExConfig;
import org.springex.service.DictionaryService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MySpringExAplication {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MySpringExConfig.class);
        System.out.println(context.getBean(DictionaryService.class).define("Usa"));
    }
}
