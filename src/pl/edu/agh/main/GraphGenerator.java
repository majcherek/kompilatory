package pl.edu.agh.main;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import net.sourceforge.plantuml.SourceStringReader;
import pl.edu.agh.elements.Class;
import pl.edu.agh.elements.Field;
import pl.edu.agh.elements.Method;

public class GraphGenerator {

	private String source;
	private StringBuilder sourceB;
	private String fileName;
	private OutputStream png = null;

	public GraphGenerator(String fileName) {
		sourceB = new StringBuilder("@startuml\n");
		this.fileName = fileName;
	}

	public void generate(List<Class> list) throws GraphException {
		// set up output
		try {
			png = new FileOutputStream(fileName);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// generate graph code
		for (Class c : list) {
			// extends
			sourceB.append(c.getParentClass() + "<|--" + c.getName() + "\n");
			// implements
			for (String interf : c.getInterfaces()) {
				sourceB.append("Interface "+interf);
				sourceB.append("<|.." + c.getName() + "\n");
			}
			// fields
			for (Field f : c.getFields()) {
				sourceB.append(c.getName() + ": " + f.getType() + " " + f.getName()
						+ "\n");
			}
			// methods
			for (Method m : c.getMethods()) {
				sourceB.append(c.getName() + ": " + m.getReturnType() + " "
						+ m.getName() + "()\n");

			}
		}
		sourceB.append("@enduml\n");
		source = sourceB.toString();
		String desc = null;
		SourceStringReader reader = new SourceStringReader(source);
		try {
			desc = reader.generateImage(png);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(source);
		if (desc == null)
			throw new GraphException();

	}
}
