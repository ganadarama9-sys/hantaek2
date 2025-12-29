package a1229;

public class Int1 {
    public static void main(String[] args) {
        int var1 = 10;
        System.out.println(var1);
        // =는 동일이 아니라 대입하다라는 의미
        // int 2var = 20; 숫자로 시작하면 안됨
        int _var2 = 20;
        int $var3 = 30;
        // int #var4 = 40;  _와 $외에는 특수문자 사용 불가
        int var5 = 100000000; // 10억
        long var6 = 10000000000L; // long 100억 L 또는 ㅣ 붙여야함
        double doubleVar = 3.1415926538979323846;
        float floatVar = 3.141592F; // float 접미사 F 또는 f 붙여야함
        byte byteVar = 127; // -128 ~ 127
        System.out.println(byteVar);
        short shortVar = 32767; // -32768 ~ 32767
        System.out.println(shortVar);
        // 문자형
        char charVar = 'A';
        System.out.println(charVar);
        char koreanChar = '가'; 
        System.out.println(koreanChar);
        char unicodeChar = '\u0041'; // 유니코드로 A 표현
        System.out.println(unicodeChar);
        // 논리형
        boolean isTrue = true; 
        boolean isFalse = false;
        System.out.println(isTrue);
        System.out.println(isFalse);
        boolean result = (5 > 3);
        System.out.println(result);

    }       
}
