package LambdaExpression;



// FunctionalInterface
interface B{
    public int show(int i, int j);
}
class C implements B{
    @Override
    public int show(int i, int j) {
        return i+j;
    }
}
public class LambdaExpressionWithReturn {
    public static void main(String[] args) {
        // Traditional Method
        B obj = new C();
        int show = obj.show(3, 5);
        System.out.println("With anonymous inner class answer is :"+show);

        //with lambda wxpression with return
        B obj2 = (m,n) -> m+n;
        int result = obj2.show(8,9);
        System.out.println("With lambda expression result value :"+ result);


    }
}
