public class Main {

    public static void main(String[] args){
    
        cokeProduce(10);
        
   }     
        public static void cokeProduce(int coke){

        List<String> bigBang = new ArrayList<>();
        bigBang.add("Sheldon");
        bigBang.add("Leonard");
        bigBang.add("Volovitc");
        bigBang.add("Kutrapalli");
        bigBang.add("Penny");

        for(int i = 0; i < coke; i++){
            bigBang.add(bigBang.get(0));
            bigBang.add(bigBang.get(0));
            bigBang.remove(0);
        }
        System.out.println(bigBang);
    }
}
