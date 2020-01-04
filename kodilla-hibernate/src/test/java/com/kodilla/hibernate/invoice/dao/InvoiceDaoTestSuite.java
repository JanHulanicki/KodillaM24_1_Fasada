package com.kodilla.hibernate.invoice.dao;
import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
@RunWith(SpringRunner.class)
@SpringBootTest
public class InvoiceDaoTestSuite {
    @Autowired
    InvoiceDao invoiceDao;
    @Test
    public void testInvoiceDaoSave(){
        //Given
        Product product1=new Product("Product1");
        Product product2=new Product("Product2");
        Item item1=new Item( product1,new BigDecimal(1),1,new BigDecimal(1));
        Item item2=new Item( product2,new BigDecimal(2),2,new BigDecimal(4));
        List<Item> items=new ArrayList<>();
        items.add(item1);
        items.add(item2);
        Invoice invoice1=new Invoice("1234",items);
        //When
        invoiceDao.save(invoice1);
        int id = invoice1.getId();
        // System.out.println(product1.toString());
        // System.out.println(item1.toString());
        // System.out.println(item2.toString());
        // System.out.println(invoice1.toString());
        //Then
        Assert.assertNotEquals(0, id);
        //CleanUp
        try {
            invoiceDao.deleteAll();
        } catch (Exception e) {

        }
    }
}
