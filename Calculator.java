import java.lang.String;
public class Calculator {
    public static void main(String[] args){
        int a = 12;
        int b = 12;
        int c = a*b;
        int toNext = 0;
        int value1, value2 = 0;

        String[] toAArray = Integer.toString(a).split("");
        String[] bArray = Integer.toString(b).split("");
        String[] aArray = {"0"};
        if(toAArray.length < bArray.length) {
            aArray = new String[toAArray.length + (bArray.length - toAArray.length)];
        }
        if(toAArray.length > bArray.length) {
            aArray = new String[toAArray.length + (toAArray.length - bArray.length)];
        }
        if(toAArray.length == bArray.length){
            aArray = new String[bArray.length];
        }
        int l = toAArray.length-1;
        for(int i = aArray.length-1; i >= 0; i--){
            if(l == -1){
                aArray[i] = "0";
            }
            if(l != -1) {
                aArray[i] = toAArray[l];
                l--;
            }

        }
        int[] allValue = new int[bArray.length+aArray.length];
        for(int i = aArray.length-1; i >= 0; i--){
            value1 = Integer.parseInt(aArray[i]);
            for(int j = value1; j >= 0; j--){
                if(toNext != 0){
                    allValue[i] += toNext;
                    toNext = 0;
                }
                value2 = Integer.parseInt(bArray[i]);
                allValue[i] += value2;
            }
            if(Integer.toString(allValue[i]).length() > 1) {
                toNext = Integer.parseInt(Integer.toString(allValue[i]).split("")[0]);
                allValue[i] = Integer.parseInt(Integer.toString(allValue[i]).split("")[1]);
            }
        }

    }
}
