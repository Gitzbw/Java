package MHL.service;

import MHL.dao.BillDAO;

import java.util.UUID;

public class BillService {
    private BillDAO billDAO = new BillDAO();
    private MenuService menuService = new MenuService();
    private DiningTableService diningTableService = new DiningTableService();

    public boolean orderMenu(int menuId,int nums,int diningTableId)
    {
        String billId = UUID.randomUUID().toString();//用于生成随机billId
        int update = billDAO.update("insert into bill values(null,?,?,?,?,?,now(),'未结账')",
                billId, menuId, nums, menuService.getMenuById(menuId).getPrice() * nums, diningTableId);
        if(update <= 0)
        {
            return false;
        }
        return diningTableService.updateDiningTableState(diningTableId, "就餐中");
    }
}
