package cn.smbms.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @program: smbmsproject
 * @description:
 * @author: lyp
 * @create: 2020-08-28 12:02:26
 **/
@Controller
@RequestMapping("/user")
public class HelloSpring {

    private static final Logger logger = Logger.getLogger(HelloSpring.class);

   /* @RequestMapping("/hello.html")
    public String hello(*//*@RequestParam("user")String username*//*){
        logger.info("hello springmvc"*//*+"============="+username*//*);
        return "welcome";
    }*/

    @RequestMapping(value = {"/world.html"},method = {RequestMethod.POST,RequestMethod.GET},
            params = {"user","pwd"})
    public String hello01(@RequestParam(value = "user") String username,
                        @RequestParam(value = "pwd")String password){
        logger.info("hello springmvc"+"---------"+username+"---------"+password);
        return "welcome";
    }

}
