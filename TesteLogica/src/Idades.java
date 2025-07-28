import java.util.Scanner;

public class Idades {

    //Escreva um algoritmo que leia as idades de 2 homens e de 2 mulheres
    // (considere que as idades dos homens serão sempre diferentes entre si,
    // bem como as das mulheres).
    // Calcule e escreva a soma das idades do homem mais velho com
    // a mulher mais nova, e o produto das idades do homem mais novo com
    // a mulher mais velha.

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


        int h1 = 0, h2 = 0, hvelho = 0, hnovo = 0;
        int m1 = 0, m2 = 0, mvelha = 0, mnova = 0;

        System.out.println("digite a idade do primeiro homem");
        h1 = sc.nextInt();
        System.out.println("digite a idade do segundo homem");
        h2 = sc.nextInt();


        System.out.println("digite a idade da primeira mulher");
        m1 = sc.nextInt();
        System.out.println("digite a idade da segunda mulher");
        m2 = sc.nextInt();


        if(h1 > h2){
            hvelho = h1;
            hnovo = h2;
        }else{
            hvelho = h2;
            hnovo = h1;
        }

        if(m1 > m2){
            mvelha = m1;
            mnova =m2;
        }
        else{
            mvelha = m2;
            mnova = m1;
        }

        System.out.println("A soma das idades do h mais velho com a mulher mais nova é : " + (hvelho+mnova));
        System.out.println("O produto das idades do h mais novo com a mulher mais velha é: " + (hnovo * mvelha));

    }
}
