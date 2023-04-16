public class Main {
    public static void main(String[] args) {
        SomeTest<Integer> isFactor = (a, b) -> (a % b) == 0;
        System.out.println(isFactor.test(10, 2));//true
        SomeTest<Double> isFactorD = (a, b) -> (a % b) == 0;
        System.out.println(isFactorD.test(10.0, 2.0));//true
        SomeTest<String> isFactorS = (s1, s2) -> s1.indexOf(s2) != -1;
        System.out.println(isFactorS.test("abs", "abc"));//false
        System.out.println(isFactorS.test("abs", "ab"));//true

        //lambda can be as parameter in method
        int[] ints = {1, 50, 80, 10, 3, 9};
        Checkable moreThan10 = n -> n > 10;
      //  moreThan10=n -> n<5;

        System.out.println(sum(ints,moreThan10));//130

        //method reference

        PersonCreator personCreator=Person::new;
        Person person=personCreator.create("Jack");


    }

    public static int sum(int[] ints, Checkable checkable) {
        int sum = 0;
        for (int num : ints) {
            if (checkable.check(num))
                sum += num;
        }return sum;
    }
}