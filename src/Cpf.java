import java.util.Arrays;
import java.util.Random;

class Cpf {
    String CPF;
    int[] arrCPF;

    Cpf(){
        arrCPF =  generate() ;
        CPF = arrToString(arrCPF);

    }

    Cpf(String inputCpf){
        CPF = inputCpf;
        arrCPF = stringToArray(CPF);
    }

    boolean isValid(){
        int[] mainPart;
        mainPart = Arrays.copyOfRange(arrCPF, 0,9);
        int[] correctDigits;
        correctDigits = fillDigits(mainPart);
        return Arrays.equals( correctDigits , arrCPF );
    }

    private static int[] generate() {
        Random r = new Random();
        int[] cpf = generateMainPart();
        return fillDigits(cpf);
    }

    private static int[] fillDigits(int[] mainPart){
        int[] cpf;
        cpf = Arrays.copyOf(mainPart, 11);
        System.out.println(Arrays.toString(cpf)+" mainpart");
        cpf[9] = getVerificationDigit(Arrays.copyOfRange(cpf, 0, 9));
        System.out.println(Arrays.toString(cpf)+" mainpart");
        cpf[10] = getVerificationDigit(Arrays.copyOfRange(cpf, 0, 10));
        System.out.println(Arrays.toString(cpf)+" mainpart");
        System.out.println(Arrays.toString(cpf));
        return cpf;
    }

    private static int[] generateMainPart(){
        Random r = new Random();
        int[] cpf = new int[9];
        for (int i=0; i<9; i++){
            cpf[i] = r.nextInt(10);
        }
        System.out.println(Arrays.toString(cpf));
        return  cpf;
    }

    private static int getVerificationDigit(int[] cpf){
        int sum = 0;
        for(int i=cpf.length; i>0; i--){
            sum += cpf[cpf.length-i]*(i+1);
        }
        int digito = (sum*10)%11;
        if (digito == 10 || digito == 11){
            return 0;
        }else{
            return digito;
        }
    }

    static String arrToString(int[] arr){
        String AsImplodedString;
        if (arr.length==0) {
            AsImplodedString = "";
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append(arr[0]);
            for (int i=1;i < arr.length;i++) {
                sb.append(arr[i]);
            }
            AsImplodedString = sb.toString();
        }
        return AsImplodedString;
    }

    private static int[] stringToArray(String strCPF){
        String[] arrStrCPF;
        arrStrCPF = strCPF.split("");
        int[] arr;
        arr = new int[ arrStrCPF.length ];
        int i = 0;
        for ( String digitoText : arrStrCPF ) {
            System.out.println(digitoText);
            arr[i] = Integer.parseInt( digitoText );
            i++;
        }
        return arr ;
    }

}
