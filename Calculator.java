import java.lang.String;
import java.util.List;
import java.util.ArrayList;

public class Calculator {
    public static void main(String[] args){
        float a = 1.1f;
        float b = 2.2f;
        float d = 0;
        float c = a*b;
        int toNext = 0;
        int f = 0;
        
        List<List<Integer>> zbiorcza = new ArrayList<List<Integer>>();

        String[] toAArray = Float.toString(a).split("");
        String[] bArray = Float.toString(b).split("");
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
        for(int i = 0; i < aArray.length; i++){
            if(l == -1){
                aArray[i] = "0";
            }
            if(l != -1) {
                aArray[i] = toAArray[l];
                l--;
            }

        }
        int[] allValue = new int[bArray.length+aArray.length];
        int[] toAddA = new int[aArray.length-1];
        int[] toAddB = new int[bArray.length-1];
        for(int i = aArray.length-1; i >= 0; i--){
        	List<Integer> array = new ArrayList<Integer>();
            /*for(int j = value1; j >= 0; j--){
                if(toNext != 0){
                    allValue[i] += toNext;
                    toNext = 0;
                }
                value2 = Integer.parseInt(bArray[i]);
                allValue[i] += value2;
            }*/
        	if(!aArray[i].equals(".")) {
	        	for(int x = 0; x < f; x++) {
	        		array.add(0);
	        	}
	        	f++;
        	}
        	for(int j = bArray.length-1; j >= 0; j--) {
        		if(!aArray[i].equals(".") && !bArray[j].equals(".")) {
                	allValue[i] = Integer.parseInt(aArray[i])*Integer.parseInt(bArray[j])+toNext;
                	if(toNext != 0) {
                		toNext = 0;
                	}
                	array.add(allValue[i]);
                	if(Integer.toString(allValue[j]).length() > 1) {
                        toNext = Integer.parseInt(Integer.toString(allValue[j]).split("")[0]);
                        allValue[i] = Integer.parseInt(Integer.toString(allValue[j]).split("")[1]);
                    }
                	
                }
        	}
        	zbiorcza.add(array);
        }
        List<String> wynik = new ArrayList<String>();
        for(int i = zbiorcza.size()-1; i >= 0; i--){
            List<Integer> list = zbiorcza.get(i);
            String toSum = "";
            for(int j = list.size()-1; j >= 0; j--){
                toSum += list.get(j);
            }
            wynik.add(toSum);
        }
        System.out.println(wynik);
        int koniec = 0;
        for(int i = 0; i < wynik.size()-1; i++){
            koniec += wynik.get(i);
        }
        System.out.println(koniec);
    }
}