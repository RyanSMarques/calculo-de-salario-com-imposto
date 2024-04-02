package teste;
import java.util.*;

class funcionario {
    private String nome;
    private float salarioBruto;
    private float imposto;
    private float salarioLiquido;

    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setSalarioBruto(float salarioBruto) {
        this.salarioBruto = salarioBruto;
    }
    public void setImposto(float imposto) {
        this.imposto = imposto;
    }
    public void setSalarioLiquido(float salarioLiquido) {
        this.salarioLiquido = salarioLiquido;
    }

    public String getNome() {
        return nome;
    }
    public float getSalarioBruto() {
        return salarioBruto;
    }
    public float getImposto() {
        return imposto;
    }
    public float getSalarioLiquido() {
        return salarioLiquido;
    }

    @Override
    public String toString() {
        return "--FOLHA DE PAGAMENTO--" + "\n " +"Nome: " + getNome() + "\n" +
                "Valor do imposto: " + getImposto() + "\n" +
                "Valor líquido a receber: " + (getSalarioBruto() - getImposto());
    }
}

public class teste1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tamanho = 6;
        ArrayList<funcionario> cadastro = new ArrayList<funcionario>(tamanho);
        String[] nomeInicial = new String[tamanho];
        String letra;
        boolean encontrouFuncionario;
        System.out.println("Digite a inicial dos funcionários que deseja ver: ");
        letra = sc.next();
        String suffix = letra;
        for (int i = 0; i < tamanho; i++) {
            funcionario FuncionarioObj = new funcionario();
            System.out.println("Digite o nome do " + (i + 1) + "º funcionário: ");
            FuncionarioObj.setNome(sc.next());
            System.out.println("Digite o salario bruto do " + (i + 1) + "º funcionario: ");
            FuncionarioObj.setSalarioBruto(sc.nextFloat());
            cadastro.add(FuncionarioObj);

            // salario com desconto do imposto
            if (cadastro.get(i).getSalarioBruto() < 850) {
                cadastro.get(i).setImposto(0);
            } else if (cadastro.get(i).getSalarioBruto() >= 850 && cadastro.get(i).getSalarioBruto() < 1200) {
                cadastro.get(i).setImposto(cadastro.get(i).getSalarioBruto() * 0.1f);
            } else if (cadastro.get(i).getSalarioBruto() >= 1200) {
                cadastro.get(i).setImposto(cadastro.get(i).getSalarioBruto() * 0.2f);
            } else if (cadastro.get(i).getSalarioBruto() < 0) {
                System.out.println("Erro!! Este salário não existe!");
            }

            // condição para saber se algum nome começa com a letra já sugerida
            if (cadastro.get(i).getNome().startsWith(suffix)) {
                nomeInicial[i] = cadastro.get(i).getNome();
                encontrouFuncionario = true;
            }

        }
        
            // o problema da mensagem se repetir sempre foi corrigido já :)
            if(encontrouFuncionario = false){
                System.err.println("Nenhum funcionário tem o nome com a letra fornecida!!");
            }
        

        for (funcionario f : cadastro) {
            System.out.println(f);
        }
    }
}
