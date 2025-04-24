
package Academia;

/**
 *
 * @author Heitor
 */
public abstract class Usuario {

    private int id;
    private String nome;
    private String cpf;
    private String email;
    private String dataNasc;
    private String senha;
    private String tipo;

    public Usuario(int id, String nome, String cpf, String email,
    String dataNasc, String senha, String tipo) {
    this.id = id;
    this.nome = nome;
    this.cpf = cpf;
    this.email = email;
    this.dataNasc = dataNasc;
    this.senha = senha;
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
