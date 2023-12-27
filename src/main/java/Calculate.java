import java.lang.reflect.Array;
import java.util.ArrayList;

public class Calculate {
    Double sum = 0.0;
    ArrayList<Product> listProduct = new ArrayList<Product>();
    void sum (Double costProduct){
        sum = sum + costProduct;
    }
    void addingProductsToCalculate(Product product){
        listProduct.add(product);
    }
    double division(Double sum, int numberOfPerson){
        return sum / numberOfPerson;
    }

    void addingProductsToConsole(){
        for (int i = 0; i < listProduct.size(); i++ ){
            System.out.println((i + 1) +"-я позиция по счету: " + listProduct.get(i).nameProduct + " стоимость которой = " + listProduct.get(i).costProduct);
        }
    }

}
