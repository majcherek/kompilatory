package pl.edu.agh.elements;
import java.util.ArrayList;
import java.util.List;


public class Field{
	
	private String type;
	private String name;
	private List<String> modifiers;
	
	public Field(){
		this.modifiers = new ArrayList<String>();
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<String> getModifiers() {
		return modifiers;
	}
	public void setModifiers(List<String> modifiers) {
		this.modifiers = modifiers;
	}
	
	public void addModifier(String modifier){
		modifiers.add(modifier);
	}
	
	
	
	
	

}
