package com.proit.db.dao;

import com.proit.db.model.Product;

public class DaoMain {

    public static void main(String[] args) {
        try {
            Product product = new Product(7, "Shirt", 5000, 200);
            ProductDao dao = new ProductDao();

            Product found = dao.findById(90);
            if (found != null) {
                System.out.printf("Updated product %d - %s - %f - %d", found.getProductId(),
                        found.getName(), found.getUnitPrice(), found.getQuantity());
            } else {
                System.out.println("PRODUCT NOT FOUND");
            }

//            update product
//            Product updated = dao.update(product);
//            System.out.printf("Updated product %d - %s - %f - %d", updated.getProductId(),
//                    updated.getName(), updated.getUnitPrice(), updated.getQuantity());
//            insert product
//            Product saved = dao.create(product);
//            System.out.printf("Saved product %d - %s - %f - %d", saved.getProductId(),
//                    saved.getName(), saved.getUnitPrice(), saved.getQuantity());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
