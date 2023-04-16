package functionalInterfaces;

import java.lang.constant.Constable;
import java.util.function.*;

public class Main {
    public static void main(String[] args) {
        /*Написать следующие лямбды используя наши интерфейсы
        1. сложить строки a и  b
        2.есть строка, если ее длина равна 3 вернуть true  иначе  false
        3.Есть строка string распечатать ее в виде !string!
                */
        StringConcate stringConcate=(a,b)-> (Integer.toString(a)+Integer.toString(b));
        System.out.println(stringConcate.concat(12,12));
        //1212

        BinaryOperator<Integer>sum=(s,s1)-> Integer.valueOf(Integer.toString(s)+Integer.toString(s1));
        System.out.println(sum.apply(12,12));


        Checkable checkable=(a)->a.length()==3;
        System.out.println(checkable.check("hand"));//false
        System.out.println(checkable.check("cow"));//true

        Predicate<String>contains=s->s.length()==3;
        System.out.println(contains.test("cat"));//true



        Printable printable=(a)-> System.out.println("!"+a+"!");
        printable.print("string");
        //!string!

        Consumer<String> consumer=s1->System.out.println("!"+s1+"!");
        consumer.accept("string");

        //if length 4->****, if no-> without changes
        Transformable transformable = (in) -> (in.length() == 4 ? "****" : in);
        System.out.println(transformable.modify("high"));
        Consumer<String> consumer1=s -> System.out.println((s.length()==4?"****":s));
        consumer1.accept("night");


        // print "Hello world"
        Producable producable = () -> ("Hello world");
        System.out.println(producable.produce());
        Supplier<String>supplier=()->("Hello world");
        System.out.println(supplier.get());
    }
}
