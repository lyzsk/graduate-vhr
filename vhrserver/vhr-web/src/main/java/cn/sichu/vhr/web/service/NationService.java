package cn.sichu.vhr.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.sichu.vhr.web.mbg.mapper.NationMapper;
import cn.sichu.vhr.web.mbg.model.Nation;

/**
 * 
 * @author sichu
 * @date 2022/05/12
 */
@Service
public class NationService {
    @Autowired
    NationMapper nationMapper;

    public List<Nation> getAllNations() {
        return nationMapper.getAllNations();
    }

}
