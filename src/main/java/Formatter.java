public class Formatter {

    String formatter(Double value){
        String str = "";
        int a = roundingUp(value);
        int val = String.valueOf(a).length();

        while(true) {
            switch (val) {
                case 0: {
                    str = "рублей";
                    break;
                }
                case 1: {
                    str = str(a, str);
                    break;
                }
                case 2: {
                    str = strTwo(a, str);
                    break;
                }
                default:
                    a = a % 10;
                    str = strTwo(a, str);
                    break;
            }
            return str;
        }
    }

    int roundingUp (Double value){
       return (int) Math.floor(value);
    }

    String str (int a, String str){
        if (a == 1) {
            str = "рубль";
        } else if (a != 1 && a <= 4) {
            str = "рубля";
        } else if (a == 0 || a == 5 || a == 6 || a == 7 || a == 8 || a == 9) {
            str = "рублей";
        }
        return str;
    }

    String strTwo (int a, String str){
        if (a == 11 || a == 12 || a == 13 || a == 14) {
            str = "рублей";
            return str;
        }
        a = a % 10;
        str = str(a,str);
        return str;
    }
}