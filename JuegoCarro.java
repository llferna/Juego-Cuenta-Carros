package practicasjava;

import java.util.Scanner;

public class JuegoCarro {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);

        String opcionRevancha = null;  //Inicializo como null para que luego tome el valor por el usuario

        System.out.println("""
                           |===================================|
                           |Bienvenido al juego 'Cuenta Carros'|
                           |===================================|
                                     _________
                                     //  ||\\ \\
                                   //    ||  \\ \\
                                  //_____||____\\_\\______
                                  )  _            \\\\ _ \\
                                  |_/ \\_________ __|/ \\_\\
                                 __\\_/_________ ____\\_/___""");
        System.out.println("");
        System.out.println("Numeros de personas a jugar (2 o 3)? ");
        int nPersonas = leer.nextInt();
        //3 Variables para las personas
        String colorP1;
        String colorP2;
        String colorP3;

        //Inicializacion del do while
        do {

            leer.nextLine(); //Para consumir la linea del leer.nextInt

            //Switch para evaluar N° de Personas
            switch (nPersonas) {

                case 2:

                    System.out.println("Colores de auto a elegir de Persona 1 (Rojo, Azul, Negro, Blanco, Plateado, Amarillo): ");
                    colorP1 = leer.nextLine();
                    System.out.println("Color elegido por P1: " + colorP1);

                    System.out.println("Colores de auto a elegir de Persona 2 (Rojo, Azul, Negro, Blanco, Plateado, Amarillo): ");
                    colorP2 = leer.nextLine();

                    while (colorP1.equals(colorP2)) { //Condicion while para evitar que no se repita el mismo color elegido 
                        System.out.println("El color: " + colorP2 + " ha sido elegido por P1, eliga de nuevo");
                        System.out.println("Colores de auto a elegir de Persona 2 (Rojo, Azul, Negro, Blanco, Plateado, Amarillo): ");
                        colorP2 = leer.nextLine();
                    }
                    System.out.println("Color elegido por P2: " + colorP2);

                    System.out.println("Desea agregar un limite de tiempo?: 1.Si 2.No ");
                    int limTiempo = leer.nextInt();

                    //Switch que evalua si desea aniadirse tiempo o no
                    switch (limTiempo) {
                        case 1:
                            System.out.println("Ingrese el tiempo en segundos: "); //El usuario introduce el tiempo en segundos
                            int tiempoEstablecido = leer.nextInt();
                            int tiempoenMilisegundos = tiempoEstablecido * 1000; //Se hace la conversion de segundos a milisegundos para que pueda usar en el Thread.sleep
                            System.out.println("Cronometro iniciado por: " + tiempoEstablecido + " segundos...");

                            try {
                                Thread.sleep(tiempoenMilisegundos); //Toma el valor del usuario por la consola y se usa como delay
                                System.out.println("Tiempo Finalizado!!! ");
                                Thread.sleep(1000); //Tiempo manual de espera para la siguiente linea
                                System.out.println("Persona 1, introduzca el total de carros: ");
                                int totalPersona1 = leer.nextInt();
                                System.out.println("Persona 2, introduzca el total de carros: ");
                                int totalPersona2 = leer.nextInt();

                                //Condicion if else para evaluar si hay empate por los jugadores o no
                                if (totalPersona1 == totalPersona2) {
                                    System.out.println("Empate!! Felicitaciones a ambos jugadores..");
                                    System.out.println("Desean hacer una revancha? (si/no)");
                                    opcionRevancha = leer.next();
                                    if (opcionRevancha.equalsIgnoreCase("si")) {
                                        System.out.println("Cargando revancha..."); //Un if extra para tomar el valor de opcionRevancha y imprimir "cargando revancha"
                                    }
                                } else if (totalPersona1 > totalPersona2) {
                                    System.out.println("Felicidades!! Persona 1 gano el juego..");
                                    opcionRevancha = "no"; //Para que no se repita el bucle do while
                                } else {
                                    System.out.println("Felicidades!! Persona 2 gano el juego..");
                                    opcionRevancha = "no";
                                }
                            } catch (InterruptedException e) {
                            }
                            break;

                        case 2:
                            System.out.println("Persona 1, introduzca el total de carros: ");
                            int totalPersona1 = leer.nextInt();
                            System.out.println("Persona 2, introduzca el total de carros: ");
                            int totalPersona2 = leer.nextInt();

                            if (totalPersona1 == totalPersona2) {
                                System.out.println("Empate!! Felicitaciones a ambos jugadores..");

                                System.out.println("Desean hacer una revancha? (si/no)");
                                opcionRevancha = leer.next();
                                if (opcionRevancha.equalsIgnoreCase("si")) {
                                    System.out.println("Cargando revancha...");
                                }
                            } else if (totalPersona1 > totalPersona2) {
                                System.out.println("Felicidades!! Persona 1 gano el juego..");
                                opcionRevancha = "no";
                            } else {
                                System.out.println("Felicidades!! Persona 2 gano el juego..");
                                opcionRevancha = "no";
                            }
                            break;

                    }

                    break;
                
                //Case para 3 jugadores
                case 3:
                    System.out.println("Colores de auto a elegir de Persona 1 (Rojo, Azul, Negro, Blanco, Plateado, Amarillo): ");
                    colorP1 = leer.nextLine();
                    System.out.println("Color elegido por P1: " + colorP1);

                    System.out.println("Colores de auto a elegir de Persona 2 (Rojo, Azul, Negro, Blanco, Plateado, Amarillo): ");
                    colorP2 = leer.nextLine();

                    while (colorP1.equals(colorP2)) {
                        System.out.println("El color: " + colorP2 + " ha sido elegido por P1, eliga de nuevo");
                        System.out.println("Colores de auto a elegir de Persona 2 (Rojo, Azul, Negro, Blanco, Plateado, Amarillo): ");
                        colorP2 = leer.nextLine();
                    }
                    System.out.println("Color elegido por P2: " + colorP2);

                    System.out.println("Colores de auto a elegir de Persona 3 (Rojo, Azul, Negro, Blanco, Plateado, Amarillo): ");
                    colorP3 = leer.nextLine();

                    while (colorP2.equals(colorP3) || colorP1.equals(colorP3)) {
                        System.out.println("El color: " + colorP3 + " ha sido elegido por P1 o P2, eliga de nuevo");
                        System.out.println("Colores de auto a elegir de Persona 3 (Rojo, Azul, Negro, Blanco, Plateado, Amarillo): ");
                        colorP3 = leer.nextLine();
                    }
                    System.out.println("Color elegido por P3: " + colorP3);

                    System.out.println("Desea agregar un limite de tiempo?: 1.Si 2.No ");
                    limTiempo = leer.nextInt();
                    switch (limTiempo) {
                        case 1:
                            System.out.println("Ingrese el tiempo en segundos: ");
                            int tiempoEstablecido = leer.nextInt();
                            int tiempoenMilisegundos = tiempoEstablecido * 1000;

                            System.out.println("Cronometro iniciado por: " + tiempoEstablecido + " segundos...");
                            try {
                                Thread.sleep(tiempoenMilisegundos);
                                System.out.println("Tiempo Finalizado!!! ");
                                Thread.sleep(1000);
                                System.out.println("Persona 1, introduzca el total de carros: ");
                                int totalPersona1 = leer.nextInt();
                                System.out.println("Persona 2, introduzca el total de carros: ");
                                int totalPersona2 = leer.nextInt();
                                System.out.println("Persona 3, introduzca el total de carros: ");
                                int totalPersona3 = leer.nextInt();

                                if (totalPersona1 == totalPersona2 && totalPersona1 == totalPersona3 && totalPersona2 == totalPersona3) {
                                    System.out.println("Empate!! Felicitaciones a ambos jugadores..");

                                    System.out.println("Desean hacer una revancha? (si/no)");
                                    opcionRevancha = leer.next();
                                    if (opcionRevancha.equalsIgnoreCase("si")) {
                                        System.out.println("Cargando revancha...");
                                    }

                                } else if (totalPersona1 > totalPersona2 && totalPersona1 > totalPersona3) {
                                    System.out.println("Felicidades!! Persona 1 gano el juego..");
                                    opcionRevancha = "no";
                                } else if (totalPersona2 > totalPersona3) {
                                    System.out.println("Felicidades!! Persona 2 gano el juego..");
                                    opcionRevancha = "no";
                                } else {
                                    System.out.println("Felicidades!! Persona 3 gano el juego..");
                                    opcionRevancha = "no";
                                }
                            } catch (InterruptedException e) {
                            }
                            break;

                        case 2:
                            System.out.println("Persona 1, introduzca el total de carros: ");
                            int totalPersona1 = leer.nextInt();
                            System.out.println("Persona 2, introduzca el total de carros: ");
                            int totalPersona2 = leer.nextInt();
                            System.out.println("Persona 3, introduzca el total de carros: ");
                            int totalPersona3 = leer.nextInt();

                            if (totalPersona1 == totalPersona2 && totalPersona2 == totalPersona3) {
                                System.out.println("Empate!! Felicitaciones a todos los jugadores..");

                                System.out.println("Desean hacer una revancha? (si/no)");
                                opcionRevancha = leer.next();
                                if (opcionRevancha.equalsIgnoreCase("si")) {
                                    System.out.println("Cargando revancha...");
                                }
                            } else if (totalPersona1 > totalPersona2 && totalPersona1 > totalPersona3) {
                                System.out.println("Felicidades!! Persona 1 gano el juego..");
                                opcionRevancha = "no";
                            } else if (totalPersona2 > totalPersona1 && totalPersona2 > totalPersona3) {
                                System.out.println("Felicidades!! Persona 2 gano el juego..");
                                opcionRevancha = "no";
                            } else {
                                System.out.println("Felicidades!! Persona 3 gano el juego..");
                                opcionRevancha = "no";
                            }
                            break;

                    }

                    break;

            }
        } while ("si".equalsIgnoreCase(opcionRevancha));
        //Finalizacion del do while

        System.out.println("Gracias por jugar.. ¡Hasta la proxima!");
    }
}
