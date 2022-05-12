package cn.sichu.vhr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.sichu.vhr.mapper.NationMapper;
import cn.sichu.vhr.model.Nation;

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
