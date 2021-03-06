package cn.sichu.vhr.controller.emp;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import cn.sichu.vhr.model.Department;
import cn.sichu.vhr.model.Employee;
import cn.sichu.vhr.model.JobLevel;
import cn.sichu.vhr.model.Nation;
import cn.sichu.vhr.model.Politicsstatus;
import cn.sichu.vhr.model.Position;
import cn.sichu.vhr.model.RespBean;
import cn.sichu.vhr.model.RespPageBean;
import cn.sichu.vhr.service.DepartmentService;
import cn.sichu.vhr.service.EmployeeService;
import cn.sichu.vhr.service.JobLevelService;
import cn.sichu.vhr.service.NationService;
import cn.sichu.vhr.service.PoliticsstatusService;
import cn.sichu.vhr.service.PositionService;
import cn.sichu.vhr.utils.POIUtils;

/**
 * 
 * @author sichu
 * @date 2022/05/12
 */
@RestController
@RequestMapping("/employee/basic")
public class EmpBasicController {
    @Autowired
    EmployeeService employeeService;
    @Autowired
    NationService nationService;
    @Autowired
    PoliticsstatusService politicsstatusService;
    @Autowired
    JobLevelService jobLevelService;
    @Autowired
    PositionService positionService;
    @Autowired
    DepartmentService departmentService;

    @GetMapping("/")
    public RespPageBean getEmployeeByPage(@RequestParam(defaultValue = "1") Integer page,
        @RequestParam(defaultValue = "10") Integer size, Employee employee, Date[] beginDateScope) {
        return employeeService.getEmployeeByPage(page, size, employee, beginDateScope);
    }

    @PostMapping("/")
    public RespBean addEmp(@RequestBody Employee employee) {
        if (employeeService.addEmp(employee) == 1) {
            return RespBean.ok("????????????!");
        }
        return RespBean.error("????????????!");
    }

    @DeleteMapping("/{id}")
    public RespBean deleteEmpByEid(@PathVariable Integer id) {
        if (employeeService.deleteEmpByEid(id) == 1) {
            return RespBean.ok("????????????!");
        }
        return RespBean.error("????????????!");
    }

    @PutMapping("/")
    public RespBean updateEmp(@RequestBody Employee employee) {
        if (employeeService.updateEmp(employee) == 1) {
            return RespBean.ok("????????????!");
        }
        return RespBean.error("????????????!");
    }

    @GetMapping("/nations")
    public List<Nation> getAllNations() {
        return nationService.getAllNations();
    }

    @GetMapping("/politicsstatus")
    public List<Politicsstatus> getAllPoliticsstatus() {
        return politicsstatusService.getAllPoliticsstatus();
    }

    @GetMapping("/joblevels")
    public List<JobLevel> getAllJobLevels() {
        return jobLevelService.getAllJobLevels();
    }

    @GetMapping("/positions")
    public List<Position> getAllPositions() {
        return positionService.getAllPositions();
    }

    @GetMapping("/maxWorkID")
    public RespBean maxWorkID() {
        RespBean respBean =
            RespBean.build().setStatus(200).setObj(String.format("%08d", employeeService.maxWorkID() + 1));
        return respBean;
    }

    @GetMapping("/deps")
    public List<Department> getAllDepartments() {
        return departmentService.getAllDepartments();
    }

    @GetMapping("/export")
    public ResponseEntity<byte[]> exportData() {
        List<Employee> list =
            (List<Employee>)employeeService.getEmployeeByPage(null, null, new Employee(), null).getData();
        return POIUtils.employee2Excel(list);
    }

    @PostMapping("/import")
    public RespBean importData(MultipartFile file) throws IOException {
        List<Employee> list = POIUtils.excel2Employee(file, nationService.getAllNations(),
            politicsstatusService.getAllPoliticsstatus(), departmentService.getAllDepartmentsWithOutChildren(),
            positionService.getAllPositions(), jobLevelService.getAllJobLevels());
        if (employeeService.addEmps(list) == list.size()) {
            return RespBean.ok("????????????");
        }
        return RespBean.error("????????????");
    }
}
