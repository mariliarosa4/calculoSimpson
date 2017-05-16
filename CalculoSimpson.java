/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculosimpson;

import static java.lang.Math.pow;

/**
 *
 * @author gabrielle
 */

public class CalculoSimpson {
        static int grauFuncao=2;
        static double[] coeficiente = new double[grauFuncao+1];
        static char[] operadores = new char[grauFuncao];
        static double limiteMin=4;
        static double limiteMax=8;
        static double h;
        static double resultadoFinal;
        static int intervalos;

    /**
     * @param args the command line arguments
     */
    static double calculaH(double min, double max, int intervalos){
        double h=(max-min)/2*intervalos;
        return h;
    }
    static double realizaFuncao(double valorX){
        double resultado= (coeficiente[grauFuncao]*(pow(valorX, grauFuncao)));
        int j;
        for(j=grauFuncao-1; j>=0; j--){
            switch(operadores[j]){
                case '+':
                resultado+= coeficiente[j]*(pow(valorX, j));
                break;
            case '-':
                resultado-= coeficiente[j]*(pow(valorX, j));
                break;
            case '*':
                resultado*= coeficiente[j]*(pow(valorX, j));
                break;
            case '/':
                resultado/= coeficiente[j]*(pow(valorX, j));
                break;
            default:
                return 0;
            }
        }
        return resultado;
    }
    public static void main(String[] args) {
        
        
        coeficiente[2]=3;
        coeficiente[1]=2;
        coeficiente[0]=1;
        
        operadores[1]='+';
        operadores[0]='-';
        
        h=calculaH(limiteMin, limiteMax, 2);
        int i=0;
        double valorX, somatorioFuncao=0;
        do{
            valorX=(limiteMin+(h*i));
            if(i==0 || valorX==limiteMax){
                somatorioFuncao+=realizaFuncao(valorX);
            }else if(i%2==0){
                somatorioFuncao+=2*realizaFuncao(valorX);
            }else{
                somatorioFuncao+=4*realizaFuncao(valorX);
            }
            i++;
        }while(valorX<limiteMax);
        resultadoFinal= (h/3)*somatorioFuncao;
        System.out.println(resultadoFinal);
    }
    
}
