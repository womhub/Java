public class Test {
    public static void main(String[] args){
        int a = 10;
        int b = ++a;
        System.out.println(a);
        System.out.println(b);

        int c = 10; 
        int d = c++;
        System.out.println(c);
        System.out.println(d);

        int i;
        for(i = 0; i < 10; i++){
            System.out.println(i);
        }
        System.out.println(i);
        System.out.println("-----------");
        
        int j;
        for(j = 0;j < 10; ++j){
            System.out.println(j);
        }
        System.out.println(j);

    }


    

}
