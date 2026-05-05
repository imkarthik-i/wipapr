package com.wip.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.wip.dao.ProductDao;
import com.wip.model.Product;

public class ProductController implements ProductInterface {

    Product pr;
    Scanner sc = new Scanner(System.in);
    List<Product> prList = new ArrayList<>();
    ProductDao dao = new ProductDao();

    public void addProduct() {
        pr = new Product();
        System.out.println("Enter the Prod ID:");
        int prid = sc.nextInt();
        pr.setPid(prid);

        System.out.println("Enter the Prod Name:");
        String prName = sc.next();
        pr.setPname(prName);

        prList.add(pr);
        dao.insertProduct(pr);
        System.out.println("Product Added Successfully !!!");
    }

    public void viewProduct() {
        System.out.println(prList);
        dao.retrieveProducts();
    }

    public void updateProduct() {
        System.out.println("Enter the Product ID to update:");
        int pid = sc.nextInt();

        System.out.println("Enter the new Product Name:");
        String newName = sc.next();

        Product updatedPr = new Product();
        updatedPr.setPid(pid);
        updatedPr.setPname(newName);

        dao.updateProduct(updatedPr);
        System.out.println("Product Updated Successfully !!!");
    }

    public void deleteProduct() {
        System.out.println("Enter the Product ID to delete:");
        int pid = sc.nextInt();
        dao.deleteProduct(pid);
        System.out.println("Product Deleted Successfully !!!");
    }

    public void insertProductUsingProcedure() {
        pr = new Product();
        System.out.println("Enter the Prod ID:");
        int prid = sc.nextInt();
        pr.setPid(prid);

        System.out.println("Enter the Prod Name:");
        String prName = sc.next();
        pr.setPname(prName);

        dao.insertProductUsingProcedure(pr);
        System.out.println("Product Added Successfully via Procedure!!!");
    }

    public void getProductNameById() {
        System.out.println("Enter the Product ID to find its name:");
        int pid = sc.nextInt();
        dao.getProductNameById(pid);
    }
}
