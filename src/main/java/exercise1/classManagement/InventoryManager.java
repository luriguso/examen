package exercise1.classManagement;

import exercise1.classData.Product;
import exercise1.exceptions.DuplicateProductException;
import exercise1.exceptions.ProductNotFoundException;

import java.util.HashSet;
import java.util.Set;

public class InventoryManager {
    Set<Product> inventory;

    public InventoryManager(Set<Product> inventory) {
        this.inventory = inventory;
    }
    
    

    public Product findByName(String name){
        Product productFound = inventory.stream().filter(product -> product.getName().toLowerCase().equals(name.toLowerCase())).findFirst().orElse(null);
        if(productFound == null){
            throw new ProductNotFoundException(name);
        }else {
            return productFound;
        }
    }

    public void addProduct(Product patatita) {
        if(inventory.contains(patatita)){
            throw new DuplicateProductException("patatita.getName()");
        }
        inventory.add(patatita);
    }
    
    public int getStock() {
        return inventory.size();
    }


    public Set<Product> getLowStockProducts(int i) {
        Set<Product> lowStock = new HashSet<>();
        for(Product patatita : inventory){
            if(patatita.getQuantity()<=i){
                lowStock.add(patatita);
            }
        }
        return lowStock;
    }

    public double getTotalInventoryValue() {
        double total = 0;
        for(Product patatita : inventory){
            total += (patatita.getQuantity() * patatita.getPrice());
        }
        return total;
    }
}
