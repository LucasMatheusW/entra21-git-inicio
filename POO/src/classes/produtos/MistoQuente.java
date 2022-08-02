package classes.produtos;

public class MistoQuente extends Complementable {
    
    public MistoQuente() {
        this.adicionarIngrediente("Queijunto");
        this.adicionarIngrediente("Preijo");
        this.adicionarIngrediente("Pão");
        this.setTipo(ETipoProduto.MISTOQUENTE);
    }
}
