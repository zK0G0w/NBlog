package top.naccl.service;

import top.naccl.entity.Slogan;

/**
 * @Description:
 * @Author: WainZeng
 * @Date: 2024/9/27 14:35
 */

public interface SloganService {
    /**
     * 获取一个随机的 Slogan
     * @return 随机 Slogan 内容
     */
    String getRandomSlogan();

    void insertSlogan(Slogan slogan);
}
