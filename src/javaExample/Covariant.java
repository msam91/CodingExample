package javaExample;

public class Covariant {
    class Animal
    {
        Animal myType()
        {
            return new Animal();
        }
    }

    class Dog extends Animal
    {
        Dog myType()     //Legal override after Java5 onward
        {
            return new Dog();
        }
    }

    public static void main(String args[]){
    
        System.out.print(DogName.valueOf("MOTI").getAge());
        for(DogName dogName : DogName.values()){
            System.out.println(dogName);
        }
        
        
    }
    public enum DogName{
        
        MOTI(10),
        BADRI(12),
        BUNTY(5);
       
        private int age;
        
        private DogName(int age){
            this.age=age;
        }
        public int getAge(){
            return this.age;
        }
        
   }
}

