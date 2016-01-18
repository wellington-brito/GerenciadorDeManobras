package wellington.gerenciadorDeManobras.excecao;

/**
 *
 * @author Wellington
 */
public class CampoObrigatorioException extends GerenciadorException{
    public CampoObrigatorioException(String mensagen){
         super("Favor informar o(s) campo(s) obrigatório(s): "+mensagen);
    }    
}
