public class OrdenarVetor {
    public static void main(String[] args) {

        // entrada dois vetores;
        int[] vet1 = {4, 3, 10,1};
        int[] vet2 = {7, 8, 2, 4,11};

        int tam = vet1.length + vet2.length;

        //vetor intermediario não ordenado
        int[] vet3 = new int[tam];

        int a = 0;

        for (int x = 0; x < vet1.length; x++) {
            vet3[x] = vet1[x];
        }

        for (int x = vet1.length; x < tam; x++) {
            vet3[x] = vet2[a];
            a++;
        }

        int aux;

        for (int i = 0; i < vet3.length - 1; i++) {
            for (int j = 0; j < vet3.length - 1; j++) {
                if (vet3[j] > vet3[j + 1]) {
                    aux = vet3[j];
                    vet3[j] = vet3[j + 1];
                    vet3[j + 1] = aux;
                }
            }
        }

        System.out.println("Vetor ordenado:");

        for (int i = 0; i < vet3.length; i++) {
            System.out.print( vet3[i] + "-");
        }
    }
}



