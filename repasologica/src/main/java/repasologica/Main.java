package repasologica;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Se requiere desarollar un programa que permita ingresar la estatura y el peso de los estudiantes de un curso
        //el usuario debe indicar cuantos estudiantes van a hacer ingresados en el sistema
        //Luego el sistema deberá indicar mediante un menú 1) estadisticas de la altura
        //2) estadisticas del peso
        //3) estadisticas del indice de masa corporal
        //y en cada uno de estos, indicar maximos, minimos y promedios

        double maxAltura = 0,
                minAltura = 0,
                promAltura,
                maxPeso = 0,
                minPeso = 0,
                promPeso,
                maxImc = 0,
                minImc = 0,
                promImc,
                sumAltura = 0,
                sumPeso = 0,
                sumImc = 0;

        int indiceArr;
        int cantidad, opcion;

        Scanner sc = new Scanner(System.in);
        System.out.println("Señor usuario favor ingrsar la cantidad de estudiantes a ingresar en el sistema");
        cantidad = sc.nextInt();
        double[] estaturas = new double[cantidad];
        double[] peso = new double[cantidad];
        String[] nombres = new String[cantidad];
        double[] imc = new double[cantidad];

        for(int i = 0; i < cantidad; i++){
            System.out.println("Ingrese nombre del estudiante " + (i + 1));
            sc.next();
            nombres[i] = sc.nextLine();
        }



        for(int i = 0; i < cantidad; i++){
            System.out.println("Señor usuario favor ingresar la estatura del estudiante " + nombres[i]);
            estaturas[i] = sc.nextDouble();
            sumAltura += estaturas[i];
        }

        for(int k = 0; k < peso.length; k++){
            System.out.println("Ingrese el peso del estudiante: " + nombres[k]);
            peso[k] = sc.nextDouble();
            sumPeso += peso[k];
        }

        //calcular imc
        for(int i = 0; i < cantidad; i++){
            imc[i] = peso[i]/Math.pow(estaturas[i], 2);
            sumImc += imc[i];
        }



        //Obtener maximos:

        for(int i = 0; i < cantidad; i++){

            if(estaturas[i] > maxAltura){
                maxAltura = estaturas[i];
                indiceArr = i;
            }

            if(peso[i] > maxPeso){
                maxPeso = peso[i];
                indiceArr = i;
            }

            if(imc[i] > maxImc) {
                maxImc = imc[i];
                indiceArr = i;
            }

        }


        //valores minimos:
        for(int i = 0; i < cantidad; i++){
            minAltura = estaturas[0];
            minPeso = peso[0];
            minImc = imc[0];

          if(minAltura < estaturas[i]){
                minAltura = estaturas[i];
            }

            if(minPeso < peso[i]){
                minPeso = peso[i];
            }

            if(minImc < imc[i]){
                minImc = imc[i];
            }
        }


        //obtener los promedios:
        promPeso = sumPeso/cantidad;
        promAltura = sumAltura/cantidad;
        promImc = sumImc/cantidad;

        int opcionBucle = 1;
        do {
            System.out.println("Ingrese la opción 1) Estadisticas altura 2) Estadisticas peso 3) Estadistica imc 4) Salir");
            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("La altura maxima es: " + maxAltura + " pertenece a: ");
                    System.out.println("La altura minima es : " + minAltura + " pertenece a: ");
                    System.out.println("La altura promedio es: " + promAltura + " pertenece a: ");
                    break;
                case 2:
                    System.out.println("El peso maximo es: " + maxPeso);
                    System.out.println("El peso minimo es: " + minPeso);
                    System.out.println("El promedio del peso: " + promPeso);
                    break;
                case 3:
                    System.out.println("El imc maximo es: " + maxImc);
                    System.out.println("El imc minimo es: " + minImc);
                    System.out.println("El promedio del imc es: " + promImc);
                    break;
                case 4:
                    System.out.println("Gracias por utilizar nuestro sistema, regresa pronto");
                    opcionBucle = 0;
                    break;
                default:
                    System.out.println("Has elegido una opcion incorrecta, intenta nuevamente");
            }
        } while(opcionBucle != 0);
    }
}