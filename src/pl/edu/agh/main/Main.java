package pl.edu.agh.main;
import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;

import pl.edu.agh.antlr.JavaBaseListener;
import pl.edu.agh.antlr.JavaLexer;
import pl.edu.agh.antlr.JavaParser;
import pl.edu.agh.elements.Class;
import pl.edu.agh.elements.Field;
import pl.edu.agh.elements.Method;


public class Main
{
  public static void main(String[] args) throws Exception
  {
	  List<Class> classes = new ArrayList<Class>();
	  
	  for(String filename : args){
		  
		  	Class c = new Class(); 
		  	classes.add(c);
		    JavaLexer lexer = new JavaLexer(new ANTLRFileStream(filename));
		    CommonTokenStream tokens = new CommonTokenStream(lexer);
		    JavaParser p = new JavaParser(tokens);
		    p.setBuildParseTree(true);
		    p.addParseListener(new JavaBaseListener(c));
		    ParserRuleContext t = p.compilationUnit();
		    
		   
		    System.out.println(c.getModifier()+" class "+c.getName());
		    
		    System.out.println("extends "+c.getParentClass());
		    System.out.print("implements ");
		    for(String interfaceName : c.getInterfaces()){
		    	System.out.print(interfaceName +", ");
		    }
		    System.out.println();
		    
		    List<Field> fields = c.getFields();
		    System.out.println("Fields:");
		    for(Field field : fields){
		    	System.out.print("\t");
		    	for(String modifier : field.getModifiers()){
		    		System.out.print(modifier +" ");
		    	}
		    	System.out.println(field.getType() +" "+ field.getName());
		    	
		    }
		    
		    List<Method> methods = c.getMethods();
		    System.out.println("Methods:");
		    for(Method method : methods){
		    	System.out.print("\t");
		    	for(String modifier : method.getModifiers()){
		    		System.out.print(modifier +" ");
		    	}
		    	System.out.println(method.getReturnType() +" "+ method.getName());
		    }
		    
		    System.out.println();
	  }
	  
	  GraphGenerator gen = new GraphGenerator("supergraf.png");
	  try {
		  gen.generate(classes);
	  } catch (GraphException e)
	  {
		  System.out.println("Bład generowania grafu");
		  e.printStackTrace();
	  }
	  

  }
}