package cn.smbms.service.bill;

import cn.smbms.dao.bill.BillMapper;
import cn.smbms.pojo.Bill;
import cn.smbms.tools.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
@Service("billService")
@Transactional
public class BillServiceImpl implements BillService {
@Resource
private BillMapper billMapper;
    @Override
    public boolean add(Bill bill) {
        boolean flag = false;

        try {
            if (billMapper.add(bill) > 0)
                flag = true;

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("rollback==================");
            throw e;
        }
        return flag;
    }

    @Override
    public List<Bill> getBillList(Bill bill) {

        List<Bill> billList = null;
        System.out.println("query productName ---- > " + bill.getProductName());
        System.out.println("query providerId ---- > " + bill.getProviderId());
        System.out.println("query isPayment ---- > " + bill.getIsPayment());
        try {
            billList = billMapper.getBillList(bill);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return billList;
    }

    @Override
    public boolean deleteBillById(Integer delId) {

        boolean flag = false;
        try {
            if (billMapper.deleteBillById(delId) > 0)
                flag = true;

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return flag;
    }

    @Override
    public Bill getBillById(Integer id) {
        Bill bill = null;

        try {
            bill = billMapper.getBillById(id);
        } catch (Exception e) {
            e.printStackTrace();
            bill = null;
        }
        return bill;
    }

    @Override
    public boolean modify(Bill bill) {

        boolean flag = false;
        try {
            if (billMapper.modify(bill) > 0)
                flag = true;

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return flag;
    }

}
