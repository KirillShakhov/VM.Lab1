package lab.Commands;

import lab.MathModule;
import lab.Matrix;

import java.util.Scanner;

import static lab.MathModule.permuteMatrixHelper;

public class DiagonalRandomCommand implements ICommand{
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public String getMessage() { return "Генерация рандомной матрицы с диагональным преобладанием"; }

    @Override
    public void execute() {
        System.out.println("Генерация матрицы c диагональным преобладанием");
        int size = 0;
        double eps = 1;
        while (true) {
            try {
                System.out.println("Введите размер:");
                String buffer = scanner.nextLine();
                size = Integer.parseInt(buffer);
                System.out.println("Введите точность:");
                buffer = scanner.nextLine();
                eps = Double.parseDouble(buffer);
                break;
            }
            catch (Exception ignored){ }
        }
        Matrix matrix;
        do {
            matrix = createRandomMatrix(size);
            double[][] val = permuteMatrixHelper(matrix,0);
            if (val!= null) {
                matrix = new Matrix(val);
            }
        } while (!MathModule.checkDiagonal(matrix.getMatrix(), size));
        MathModule.findSolution(matrix, eps);
    }

    public Matrix createRandomMatrix(int size) {
        int max = 10;
        int min = 0;
        try{
            if (size > 20 || size <= 0) {
                throw new Exception();
            }
            double[][] matrix = new double[size][size + 1];
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix.length + 1; j++) {
                    if(i == j){
                        matrix[i][j] = Math.random() * (100 - 45) + 45;
                    }
                    else {
                        matrix[i][j] = Math.random() * (max - min) + min;
                    }
                }
            }
            return new Matrix(matrix);
        } catch (Exception e) {
            System.out.println("Введена неверная размерность");
        }
        return null;
    }
}
