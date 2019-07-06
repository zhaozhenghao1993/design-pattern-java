import java.util.ArrayList;
import java.util.List;

/**
 * 🙃
 * 🙃
 * 🙃
 *
 * @author:zhaozhenghao
 * @Email :736720794@qq.com
 * @date :2019/07/06 19:50
 * Client.java
 */
// 员工类：抽象元素类
interface Employee {
    public void accept(Department handler); // 接受一个抽象访问者访问
}

// 全职员工类：具体元素类
class FulltimeEmployee implements Employee {
    private String name;
    private double weeklyWage;
    private int workTime;

    public FulltimeEmployee(String name, double weeklyWage, int workTime) {
        this.name = name;
        this.weeklyWage = weeklyWage;
        this.workTime = workTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeeklyWage() {
        return weeklyWage;
    }

    public void setWeeklyWage(double weeklyWage) {
        this.weeklyWage = weeklyWage;
    }

    public int getWorkTime() {
        return workTime;
    }

    public void setWorkTime(int workTime) {
        this.workTime = workTime;
    }

    public void accept(Department handler) {
        handler.visit(this); //调用访问者的访问方法
    }
}

// 兼职员工类：具体元素类
class ParttimeEmployee implements Employee {
    private String name;
    private double hourWage;
    private int workTime;

    public ParttimeEmployee(String name, double hourWage, int workTime) {
        this.name = name;
        this.hourWage = hourWage;
        this.workTime = workTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getHourWage() {
        return hourWage;
    }

    public void setHourWage(double hourWage) {
        this.hourWage = hourWage;
    }

    public int getWorkTime() {
        return workTime;
    }

    public void setWorkTime(int workTime) {
        this.workTime = workTime;
    }

    public void accept(Department handler) {
        handler.visit(this); //调用访问者的访问方法
    }
}

//部门类：抽象访问者类
abstract class Department {

    //声明一组重载的访问方法，用于访问不同类型的具体元素
    public abstract void visit(FulltimeEmployee employee);
    public abstract void visit(ParttimeEmployee employee);
}

// 财务部类：具体访问者类
class FADepartment extends Department {

    // 实现财务部对全职员工的访问
    public void visit(FulltimeEmployee employee) {
        int workTime = employee.getWorkTime();
        double weekWage = employee.getWeeklyWage();
        if(workTime > 40) {
            weekWage = weekWage + (workTime - 40) * 100;
        } else if(workTime < 40) {
            weekWage = weekWage - (40 - workTime) * 80;
            if(weekWage < 0) {
                weekWage = 0;
            }
        }
        System.out.println("正式员工" + employee.getName() + "实际工资为：" + weekWage + "元。");
    }

    // 实现财务部对兼职员工的访问
    public void visit(ParttimeEmployee employee) {
        int workTime = employee.getWorkTime();
        double hourWage = employee.getHourWage();
        System.out.println("临时工" + employee.getName() + "实际工资为：" + workTime * hourWage + "元。");
    }
}

// 人力资源部类：具体访问者类
class HRDepartment extends Department {

    // 实现财务部对全职员工的访问
    public void visit(FulltimeEmployee employee) {
        int workTime = employee.getWorkTime();
        System.out.println("正式员工" + employee.getName() + "实际工作时间为：" + workTime + "小时。");
        if(workTime > 40) {
            System.out.println("正式员工" + employee.getName() + "加班时间为：" + (workTime - 40) + "小时。");
        } else if(workTime < 40) {
            System.out.println("正式员工" + employee.getName() + "请假时间为：" + (40 - workTime) + "小时。");
        }
    }

    // 实现财务部对兼职员工的访问
    public void visit(ParttimeEmployee employee) {
        int workTime = employee.getWorkTime();
        System.out.println("临时工" + employee.getName() + "实际工作时间为：" + workTime + "小时。");
    }
}

// 员工列表类：对象结构
class EmployeeList {
    private List<Employee> list = new ArrayList<Employee>();

    public void addEmployee(Employee employee) {
        list.add(employee);
    }

    public void accept(Department handler) {
        for (Employee employee: list) {
            employee.accept(handler);
        }
    }
}

public class Client {
    public static void main(String[] args) {
        EmployeeList list = new EmployeeList();
        Employee fte1,fte2,fte3,pte1,pte2;

        fte1 = new FulltimeEmployee("张无忌",3200.00,45);
        fte2 = new FulltimeEmployee("杨过",2000.00,40);
        fte3 = new FulltimeEmployee("段誉",2400.00,38);
        pte1 = new ParttimeEmployee("洪七公",80.00,20);
        pte2 = new ParttimeEmployee("郭靖",60.00,18);

        list.addEmployee(fte1);
        list.addEmployee(fte2);
        list.addEmployee(fte3);
        list.addEmployee(pte1);
        list.addEmployee(pte2);

        Department dep;
        dep = new FADepartment();
        list.accept(dep);

    }
}
