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
            String text = String.format("%d-я позиция по счету: %s - стоимость которой = %.2f", i
                    + 1, listProduct.get(i).nameProduct,listProduct.get(i).costProduct);
            System.out.println(text);
        }
    }

}
