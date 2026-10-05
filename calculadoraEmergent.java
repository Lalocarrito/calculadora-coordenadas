import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class calculadoraEmergent{

    public static void main(String[] args) {
        SwingUtilities.invokeLater(calculadoraEmergent::menuMain);
    }

    static void menuMain() {
        String[] opciones = {
            "Conversión de puntos", 
            "Cálculo de distancias entre dos puntos", 
            "Salir"
        };
        
        int opcion;
        do {
            opcion = JOptionPane.showOptionDialog(
                null, 
                "Calculadora de Puntos en Sistemas de Coordenadas\n\n" +
                "Desarrollado por:\n" +
                "Hernández Morales Anahí\n" +
                "Ibarra Padilla Sebastián\n" +
                "Martínez Ruiz Josué Ignacio\n" +
                "Román Ruiz María Celeste\n\n" +
                "Todos los derechos reservados", 
                "Menú Principal", 
                JOptionPane.DEFAULT_OPTION, 
                JOptionPane.PLAIN_MESSAGE, 
                null, 
                opciones, 
                opciones[0]
            );
            
            switch (opcion) {
                case 0:
                    conversion();
                    break;
                case 1:
                    distancias();
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, "Gracias por usar nuestra calculadora!");
                    break;
                default:
                    break;
            }
        } while (opcion != 2 && opcion != JOptionPane.CLOSED_OPTION);
    }

    static void conversion() {
        String[] opciones = {
            "2D (Cartesiano a Polar)",
            "2D (Polar a Cartesiano)",
            "3D (SCR a SCC)",
            "3D (SCR a SCE)",
            "3D (SCC a SCR)",
            "3D (SCC a SCE)",
            "3D (SCE a SCR)",
            "3D (SCE a SCC)",
            "Volver al menú"
        };
        
        int opcion;
        do {
            opcion = JOptionPane.showOptionDialog(
                null, 
                "Sistema para convertir puntos\nSeleccione una opción:", 
                "Conversión de Puntos", 
                JOptionPane.DEFAULT_OPTION, 
                JOptionPane.PLAIN_MESSAGE, 
                null, 
                opciones, 
                opciones[0]
            );
            
            switch (opcion) {
                case 0:
                    cartesianoToPolar();
                    break;
                case 1:
                    polarToCartesiano();
                    break;
                case 2:
                    scrScc();
                    break;
                case 3:
                    scrSce();
                    break;
                case 4:
                    sccScr();
                    break;
                case 5:
                    sccSce();
                    break;
                case 6:
                    sceScr();
                    break;
                case 7:
                    sceScc();
                    break;
                case 8:
                case JOptionPane.CLOSED_OPTION:
                    return;
                default:
                    break;
            }
        } while (opcion != 8);
    }

    public static void cartesianoToPolar() {
        String opc = "s";
        while (opc.equalsIgnoreCase("s")) {
            try {
                String inputX = JOptionPane.showInputDialog("Conversión de Cartesiano a Polar (2D)\nIntroduzca el valor de X:");
                if (inputX == null) break;
                double valorX = Double.parseDouble(inputX);

                String inputY = JOptionPane.showInputDialog("Introduzca el valor de Y:");
                if (inputY == null) break;
                double valorY = Double.parseDouble(inputY);

                double valorR = Math.sqrt((Math.pow(valorX, 2) + (Math.pow(valorY, 2))));
                double angulo = Math.toDegrees(Math.atan2(valorY, valorX));
                if (angulo < 0) angulo += 360;

                JOptionPane.showMessageDialog(null, 
                    String.format("Resultados:\nEl valor de R es: %.2f\nEl valor del ángulo es: %.2f°", valorR, angulo));
                
                opc = JOptionPane.showInputDialog("¿Desea realizar otra conversión? (s/n)");
                if (opc == null) opc = "n";
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error: Debe introducir un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void polarToCartesiano() {
        String opc = "s";
        while (opc.equalsIgnoreCase("s")) {
            try {
                String inputR = JOptionPane.showInputDialog("Conversión de Polar a Cartesiano (2D)\nIntroduzca el valor de R:");
                if (inputR == null) break;
                double valorR = Double.parseDouble(inputR);

                String inputAngulo = JOptionPane.showInputDialog("Introduzca el valor del ángulo Theta en grados:");
                if (inputAngulo == null) break;
                double angulo = Math.toRadians(Double.parseDouble(inputAngulo));

                double valorX = valorR * Math.cos(angulo);
                double valorY = valorR * Math.sin(angulo);

                JOptionPane.showMessageDialog(null, 
                    String.format("Resultados:\nEl valor de X es: %.2f\nEl valor de Y es: %.2f", valorX, valorY));
                
                opc = JOptionPane.showInputDialog("¿Desea realizar otra conversión? (s/n)");
                if (opc == null) opc = "n";
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error: Debe introducir un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    // Métodos restantes adaptados de manera similar...
    // scrScc(), scrSce(), sccScr(), sccSce(), sceScr(), sceScc()
    // distancias(), distCart(), distPol(), distSCR(), distSCC(), distSCE()

    static void distancias() {
        String[] opciones = {
            "2D (Cartesiano)",
            "2D (Polares)",
            "3D (SCR)",
            "3D (SCC)",
            "3D (SCE)",
            "Volver al menú"
        };
        
        int opcion;
        do {
            opcion = JOptionPane.showOptionDialog(
                null, 
                "Sistema para obtener distancias\nSeleccione una opción:", 
                "Cálculo de Distancias", 
                JOptionPane.DEFAULT_OPTION, 
                JOptionPane.PLAIN_MESSAGE, 
                null, 
                opciones, 
                opciones[0]
            );
            
            switch (opcion) {
                case 0:
                    distCart();
                    break;
                case 1:
                    distPol();
                    break;
                case 2:
                    distSCR();
                    break;
                case 3:
                    distSCC();
                    break;
                case 4:
                    distSCE();
                    break;
                case 5:
                case JOptionPane.CLOSED_OPTION:
                    return;
                default:
                    break;
            }
        } while (opcion != 5);
    }

    static void distCart() {
        String opc = "s";
        while (opc.equalsIgnoreCase("s")) {
            try {
                String inputX1 = JOptionPane.showInputDialog("Distancia entre dos puntos Cartesianos\nIntroduzca el valor de X1:");
                if (inputX1 == null) break;
                double x1 = Double.parseDouble(inputX1);

                String inputY1 = JOptionPane.showInputDialog("Introduzca el valor de Y1:");
                if (inputY1 == null) break;
                double y1 = Double.parseDouble(inputY1);

                String inputX2 = JOptionPane.showInputDialog("Introduzca el valor de X2:");
                if (inputX2 == null) break;
                double x2 = Double.parseDouble(inputX2);

                String inputY2 = JOptionPane.showInputDialog("Introduzca el valor de Y2:");
                if (inputY2 == null) break;
                double y2 = Double.parseDouble(inputY2);

                double distancia = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));

                JOptionPane.showMessageDialog(null, 
                    String.format("La distancia entre los puntos es: %.2f", distancia));
                
                opc = JOptionPane.showInputDialog("¿Desea realizar otro cálculo? (s/n)");
                if (opc == null) opc = "n";
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error: Debe introducir un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void scrScc() {
        String opc = "s";
        while (opc.equalsIgnoreCase("s")) {
            try {
                String inputX = JOptionPane.showInputDialog("Conversión de SCR a SCC (3D)\nIntroduzca el lado en X:");
                if (inputX == null) break;
                double valorX = Double.parseDouble(inputX);
    
                String inputY = JOptionPane.showInputDialog("Introduzca el lado en Y:");
                if (inputY == null) break;
                double valorY = Double.parseDouble(inputY);
    
                String inputZ = JOptionPane.showInputDialog("Introduzca el lado en Z:");
                if (inputZ == null) break;
                double valorZ = Double.parseDouble(inputZ);
                
                double valorR = Math.sqrt((Math.pow(valorX, 2) + (Math.pow(valorY, 2))));
                double angulo = Math.toDegrees(Math.atan2(valorY, valorX));
                if (angulo < 0) angulo += 360;
    
                JOptionPane.showMessageDialog(null, 
                    String.format("Resultados:\nEl valor de R es: %.2f\nEl valor del ángulo Theta es: %.2f°\nEl valor de Z es: %.2f", 
                    valorR, angulo, valorZ));
                
                opc = JOptionPane.showInputDialog("¿Desea realizar otra conversión? (s/n)");
                if (opc == null) opc = "n";
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error: Debe introducir un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    public static void scrSce() {
        String opc = "s";
        while (opc.equalsIgnoreCase("s")) {
            try {
                String inputX = JOptionPane.showInputDialog("Conversión de SCR a SCE\nIntroduzca el lado en X:");
                if (inputX == null) break;
                double valorX = Double.parseDouble(inputX);
    
                String inputY = JOptionPane.showInputDialog("Introduzca el lado en Y:");
                if (inputY == null) break;
                double valorY = Double.parseDouble(inputY);
    
                String inputZ = JOptionPane.showInputDialog("Introduzca el lado en Z:");
                if (inputZ == null) break;
                double valorZ = Double.parseDouble(inputZ);
    
                double valorRo = Math.sqrt((Math.pow(valorX, 2) + (Math.pow(valorY, 2)) + (Math.pow(valorZ, 2))));
                double anguloTheta = Math.toDegrees(Math.atan2(valorY, valorX));
                if (anguloTheta < 0) anguloTheta += 360;

                double anguloPhi = Math.toDegrees(Math.atan(Math.sqrt((valorX * valorX) + (valorY * valorY)) / valorZ));
    
                JOptionPane.showMessageDialog(null, 
                    String.format("Resultados:\nEl valor de Rho es: %.2f\nEl valor del ángulo Theta es: %.2f°\nEl valor del ángulo Phi es: %.2f°", 
                    valorRo, anguloTheta, anguloPhi));
                
                opc = JOptionPane.showInputDialog("¿Desea realizar otra conversión? (s/n)");
                if (opc == null) opc = "n";
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error: Debe introducir un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    public static void sccScr() {
        String opc = "s";
        while (opc.equalsIgnoreCase("s")) {
            try {
                String inputR = JOptionPane.showInputDialog("Conversión de SCC a SCR\nIntroduzca el valor de R:");
                if (inputR == null) break;
                double valorR = Double.parseDouble(inputR);
    
                String inputAngulo = JOptionPane.showInputDialog("Introduzca el valor del ángulo Theta en grados:");
                if (inputAngulo == null) break;
                double angulo = Math.toRadians(Double.parseDouble(inputAngulo));
    
                String inputZ = JOptionPane.showInputDialog("Introduzca el valor en Z:");
                if (inputZ == null) break;
                double valorZ = Double.parseDouble(inputZ);
    
                double valorX = valorR * Math.cos(angulo);
                double valorY = valorR * Math.sin(angulo);
    
                JOptionPane.showMessageDialog(null, 
                    String.format("Resultados:\nEl valor de X es: %.2f\nEl valor de Y es: %.2f\nEl valor de Z es: %.2f", 
                    valorX, valorY, valorZ));
                
                opc = JOptionPane.showInputDialog("¿Desea realizar otra conversión? (s/n)");
                if (opc == null) opc = "n";
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error: Debe introducir un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    public static void sccSce() {
        String opc = "s";
        while (opc.equalsIgnoreCase("s")) {
            try {
                String inputR = JOptionPane.showInputDialog("Conversión de SCC a SCE\nIntroduzca el valor de R:");
                if (inputR == null) break;
                double valorR = Double.parseDouble(inputR);
    
                String inputAngulo = JOptionPane.showInputDialog("Introduzca el valor del ángulo Theta en grados:");
                if (inputAngulo == null) break;
                double anguloTheta = Double.parseDouble(inputAngulo);
    
                String inputZ = JOptionPane.showInputDialog("Introduzca el valor de Z:");
                if (inputZ == null) break;
                double valorZ = Double.parseDouble(inputZ);
    
                double valorRo = Math.sqrt((Math.pow(valorR, 2) + (Math.pow(valorZ, 2))));
                double anguloPhi = Math.toDegrees(Math.atan2(valorR, valorZ));
                if (anguloPhi < 0) anguloPhi += 360;
    
                JOptionPane.showMessageDialog(null, 
                    String.format("Resultados:\nEl valor de Rho es: %.2f\nEl valor del ángulo Theta es: %.2f°\nEl valor del ángulo Phi es: %.2f°", 
                    valorRo, anguloTheta, anguloPhi));
                
                opc = JOptionPane.showInputDialog("¿Desea realizar otra conversión? (s/n)");
                if (opc == null) opc = "n";
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error: Debe introducir un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    public static void sceScr() {
        String opc = "s";
        while (opc.equalsIgnoreCase("s")) {
            try {
                String inputRo = JOptionPane.showInputDialog("Conversión de SCE a SCR\nIntroduzca el valor de Rho:");
                if (inputRo == null) break;
                double valorRo = Double.parseDouble(inputRo);
    
                String inputTheta = JOptionPane.showInputDialog("Introduzca el valor del ángulo Theta en grados:");
                if (inputTheta == null) break;
                double anguloTheta = Math.toRadians(Double.parseDouble(inputTheta));
    
                String inputPhi = JOptionPane.showInputDialog("Introduzca el valor del ángulo Phi en grados:");
                if (inputPhi == null) break;
                double anguloPhi = Math.toRadians(Double.parseDouble(inputPhi));
    
                double valorX = valorRo * Math.sin(anguloPhi) * Math.cos(anguloTheta);
                double valorY = valorRo * Math.sin(anguloPhi) * Math.sin(anguloTheta);
                double valorZ = valorRo * Math.cos(anguloPhi);
    
                JOptionPane.showMessageDialog(null, 
                    String.format("Resultados:\nEl valor de X es: %.2f\nEl valor de Y es: %.2f\nEl valor de Z es: %.2f", 
                    valorX, valorY, valorZ));
                
                opc = JOptionPane.showInputDialog("¿Desea realizar otra conversión? (s/n)");
                if (opc == null) opc = "n";
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error: Debe introducir un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    public static void sceScc() {
        String opc = "s";
        while (opc.equalsIgnoreCase("s")) {
            try {
                String inputRo = JOptionPane.showInputDialog("Conversión de SCE a SCC\nIntroduzca el valor de Rho:");
                if (inputRo == null) break;
                double valorRo = Double.parseDouble(inputRo);
    
                String inputTheta = JOptionPane.showInputDialog("Introduzca el valor del ángulo Theta en grados:");
                if (inputTheta == null) break;
                double anguloTheta = Double.parseDouble(inputTheta);
    
                String inputPhi = JOptionPane.showInputDialog("Introduzca el valor del ángulo Phi en grados:");
                if (inputPhi == null) break;
                double anguloPhi = Math.toRadians(Double.parseDouble(inputPhi));
    
                double valorR = valorRo * Math.sin(anguloPhi);
                double valorZ = valorRo * Math.cos(anguloPhi);
    
                JOptionPane.showMessageDialog(null, 
                    String.format("Resultados:\nEl valor de R es: %.2f\nEl valor del ángulo Theta es: %.2f°\nEl valor de Z es: %.2f", 
                    valorR, anguloTheta, valorZ));
                
                opc = JOptionPane.showInputDialog("¿Desea realizar otra conversión? (s/n)");
                if (opc == null) opc = "n";
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error: Debe introducir un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    static void distPol() {
        String opc = "s";
        while (opc.equalsIgnoreCase("s")) {
            try {
                String inputR1 = JOptionPane.showInputDialog("Distancia entre dos puntos en Polares\nIntroduzca el valor de r1:");
                if (inputR1 == null) break;
                double r1 = Double.parseDouble(inputR1);
    
                String inputT1 = JOptionPane.showInputDialog("Introduzca el valor del ángulo Theta1 en grados:");
                if (inputT1 == null) break;
                double t1 = Math.toRadians(Double.parseDouble(inputT1));
    
                String inputR2 = JOptionPane.showInputDialog("Introduzca el valor de r2:");
                if (inputR2 == null) break;
                double r2 = Double.parseDouble(inputR2);
    
                String inputT2 = JOptionPane.showInputDialog("Introduzca el valor del ángulo Theta2 en grados:");
                if (inputT2 == null) break;
                double t2 = Math.toRadians(Double.parseDouble(inputT2));
    
                double distancia = Math.sqrt(Math.pow(r1, 2) + Math.pow(r2, 2) - (2 * r1 * r2 * Math.cos(t2 - t1)));
    
                JOptionPane.showMessageDialog(null, 
                    String.format("La distancia entre los puntos es: %.2f", distancia));
                
                opc = JOptionPane.showInputDialog("¿Desea realizar otro cálculo? (s/n)");
                if (opc == null) opc = "n";
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error: Debe introducir un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    static void distSCR() {
        String opc = "s";
        while (opc.equalsIgnoreCase("s")) {
            try {
                String inputX1 = JOptionPane.showInputDialog("Distancia entre dos puntos en SCR\nIntroduzca el valor de X1:");
                if (inputX1 == null) break;
                double x1 = Double.parseDouble(inputX1);
    
                String inputY1 = JOptionPane.showInputDialog("Introduzca el valor de Y1:");
                if (inputY1 == null) break;
                double y1 = Double.parseDouble(inputY1);
    
                String inputZ1 = JOptionPane.showInputDialog("Introduzca el valor de Z1:");
                if (inputZ1 == null) break;
                double z1 = Double.parseDouble(inputZ1);
    
                String inputX2 = JOptionPane.showInputDialog("Introduzca el valor de X2:");
                if (inputX2 == null) break;
                double x2 = Double.parseDouble(inputX2);
    
                String inputY2 = JOptionPane.showInputDialog("Introduzca el valor de Y2:");
                if (inputY2 == null) break;
                double y2 = Double.parseDouble(inputY2);
    
                String inputZ2 = JOptionPane.showInputDialog("Introduzca el valor de Z2:");
                if (inputZ2 == null) break;
                double z2 = Double.parseDouble(inputZ2);
    
                double distancia = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2) + Math.pow(z2 - z1, 2));
    
                JOptionPane.showMessageDialog(null, 
                    String.format("La distancia entre los puntos es: %.2f", distancia));
                
                opc = JOptionPane.showInputDialog("¿Desea realizar otro cálculo? (s/n)");
                if (opc == null) opc = "n";
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error: Debe introducir un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    static void distSCC() {
        String opc = "s";
        while (opc.equalsIgnoreCase("s")) {
            try {
                String inputR1 = JOptionPane.showInputDialog("Distancia entre dos puntos en SCC\nIntroduzca el valor de r1:");
                if (inputR1 == null) break;
                double r1 = Double.parseDouble(inputR1);
    
                String inputT1 = JOptionPane.showInputDialog("Introduzca el valor del ángulo Theta1 en grados:");
                if (inputT1 == null) break;
                double t1 = Math.toRadians(Double.parseDouble(inputT1));
    
                String inputZ1 = JOptionPane.showInputDialog("Introduzca el valor de Z1:");
                if (inputZ1 == null) break;
                double z1 = Double.parseDouble(inputZ1);
    
                String inputR2 = JOptionPane.showInputDialog("Introduzca el valor de r2:");
                if (inputR2 == null) break;
                double r2 = Double.parseDouble(inputR2);
    
                String inputT2 = JOptionPane.showInputDialog("Introduzca el valor del ángulo Theta2 en grados:");
                if (inputT2 == null) break;
                double t2 = Math.toRadians(Double.parseDouble(inputT2));
    
                String inputZ2 = JOptionPane.showInputDialog("Introduzca el valor de Z2:");
                if (inputZ2 == null) break;
                double z2 = Double.parseDouble(inputZ2);
    
                double distancia = Math.sqrt(Math.pow(r1, 2) + Math.pow(r2, 2) - (2 * r1 * r2 * Math.cos(t2 - t1)) + Math.pow(z2 - z1, 2));
    
                JOptionPane.showMessageDialog(null, 
                    String.format("La distancia entre los puntos es: %.2f", distancia));
                
                opc = JOptionPane.showInputDialog("¿Desea realizar otro cálculo? (s/n)");
                if (opc == null) opc = "n";
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error: Debe introducir un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    static void distSCE() {
        String opc = "s";
        while (opc.equalsIgnoreCase("s")) {
            try {
                JOptionPane.showMessageDialog(null, "Coordenadas del punto 1:");
                String inputRo1 = JOptionPane.showInputDialog("Introduzca el valor de Rho:");
                if (inputRo1 == null) break;
                double rho1 = Double.parseDouble(inputRo1);
    
                String inputTheta1 = JOptionPane.showInputDialog("Introduzca el valor del ángulo Theta en grados:");
                if (inputTheta1 == null) break;
                double anguloTheta1 = Math.toRadians(Double.parseDouble(inputTheta1));
    
                String inputPhi1 = JOptionPane.showInputDialog("Introduzca el valor del ángulo Phi en grados:");
                if (inputPhi1 == null) break;
                double anguloPhi1 = Math.toRadians(Double.parseDouble(inputPhi1));
    
                JOptionPane.showMessageDialog(null, "Coordenadas del punto 2:");
                String inputRo2 = JOptionPane.showInputDialog("Introduzca el valor de Rho:");
                if (inputRo2 == null) break;
                double rho2 = Double.parseDouble(inputRo2);
    
                String inputTheta2 = JOptionPane.showInputDialog("Introduzca el valor del ángulo Theta en grados:");
                if (inputTheta2 == null) break;
                double anguloTheta2 = Math.toRadians(Double.parseDouble(inputTheta2));
    
                String inputPhi2 = JOptionPane.showInputDialog("Introduzca el valor del ángulo Phi en grados:");
                if (inputPhi2 == null) break;
                double anguloPhi2 = Math.toRadians(Double.parseDouble(inputPhi2));
    
                double distancia = Math.sqrt((Math.pow(rho2, 2) + Math.pow(rho1, 2))
                - (2 * rho1 * rho2 * ((Math.cos(anguloPhi1) * Math.cos(anguloPhi2))
                        + (Math.sin(anguloPhi1) * Math.sin(anguloPhi2)
                                * Math.cos(anguloTheta2 - anguloTheta1)))));
    
                JOptionPane.showMessageDialog(null, 
                    String.format("La distancia entre los puntos es: %.2f", distancia));
                
                opc = JOptionPane.showInputDialog("¿Desea realizar otro cálculo? (s/n)");
                if (opc == null) opc = "n";
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error: Debe introducir un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}