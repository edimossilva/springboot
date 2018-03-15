package ola;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Word implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String text, traduction;
	private int number;
	private static final long serialVersionUID = 879316392947858277L;

	protected Word() {
	}

	public Word(String text, String traduction, int number) {
		super();
		this.text = text;
		this.traduction = traduction;
		this.number = number;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getTraduction() {
		return traduction;
	}

	public void setTraduction(String traduction) {
		this.traduction = traduction;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public void update(Word word) {
		setText(word.getText());
		setTraduction(word.getTraduction());
		setNumber(word.getNumber());
	}

}
