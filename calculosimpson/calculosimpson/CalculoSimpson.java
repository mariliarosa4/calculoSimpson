/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculosimpson;

import static java.lang.Math.pow;

/**
 *
 * @author  Marília e Gabriel
 */
public class CalculoSimpson {

    int grauFuncao;
    double[] coeficiente;
    double limiteMin;
    double limiteMax;
    double h;
    double resultadoFinal;
    int intervalos;
    double expoente;

    public double getExpoente() {
        return expoente;
    }

    public void setExpoente(double expoente) {
        this.expoente = expoente;
    }

    
    char tipoFuncao; //P - Polinomial; L - Logaritimica; S - Seno; T - tangente; C - Cosseno;

    public CalculoSimpson(int grauFuncao, double limiteMin, double limiteMax, int intervalos) {
        this.grauFuncao = grauFuncao;
        this.limiteMin = limiteMin;
        this.limiteMax = limiteMax;
        this.intervalos = intervalos;
        this.coeficiente = new double[grauFuncao + 1];
        calculaH(this.limiteMin, this.limiteMax, this.intervalos);

    }

    /**
     * @param args the command line arguments
     */
    final void calculaH(double min, double max, int intervalos) {
        this.h = (max - min) / (2 * intervalos);
    }

    public double realizaFuncao(double valorX) {
        double resultado = (this.coeficiente[this.grauFuncao] * (pow(valorX, this.grauFuncao)));
        int j;
        for (j = grauFuncao - 1; j >= 0; j--) {
            resultado += coeficiente[j] * (pow(valorX, j));
        }
        return resultado;
    }

    public double funcaoLog(double valorX) {
        return Math.log(valorX) * coeficiente[0];
    }

     public double funcaoE(double valorX) {
        return pow(Math.E, (valorX) * coeficiente[0]);
    }
    public double funcaoSeno(double valorX) {
        return Math.sin(valorX) * coeficiente[0];
    }

    public double funcaoCosseno(double valorX) {
        return Math.cos(valorX) * coeficiente[0];
    }

    public double funcaoTangente(double valorX) {
        return Math.tan(valorX) * coeficiente[0];
    }

    public double calcularIntegralFinal() {

        int i = 0;
        double valorX, somatorioFuncao = 0;
        switch (tipoFuncao) {
            case 'P':
                do {
                    valorX = (limiteMin + (h * i));
                    if (i == 0 || valorX == limiteMax) {
                        somatorioFuncao += realizaFuncao(valorX);
                    } else if (i % 2 == 0) {
                        somatorioFuncao += 2 * realizaFuncao(valorX);
                    } else {
                        somatorioFuncao += 4 * realizaFuncao(valorX);
                    }
                    i++;
                } while (valorX < limiteMax);
                break;
            case 'L':
                do {
                    valorX = (limiteMin + (h * i));
                    
                    if (i == 0 || valorX == limiteMax) {
                        somatorioFuncao += funcaoLog(pow(valorX, expoente));
                    } else if (i % 2 == 0) {
                        somatorioFuncao += 2 * funcaoLog(pow(valorX, expoente));
                    } else {
                        somatorioFuncao += 4 * funcaoLog(pow(valorX, expoente));
                    }
                    i++;
                } while (valorX < limiteMax);
                break;
            case 'S':
                do {
                    valorX = (limiteMin + (h * i));
                    if (i == 0 || valorX == limiteMax) {
                        somatorioFuncao += funcaoSeno(pow(valorX, expoente));
                    } else if (i % 2 == 0) {
                        somatorioFuncao += 2 * funcaoSeno(pow(valorX, expoente));
                    } else {
                        somatorioFuncao += 4 * funcaoSeno(pow(valorX, expoente));
                    }
                    i++;
                } while (valorX < limiteMax);
                break;
            case 'T':
                do {
                    valorX = (limiteMin + (h * i));
                    if (i == 0 || valorX == limiteMax) {
                        somatorioFuncao += funcaoTangente(valorX);
                    } else if (i % 2 == 0) {
                        somatorioFuncao += 2 * funcaoTangente(valorX);
                    } else {
                        somatorioFuncao += 4 * funcaoTangente(valorX);
                    }
                    i++;
                } while (valorX < limiteMax);
                break;
            case 'C':
                do {
                    valorX = (limiteMin + (h * i));
                    if (i == 0 || valorX == limiteMax) {
                        somatorioFuncao += funcaoCosseno(pow(valorX, expoente));
                    } else if (i % 2 == 0) {
                        somatorioFuncao += 2 * funcaoCosseno(pow(valorX, expoente));
                    } else {
                        somatorioFuncao += 4 * funcaoCosseno(pow(valorX, expoente));
                    }
                    i++;
                } while (valorX < limiteMax);
                break;
            case 'E':
                 do {
                    valorX = (limiteMin + (h * i));
                    if (i == 0 || valorX == limiteMax) {
                        somatorioFuncao += funcaoE(pow(valorX, expoente));
                    } else if (i % 2 == 0) {
                        somatorioFuncao += 2 * funcaoE(pow(valorX, expoente));
                    } else {
                        somatorioFuncao += 4 * funcaoE(pow(valorX, expoente));
                    }
                    i++;
                } while (valorX < limiteMax);
                break;
            
               
        }
        resultadoFinal = (h / 3) * somatorioFuncao;
        System.out.println(resultadoFinal);
        return resultadoFinal;
    }

    public char getTipoFuncao() {
        return tipoFuncao;
    }

    public void setTipoFuncao(char tipoFuncao) {
        this.tipoFuncao = tipoFuncao;
    }

  

}
