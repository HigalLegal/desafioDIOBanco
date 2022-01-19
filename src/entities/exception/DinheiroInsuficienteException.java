package entities.exception;

public class DinheiroInsuficienteException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public DinheiroInsuficienteException(String mensagem) {
		super(mensagem);
	}

}
