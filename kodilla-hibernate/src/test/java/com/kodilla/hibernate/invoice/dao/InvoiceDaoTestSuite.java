package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(SpringExtension.class)
@SpringBootTest
class InvoiceDaoTestSuite {

    @Autowired
    private ProductDao productDao;
    @Autowired
    private ItemDao itemDao;
    @Autowired
    private InvoiceDao invoiceDao;

    private static final int PRICE = 500;

    @Test
    void  testInvoiceDaoSave() {

        Invoice invoice = new Invoice("LTC20230300987");
        Product product = new Product("Contract 1");

        Item item = new Item(new BigDecimal(PRICE), 3);
        Item item2 = new Item(new BigDecimal(PRICE), 10);
        Item item3 = new Item(new BigDecimal(PRICE), 1);
        Item item4 = new Item(new BigDecimal(PRICE), 5);

        item.setProduct(product);
        item2.setProduct(product);
        item3.setProduct(product);
        item4.setProduct(product);

        item.setInvoice(invoice);
        item2.setInvoice(invoice);
        item3.setInvoice(invoice);
        item4.setInvoice(invoice);

        product.getItems().add(item);
        product.getItems().add(item2);
        product.getItems().add(item3);
        product.getItems().add(item4);

        invoice.getItems().add(item);
        invoice.getItems().add(item2);
        invoice.getItems().add(item3);
        invoice.getItems().add(item4);

        //When
        invoiceDao.save(invoice);
        int invoiceId = invoice.getId();

        productDao.save(product);
        int productId = product.getId();

        itemDao.save(item);
        int itemId = item.getId();
        itemDao.save(item2);
        int item2Id = item2.getId();
        itemDao.save(item3);
        int item3Id = item3.getId();
        itemDao.save(item4);
        int item4Id = item4.getId();

        //Then
        assertNotEquals(0, invoiceId);
        assertNotEquals(0, productId);
        assertNotEquals(0, itemId);
        assertNotEquals(0, item2Id);
        assertNotEquals(0, item3Id);
        assertNotEquals(0, item4Id);

        //CleanUp
        itemDao.deleteById(itemId);
        itemDao.deleteById(item2Id);
        itemDao.deleteById(item3Id);
        itemDao.deleteById(item4Id);
        productDao.deleteById(productId);
        invoiceDao.deleteById(invoiceId);
    }
}
