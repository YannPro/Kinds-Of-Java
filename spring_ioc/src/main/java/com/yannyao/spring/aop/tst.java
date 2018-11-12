package com.yannyao.spring.aop;

import com.yannyao.spring.aop.Music;
import com.yannyao.spring.aop.config.CGLIBProxy;

/**
 * @Auther: YJY
 * @Date: 2018/11/7 17:59
 * @Description:
 */
public class tst {
    public static void main(String[] args) {

        Music music = new Music();
        CGLIBProxy cglibProxy = null;
        try {
            cglibProxy = new CGLIBProxy(music);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Music m = cglibProxy.getProxy();
        m.sing("Dasd");
    }
}
