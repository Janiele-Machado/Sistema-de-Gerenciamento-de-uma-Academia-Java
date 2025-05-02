package Academia;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 * @author Heitor
 */
public abstract class Usuario {

    private int id;
    private String nome;
    private String cpf;
    private String email;
    private Date dataNasc;
    private String senha;
    private String tipo;

    public Usuario(int id, String nome, String cpf, String email,
            Date dataNasc, String senha, String tipo) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.dataNasc = dataNasc;
        this.senha = senha;
        this.tipo = tipo;

    }

    //construtor vazio
    public Usuario() {

    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDataNasc(String dataNasc) {
         try {
             //Método que recebe a data de nascimento do usuario em String e converte para o padrao date;
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            java.util.Date dataUtil = formato.parse(dataNasc);
            this.dataNasc = new Date(dataUtil.getTime());
        } catch (ParseException e) {
            System.out.println("Formato de data inválido. Use dd/MM/yyyy.");
            e.printStackTrace();
        }
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

    public String getDataNasc() {
        return dataNasc;
    }

    public String getSenha() {
        return senha;
    }

    public String getTipo() {
        return tipo;
    }

}
