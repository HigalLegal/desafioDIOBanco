package entities.exception;

public class MenorDeIdadeException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public MenorDeIdadeException(String mensagem) {
		super(mensagem);
	}

}
