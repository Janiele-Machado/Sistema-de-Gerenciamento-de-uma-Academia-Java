package Academia;

import java.sql.Date;

/**
 *
 * @author Janiele
 */
public class Adm extends Usuario {

    private double salario;
    private String numero_comercial;
    private String setor;
    private String desc;

    public Adm(int id, String nome, String cpf, String email,
            Date dataNasc, String senha, String tipo, double salario, String setor, String numero_comercial, String desc) {
        super(id, nome, cpf, email, dataNasc, senha, tipo);
        this.salario = salario;
        this.setor = setor;
        this.salario = salario;
        this.desc = desc;
    }

    //construtor vazio
    public Adm() {

    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public void setNumero_comercial(String numero_comercial) {
        this.numero_comercial = numero_comercial;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public double getSalario() {
        return salario;
    }

    public String getNumero_comercial() {
        return numero_comercial;
    }

    public String getSetor() {
        return setor;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
    
    
}
