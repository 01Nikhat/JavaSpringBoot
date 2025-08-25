public class TypeConversion {
    public static void main(String[] args) {

        byte b = 127; //byte is a 2 byte
        int a = 256;  // int is a 4 byte

        //b = a; //this is not possible 256 is more than 2 byte data we can't assign more than 2 byte data, we might loose some data
        a = b; //it will work, implicitly converting data byte to int
        int c = 23;

        b = (byte)c; //we are explicitly converting data

        float f = 5.6f;
        // int x = f; it's not possible we must have to explicitly define if we want to convert float value to integer value, we will loose decimal value

        int x = (int)f;



        int e = 257;
        byte d = (byte)e; //here byte is 16 bit data but 257 is a bigger data so it will do modulas operation 257 % 256 = 1 module so answer will be 1 not 257
        System.out.println(d);

        /* type promotion */

        byte y = 10;
        byte z = 30;

        int result = y * z; //here 10*30 becomes 300 whihch is out of range in byte but we promoting byte value to integer value

        System.out.println("Type promotion :"+result);


    }
}
