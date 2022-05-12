package cn.sichu.vhr.web.mbg.model;

import java.util.List;

/**
 * 创建 RespBean 为 EmployeeService 服务
 * 
 * @author sichu
 * @date 2022/05/11
 */
public class RespPageBean {
    private Long total;
    private List<?> data;

    public List<?> getData() {
        return data;
    }

    public void setData(List<?> data) {
        this.data = data;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }
}
