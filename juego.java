import java.util.Random;
import java.util.Scanner;

public class juego
{
    // definicion de Variables//
    static double p1,p2;
    final static int numeroDeNumeros = 5;
    final static int numeroDeEstrellas = 2;
    static int[] numeros = new int[numeroDeNumeros];
    static int[] estrellas = new int[numeroDeEstrellas];
    static int[] numerosGanadores = new int[numeroDeNumeros];
    static int[] estrellasGanadoras = new int[numeroDeEstrellas];
    public static void main(String[] args)
    {
        ProcesarArgumentos(args);
        Jugar();
        System.out.println("Gracias por Jugar al Euromillón con nosotros, Vuelva pronto...");
    
    }
    public static void ProcesarArgumentos(String[] args)
    {
        if(args.length < 2)
        {
            System.out.println("los precios no han sido enviado por argumento.Por defecto los valores para p1 es: 3.14 y para p2: 2.75");
            p1 = 3.14;
            p2 = 2.75;
        }else
        {
            p1 = Double.parseDouble(args[0]);
            p2 = Double.parseDouble(args[1]);
        }
    }
    public static void Jugar()
    {
        // 1.Bienvenida y precios
        System.out.println("Bienvenido al Euromillón");
        System.out.printf("Hoy los numeros se juegan por un precio de %.2f y las estrellas por %.2f. \n",p1,p2);
        // 2.Modo Manual o automatico

        System.out.println("Introduzca el modo que quiere elegir los valores: ¿Manual o automático?");
        System.out.println("Selecciona: \n 1.Manual \n 2.Automático");
        Scanner sc = new Scanner(System.in);
        int modo = sc.nextInt();

        // 3.Modo Manual

        if(modo == 1)
        {
            for(int i = 0; i < numeroDeNumeros; i++)
            {
                System.out.printf("Introduzca el %dº Número: \n", i+1);
                numeros[i] = sc.nextInt();
                if(numeros[i] <=0 || numeros[i] > 50)
                {
                    System.out.println("Los valores introducidos están fuera de rango");
                    return;
                }
            }
            for(int i = 0; i < numeroDeEstrellas; i++)
            {
                System.out.printf("Introduzca la %dº Estrella: \n",i+1);
                estrellas[i] = sc.nextInt();
                if(estrellas[i] <= 0|| estrellas[i] >= 9)
                {
                    System.out.println("Los valores introducidos estan fuera de rango");
                }
            }
            // System.out.println("los numero son: ");
            // for (int i : numeros)
            // {
            //     System.out.print( i + " ");
            // }
            // System.out.println("\n");
        }

        // 4.Modo Automático
        else if(modo == 2)
        {
            Random rd = new Random();
            for(int i = 0; i < numeroDeNumeros; i++)
            {
                numeros[i] = rd.nextInt(50) + 1;
                
            }
            for(int i = 0; i < numeroDeEstrellas; i++)
            {
                estrellas[i] = rd.nextInt(10);
            }
        }
        // 5.Comprobar que los numeros no estén repetidos.
        for(int i =0; i< numeroDeNumeros; i++)
        {
            for(int j = 0; j < numeroDeNumeros; j++)
            {
                if(i != j)
                {
                    if(numeros[i] == numeros[j])
                    {
                        System.out.println("Lo sentimos algunos de los números están repetidos, pruebe de nuevo");
                        return;
                    }
                }
            }
        }
        // 5.1 Comprobar las estrellas.
        for(int i = 0; i < numeroDeEstrellas; i++)
        {
            for(int j = 0; j < numeroDeEstrellas; j++)
            {
                if(i != j)
                {
                    if(estrellas[i] == estrellas[j])
                    {
                        System.out.println("Lo sentimos algunas de las estrellas están repetidas, pruebe de nuevo");
                        return;
                    }
                }
            }
        }
        // 6.Visualizar Combinacion
        System.out.println("¿Desea visualizar su combinación?");
        String opcion = sc.next();
        if(opcion.equals ("si"))
        {
            System.out.println("Su combinación es: ");
            for(int valores : numeros)
            {
                System.out.print(valores + " ");
            }
            System.out.print("- ");
            for(int valoresEstrellas : estrellas)
            {
                System.out.print(valoresEstrellas + " ");
            }
            System.out.println("\n");
        }else
        {
            return;
        }
        // 7.Generar Combinación Ganadora.
        Random rd = new Random();
        for(int i = 0; i < numeroDeNumeros; i++)
        {
            numerosGanadores[i] = rd.nextInt(50) + 1;
        }
        for(int i = 0; i < numeroDeEstrellas; i++)
        {
            estrellasGanadoras[i] = rd.nextInt(10);
        }
        System.out.println("la combinación ganadora de números es: ");
        for (int visualizarNumeros : numerosGanadores)
        {
            System.out.print(visualizarNumeros + " ");    
        }
        System.out.print("- ");
        for(int visualizarEstrellas : estrellasGanadoras)
        {
            System.out.print(visualizarEstrellas + " ");
        }
        System.out.println("\n");
        // 7.1 Comprobar Combinacion Ganadora
        for(int i = 0; i < numeroDeNumeros; i++)
        {
            for(int j = 0; j < numeroDeNumeros; j++)
            {
                if(i != j)
                {
                    if(numerosGanadores[i] == numerosGanadores[j])
                    {
                        numerosGanadores = new int[] {14, 11, 5, 42, 36};
                        estrellasGanadoras = new int[] {2, 5};
                    }
                }
            }
        }
        for(int i = 0; i < numeroDeEstrellas; i++)
        {
            for(int j = 0; j < numeroDeEstrellas; j++)
            {
                if(i!= j)
                {
                    if(estrellasGanadoras[i] == estrellasGanadoras[j])
                    {
                        numerosGanadores = new int[] {14, 11, 5, 42, 36};
                        estrellasGanadoras = new int[] {2, 5};
                    }
                }
            }
        }
        // 8.Comparar el numero Ganador
        int totalNumerosGanados = 0;
        for(int i = 0; i < numeroDeNumeros; i++)
        {
            for(int k = 0; k < numeroDeNumeros; k++)
            {
                if(numeros[i] == numerosGanadores[k]) 
                {

                    totalNumerosGanados++;
                }
            }
        }

        // 8.1Comparar estrellas Ganadoras
        int totalEstrellasGanadas = 0;
        for(int i = 0; i < numeroDeEstrellas; i++)
        {
            for(int j = 0; j < numeroDeEstrellas; j++)
            {
                if(estrellas[i] == estrellasGanadoras[j])
                {
                    totalEstrellasGanadas++;
                }
            }
        }

        // 9.Calcular el Premio
        if(totalNumerosGanados != 0 || totalEstrellasGanadas != 0)
        { 
            double totalNumeros = totalNumerosGanados * p1;
            double totalEstrellas = totalEstrellasGanadas * p2;
            double premio =  totalNumeros + totalEstrellas;
            System.out.printf("Has ganado %.2f€",premio);
            System.out.println("\n");
        }
        else
        {
            System.out.println("Lo sentimos el boleto no ha sido premiado");
        }
    }
}
