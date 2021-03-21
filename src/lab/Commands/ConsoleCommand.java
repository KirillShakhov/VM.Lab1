package lab.Commands;
import lab.Matrix;

import java.util.Scanner;

public class ConsoleCommand implements ICommand{
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public String getMessage() {
        return "Ввести матрицу с консоли";
    }

    @Override
    public void execute() {
        System.out.println("Вводим матрицу с консоли");
        Matrix matrix = createMatrixFromKeyBoard();
    }

    public Matrix createMatrixFromKeyBoard(){
        try {
            System.out.println("Введите размерность матрицы");
            String buffer = scanner.nextLine();
            buffer = buffer.trim();
            int size = Integer.parseInt(buffer);
            if (size > 20 || size <= 0) {
                throw new Exception();
            }
            System.out.println("Введите строки матрицы");
            double [][] matrix = new double[size][size+1];
            String [][] arr = new String[size][size+1];
            for (int i = 0; i < size;i++) {
                buffer = scanner.nextLine();
                arr[i] = buffer.trim().split(" ");
                buffer = "";
            }

            for (int i = 0; i < size;i++){
                for (int j = 0; j < size+1;j++) {
                    matrix[i][j] = Double.parseDouble(arr[i][j].trim());
                }
            }
            return new Matrix(matrix);
        } catch (Exception e) {
            System.out.println("Введена неверная размерность");
        }
        return null;
    }
}
