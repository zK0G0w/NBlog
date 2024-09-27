package top.naccl.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.naccl.entity.Slogan;
import top.naccl.mapper.SloganMapper;
import top.naccl.service.SloganService;

import java.util.List;
import java.util.Random;

/**
 * @Description:
 * @Author: WainZeng
 * @Date: 2024/9/27 14:36
 */

@Service
public class SloganServiceImpl implements SloganService {

    @Autowired
    private SloganMapper sloganMapper;

    @Override
    public String getRandomSlogan() {
        List<Slogan> slogans = sloganMapper.getAllSlogans();
        if (slogans.isEmpty()) {
            return "No Slogans available";
        }
        Random random = new Random();
        Slogan randomSlogan = slogans.get(random.nextInt(slogans.size()));
        return randomSlogan.getContent();
    }

    @Override
    public void insertSlogan(Slogan slogan) {
        sloganMapper.insertSlogan(slogan);
    }
}
