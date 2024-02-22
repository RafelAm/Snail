import org.junit.Assert;
import org.junit.Test;
import org.junit.runners.JUnit4;
import java.util.Arrays;
import java.util.Random;
import static java.util.stream.Collectors.joining;

public class SnailTest {

  @Test
    public void SnailTest1() {
        int[][] array
                = {{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};
        int[] r = {1, 2, 3, 6, 9, 8, 7, 4, 5};
        test(array, r);
    }
    
   public String int2dToString(int[][] a) {
        return Arrays.stream(a).map(row -> Arrays.toString(row)).collect(joining("\n"));
    }

    public void test(int[][] array, int[] result) {
        String text = int2dToString(array) + " should be sorted to " + Arrays.toString(result);
        System.out.println(text);
        Assert.assertArrayEquals( result, Snail.snail(array));
    }

   
}

public class Snail {

    public static int[] snail(int[][] array) {
     
      int c = array.length;
      int d = array[0].length;
      
      
      int[] numbers = new int[c*d];
      int iniFila = 0; int finFila = c -1; // Marca del principio y el final de las filas
      int iniColumna = 0; int finColumna = d -1; // Marca del principio y el final de las columnas
      int ind = 0; // Indice que ira aumentando para recorrer el array donde vamos a guardar los numeros
    
      
      while(iniFila <= finFila && iniColumna <= finColumna){ // Mientras el inicio de la fila sea menor o igual al final y inicio de la columna sea menor o igual al final no saldra del bucle
        // Derecha  
        for(int i = iniColumna; i <= finColumna; i++){// Bucle que empieza desde 0 y acaba en el final de la fila
            numbers[ind++] = array[iniFila][i]; // Incrementa el indice cada vez, de la fila 0 guarda todos los numeros hacia la derecha
            
          }
          iniFila++;// Incrementamos la fila para el siguiente paso
        // Abajo
        for(int i = iniFila; i <= finFila; i++){// Empieza desde 1 y acaba en 2 
          numbers[ind++] = array[i][finColumna]; // Incrementa el indice cada vez, y guarda los numeros desde 1 a 2 hacía abajo
        }
        finColumna--;// Decrementamos la columna para posicionarnos en una posicion no comprobada
        // Izquierda
        if(iniFila <= finFila){// Si el inicio de la fila es menor o igual al final de la fila entonces
          for(int i = finColumna; i >= iniColumna; i--){// Bucle que empieza en final y mientras sea mayor o igual al inicio decrementa en 1
            numbers[ind++] = array[finFila][i];// Incrementa el indice cada vez, y guarda los numeros de derecha a izquierda
          }
          finFila--;// Decrementamos la fila para volver a comprobar las posiciones que nos faltan
        }
        // Arriba
        if(iniColumna <= finColumna){// Si el inicio de la columna es menor o igual al final entonces 
          for(int i = finFila; i >= iniFila; i--){// Bucle que empieza en final y mientras sea mayor o igual al inicio decrementa en 1
            numbers[ind++] = array[i][iniColumna];// Incrementamos el indice cada vez, y guaerdamos los numeros de derecha a izquierda
          }
          iniColumna++;
        }
      }
         
      return numbers;
   } 
}
