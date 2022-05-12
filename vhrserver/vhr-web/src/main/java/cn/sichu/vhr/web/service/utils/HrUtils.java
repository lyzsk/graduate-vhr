package cn.sichu.vhr.web.service.utils;

import org.springframework.security.core.context.SecurityContextHolder;

import cn.sichu.vhr.web.mbg.model.Hr;

/**
 * 
 * @author sichu
 * @date 2022/05/12
 */
public class HrUtils {
    public static Hr getCurrentHr() {
        return ((Hr)SecurityContextHolder.getContext().getAuthentication().getPrincipal());
    }
}
