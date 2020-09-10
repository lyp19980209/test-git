package cn.smbms.service.provider;

import cn.smbms.dao.bill.BillMapper;
import cn.smbms.dao.provider.ProviderMapper;
import cn.smbms.pojo.Provider;
import cn.smbms.tools.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
@Service("providerService")
@Transactional
public class ProviderServiceImpl implements ProviderService {
@Resource
private ProviderMapper providerMapper;
@Resource
private BillMapper billMapper;
    @Override
    public boolean add(Provider provider) {
        boolean flag = false;

        try {
            if (providerMapper.add(provider) > 0)
                flag = true;

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("rollback==================");
            throw e;
        }
        return flag;
    }

    @Override
    public List<Provider> getProviderList(String proName, String proCode) {

        List<Provider> providerList = null;
        System.out.println("query proName ---- > " + proName);
        System.out.println("query proCode ---- > " + proCode);
        try {
            providerList = providerMapper.getProviderList(proName, proCode);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return providerList;
    }

    /**
     * 业务：根据ID删除供应商表的数据之前，需要先去订单表里进行查询操作
     * 若订单表中无该供应商的订单数据，则可以删除
     * 若有该供应商的订单数据，则不可以删除
     * 返回值billCount
     * 1> billCount == 0  删除---1 成功 （0） 2 不成功 （-1）
     * 2> billCount > 0    不能删除 查询成功（0）查询不成功（-1）
     * <p>
     * ---判断
     * 如果billCount = -1 失败
     * 若billCount >= 0 成功
     */
    @Override
    public int deleteProviderById(Integer delId) {

        int billCount = -1;
        try {
            billCount = billMapper.getBillCountByProviderId(delId);
            if (billCount == 0) {
                providerMapper.deleteProviderById(delId);
            }

        } catch (Exception e) {
            e.printStackTrace();
            billCount = -1;
            throw e;
        }
        return billCount;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true,isolation = Isolation.READ_COMMITTED)

    public Provider getProviderById(Integer id) {
        Provider provider = null;

        try {
            provider = providerMapper.getProviderById(id);
        } catch (Exception e) {
            e.printStackTrace();
            provider = null;
        }
        return provider;
    }

    @Override
    public boolean modify(Provider provider) {

        boolean flag = false;
        try {
            if (providerMapper.modify(provider) > 0)
                flag = true;

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return flag;
    }

}
