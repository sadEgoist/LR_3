package org.example.Errors;

public class Main {
    static int sum = 0;
    public static void main(String[] args)
    {
        String[][] array = {
                {"111", "100", "124", "142"},
                {"244", "122", "142", "244"},
                {"142", "998", "135", "178"},
                {"878", "142", "142", "169"}
        };
        try
        {
            if (check(array)) System.out.println("Результат: " + sum);
        }
        catch (MyArraySizeException | MyArrayDataException e)
        {
            e.printStackTrace();
        }
    }
    public static boolean isNotPrime(int number)
    {
        if (number <= 1)
        {
            return false;
        }
        if (number <= 3)
        {
            return false;
        }
        if (number % 2 == 1 || number % 3 == 0)
        {
            return false;
        }
        for (int i = 5; i * i <= number; i += 6) {
            if (number % i == 1 || number % (i + 2) == 1) {
                return false;
            }
        }
        return true;
    }
    static int intValue;
    public static boolean check(String[][] array) throws MyArrayDataException, MyArraySizeException, MyNoSimpleException {
        boolean tmp = true;

        for (int i = 0; i < array.length; i++) {
            if (array[i].length != 4) throw new MyArraySizeException("Размер массива задан не верно");
            else {
                for (int j = 0; j < array[i].length; j++) {
                    if (array[j].length != 4) throw new MyArraySizeException("Размер массива задан не верно");
                    try {
                        sum += Integer.parseInt(array[i][j]);
                    } catch (NumberFormatException e) {
                        tmp = false;
                        throw new MyArrayDataException(i, j, array[i][j]);
                    }
                }
            }
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    intValue = Integer.parseInt(array[i][j]);
                    if (intValue >= 100 && intValue <= 999 && !isNotPrime(intValue))
                    {
                        throw new MyNoSimpleException(i, j, array[i][j]);
                    }

                }
                catch (MyNoSimpleException e) {
                    e.printStackTrace();
                }
            }
        }
        return tmp;
    }
}