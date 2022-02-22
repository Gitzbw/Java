package MHL.view;

import MHL.domain.DiningTable;
import MHL.domain.Employee;
import MHL.domain.Menu;
import MHL.service.DiningTableService;
import MHL.service.EmployeeService;
import MHL.service.MenuService;
import MHL.utils.Utility;

import java.util.List;

public class MHLView {
    private boolean loop = true;
    private String key;
    private EmployeeService employeeService = new EmployeeService();
    private DiningTableService diningTableService = new DiningTableService();
    private MenuService menuService = new MenuService();

    public static void main(String[] args) {
        new MHLView().mainMenu();
    }

    public void listMenu()
    {
        List<Menu> list = menuService.list();
        System.out.println("\n菜品编号\t\t菜品名\t\t类别\t\t价格");
        for (Menu menu : list) {
            System.out.println(menu);
        }
    }

    public void listDiningTable()
    {
        List<DiningTable> list = diningTableService.list();
        System.out.println("\n餐桌编号\t\t餐桌状态");
        for (DiningTable diningTable : list) {
            System.out.println(diningTable);
        }
    }

    public void orderDiningTable()
    {
        System.out.println("==========预定餐桌==========");
        System.out.print("请输入要预定的餐桌编号(-1退出): ");
        int orderId = Utility.readInt();
        if(orderId == -1)
        {
            System.out.println("==========取消预定==========");
            return;
        }
        char key = Utility.readConfirmSelection();
        if(key == 'Y')
        {
            DiningTable diningTable = diningTableService.getDiningTableById(orderId);
            if(diningTable == null)
            {
                System.out.println("==========预定餐桌不存在==========");
                return;
            }
            if(!("空".equals(diningTable.getState())))
            {
                System.out.println("==========该餐桌已被预定或已在使用==========");
                return;
            }
            System.out.print("预订人姓名: ");
            String orderName = Utility.readString(50);
            System.out.print("预订人电话: ");
            String orderTel = Utility.readString(50);
            if(diningTableService.orderDiningTable(orderId,orderName,orderTel))
            {
                System.out.println("==========预定成功==========");
            }
            else
            {
                System.out.println("==========预定失败==========");
            }
        }
            else
        {
            System.out.println("==========取消预定==========");
        }
    }

    public void mainMenu()
    {
        while(loop)
        {
            System.out.println("===============满汉楼===============");
            System.out.println("\t\t 1 登录满汉楼");
            System.out.println("\t\t 2 退出满汉楼");
            System.out.print("请输入你的选择: ");
            key = Utility.readString(1);
            switch (key)
            {
                case "1":
                    System.out.print("输入员工号: ");
                    String empId = Utility.readString(50);
                    System.out.print("输入密  码: ");
                    String pwd = Utility.readString(50);
                    Employee employee = employeeService.getEmployeeByIdAndPwd(empId, pwd);
                    if(employee != null)
                    {
                        System.out.println("==========登录成功==========\n");
                        while(loop)
                        {
                            System.out.println("==========满汉楼(二级菜单)==========");
                            System.out.println("\t\t 1 显示餐桌状态");
                            System.out.println("\t\t 2 预定餐桌");
                            System.out.println("\t\t 3 显示所有菜品");
                            System.out.println("\t\t 4 点餐服务");
                            System.out.println("\t\t 5 查看菜单");
                            System.out.println("\t\t 6 结账");
                            System.out.println("\t\t 9 退出满汉楼");
                            System.out.print("请输入你的选择: ");
                            key = Utility.readString(1);
                            switch (key)
                            {
                                case "1":
                                    listDiningTable();
                                    break;
                                case "2":
                                    orderDiningTable();
                                    break;
                                case "3":
                                    listMenu();
                                    break;
                                case "4":
                                    break;
                                case "5":
                                    break;
                                case "6":
                                    break;
                                case "9":
                                    loop = false;
                                    break;
                                default:
                                    System.out.println("输入有误 请重新输入");
                            }
                        }
                    }
                    else
                    {
                        System.out.println("==========登录失败==========");
                    }
                    break;
                case "2":
                    loop = false;
                    break;
                default:
                    System.out.println("输入有误 请重新输入");
            }
            System.out.println("退出成功");
        }
    }
}
