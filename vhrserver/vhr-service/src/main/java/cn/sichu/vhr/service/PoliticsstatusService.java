package cn.sichu.vhr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.sichu.vhr.mapper.PoliticsstatusMapper;
import cn.sichu.vhr.model.Politicsstatus;

/**
 * 
 * @author sichu
 * @date 2022/05/12
 */
@Service
public class PoliticsstatusService {
    @Autowired
    PoliticsstatusMapper politicsstatusMapper;

    public List<Politicsstatus> getAllPoliticsstatus() {
        return politicsstatusMapper.getAllPoliticsstatus();
    }

}
