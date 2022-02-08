import java.util.*;

public class SuffixArray1{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        sc.close();
        //find all posible suffix
        int len = s.length();
        int arr[] = new int[len];

        for(int i =0;i<len;i++){
            arr[i] = i;
        }

        String suffix[] = new String[len];

        for(int i=0;i<len;i++){
            suffix[i] = s.substring(i,len);
            //System.out.println(suffix[i]);
        }

        // for(int i=0;i<len;i++){
        //     System.out.println(arr[i]+" -> "+suffix[i]);
        // }
        
        for(int i=0;i<len-1;i++){
            int ti = i;
            
            for(int j=i+1;j<len;j++){
                //if(suffix[i].compareToIgnoreCase(suffix[j]) < 0){
                if(arrComp(suffix[ti], suffix[j])>0){
                    ti = j;
                    // System.out.println("i = " + i + " ti = "+ ti);
                }
            }
            //System.out.println(t);
            String t2 = suffix[i];  
            suffix[i] = suffix[ti];
            suffix[ti] = t2;

            int temp = arr[i];
            arr[i] = arr[ti];
            arr[ti] = temp;
        }

        System.out.print((len) + " ");
        for(int e:arr){
            System.out.print(e +" ");
        }
    }
        
        //System.out.println(suffix[0]);
    

    public static int arrComp(String ar1, String ar2){
        char[] ch1 = ar1.toCharArray();
        char[] ch2 = ar2.toCharArray();
        //int res = 0;
        int min = Math.min(ch1.length,ch2.length);

        for(int i=0;i<min;i++){
            if((int)ch1[i]>(int)ch2[i]) return +1;
            if(ch2[i]>ch1[i]) return -1;
        }

        return (ch1.length - ch2.length);
    }
}