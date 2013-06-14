package pl.edu.agh.antlr;
// Generated from Java.g by ANTLR 4.0


import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.antlr.v4.runtime.tree.ErrorNode;

import pl.edu.agh.elements.Class;
import pl.edu.agh.elements.Field;
import pl.edu.agh.elements.Method;

import pl.edu.agh.antlr.JavaParser.*;


public class JavaBaseListener implements JavaListener {
	
	private Class c;
	private Field field;
	private Method method;
	private String type;
	private List<String> modifiers = new ArrayList<String>();
	
	public JavaBaseListener(Class c){
		this.c=c;
	}
	
	@Override public void enterInnerCreator(JavaParser.InnerCreatorContext ctx) { }
	@Override public void exitInnerCreator(JavaParser.InnerCreatorContext ctx) {}

	@Override public void enterExpressionList(JavaParser.ExpressionListContext ctx) { }
	@Override public void exitExpressionList(JavaParser.ExpressionListContext ctx) {}

	@Override public void enterTypeDeclaration(JavaParser.TypeDeclarationContext ctx) { 		
	}
	@Override public void exitTypeDeclaration(JavaParser.TypeDeclarationContext ctx) {
	
	}

	@Override public void enterForUpdate(JavaParser.ForUpdateContext ctx) { }
	@Override public void exitForUpdate(JavaParser.ForUpdateContext ctx) {
		
	}

	@Override public void enterAnnotation(JavaParser.AnnotationContext ctx) { }
	@Override public void exitAnnotation(JavaParser.AnnotationContext ctx) {
		
	}

	@Override public void enterEnumConstant(JavaParser.EnumConstantContext ctx) { }
	@Override public void exitEnumConstant(JavaParser.EnumConstantContext ctx) {
		
	}

	@Override public void enterSwitchBlockStatementGroups(JavaParser.SwitchBlockStatementGroupsContext ctx) { }
	@Override public void exitSwitchBlockStatementGroups(JavaParser.SwitchBlockStatementGroupsContext ctx) { }

	@Override public void enterNormalClassDeclaration(JavaParser.NormalClassDeclarationContext ctx) {
	
	}
	@Override public void exitNormalClassDeclaration(JavaParser.NormalClassDeclarationContext ctx) {
		
		c.setName(ctx.Identifier().toString());

		
		String declaration = ctx.getText();
		int i = declaration.indexOf(ctx.classBody().getText());
		declaration = declaration.substring(0, i);

		getParentClass(declaration);
		getInterfaces(declaration);

	}
	
	public void getParentClass(String declaration){
		if( declaration.indexOf("extends") != -1){
			String[] parts = declaration.split("extends");
			if(parts[1].indexOf("implements") != -1){
				int i = parts[1].indexOf("implements");
				c.setParentClass(parts[1].substring(0,i));
			}else{
				c.setParentClass(parts[1]);
			}
			
		}
	}
	
	public void getInterfaces(String declaration){
		if( declaration.indexOf("implements") != -1){
			String[] parts = declaration.split("implements");
			if(parts[1].indexOf("extends") != -1){
				int i = parts[1].indexOf("extends");
				String p = parts[1].substring(0, i);
				String[] interfaces = p.split(",");
				for(String interfaceName : interfaces){
					c.addInterface(interfaceName);
				}
			}else{
				String[] interfaces = parts[1].split(",");
				for(String interfaceName : interfaces){
					c.addInterface(interfaceName);
				}
			}
			
		}
	}

	@Override public void enterImportDeclaration(JavaParser.ImportDeclarationContext ctx) { }
	@Override public void exitImportDeclaration(JavaParser.ImportDeclarationContext ctx) { }

	@Override public void enterAnnotationMethodOrConstantRest(JavaParser.AnnotationMethodOrConstantRestContext ctx) { }
	@Override public void exitAnnotationMethodOrConstantRest(JavaParser.AnnotationMethodOrConstantRestContext ctx) { 

	}

	@Override public void enterEnumConstantName(JavaParser.EnumConstantNameContext ctx) { }
	@Override public void exitEnumConstantName(JavaParser.EnumConstantNameContext ctx) { }

	@Override public void enterVariableDeclarators(JavaParser.VariableDeclaratorsContext ctx) {
	}
	@Override public void exitVariableDeclarators(JavaParser.VariableDeclaratorsContext ctx) {	}

	@Override public void enterElementValuePairs(JavaParser.ElementValuePairsContext ctx) { }
	@Override public void exitElementValuePairs(JavaParser.ElementValuePairsContext ctx) { 

	}

	@Override public void enterMethodDeclaratorRest(JavaParser.MethodDeclaratorRestContext ctx) { }
	@Override public void exitMethodDeclaratorRest(JavaParser.MethodDeclaratorRestContext ctx) {
	}

	@Override public void enterInterfaceBodyDeclaration(JavaParser.InterfaceBodyDeclarationContext ctx) {
		c.isInterface = true;
		type=null;
	}
	@Override public void exitInterfaceBodyDeclaration(JavaParser.InterfaceBodyDeclarationContext ctx) { 
	}

	@Override public void enterEnumConstants(JavaParser.EnumConstantsContext ctx) { }
	@Override public void exitEnumConstants(JavaParser.EnumConstantsContext ctx) { }

	@Override public void enterCatchClause(JavaParser.CatchClauseContext ctx) { }
	@Override public void exitCatchClause(JavaParser.CatchClauseContext ctx) { }

	@Override public void enterConstantExpression(JavaParser.ConstantExpressionContext ctx) { }
	@Override public void exitConstantExpression(JavaParser.ConstantExpressionContext ctx) { }

	@Override public void enterEnumBody(JavaParser.EnumBodyContext ctx) { }
	@Override public void exitEnumBody(JavaParser.EnumBodyContext ctx) { }

	@Override public void enterEnumDeclaration(JavaParser.EnumDeclarationContext ctx) { }
	@Override public void exitEnumDeclaration(JavaParser.EnumDeclarationContext ctx) { }

	@Override public void enterTypeParameter(JavaParser.TypeParameterContext ctx) { }
	@Override public void exitTypeParameter(JavaParser.TypeParameterContext ctx) { 

	}

	@Override public void enterExplicitConstructorInvocation(JavaParser.ExplicitConstructorInvocationContext ctx) { }
	@Override public void exitExplicitConstructorInvocation(JavaParser.ExplicitConstructorInvocationContext ctx) {
	}

	@Override public void enterEnumBodyDeclarations(JavaParser.EnumBodyDeclarationsContext ctx) { }
	@Override public void exitEnumBodyDeclarations(JavaParser.EnumBodyDeclarationsContext ctx) { }

	@Override public void enterInterfaceMethodDeclaratorRest(JavaParser.InterfaceMethodDeclaratorRestContext ctx) { }
	@Override public void exitInterfaceMethodDeclaratorRest(JavaParser.InterfaceMethodDeclaratorRestContext ctx) {
	}

	@Override public void enterTypeBound(JavaParser.TypeBoundContext ctx) { }
	@Override public void exitTypeBound(JavaParser.TypeBoundContext ctx) { 
	}

	@Override public void enterStatementExpression(JavaParser.StatementExpressionContext ctx) { }
	@Override public void exitStatementExpression(JavaParser.StatementExpressionContext ctx) { 
	}

	@Override public void enterVariableInitializer(JavaParser.VariableInitializerContext ctx) { }
	@Override public void exitVariableInitializer(JavaParser.VariableInitializerContext ctx) {
	}

	@Override public void enterBlock(JavaParser.BlockContext ctx) { }
	@Override public void exitBlock(JavaParser.BlockContext ctx) { 
	}

	@Override public void enterConstantDeclaratorsRest(JavaParser.ConstantDeclaratorsRestContext ctx) { }
	@Override public void exitConstantDeclaratorsRest(JavaParser.ConstantDeclaratorsRestContext ctx) { }

	@Override public void enterInterfaceMethodOrFieldDecl(JavaParser.InterfaceMethodOrFieldDeclContext ctx) { }
	@Override public void exitInterfaceMethodOrFieldDecl(JavaParser.InterfaceMethodOrFieldDeclContext ctx) {	
	}

	@Override public void enterLocalVariableDeclarationStatement(JavaParser.LocalVariableDeclarationStatementContext ctx) { }
	@Override public void exitLocalVariableDeclarationStatement(JavaParser.LocalVariableDeclarationStatementContext ctx) { }

	@Override public void enterFieldDeclaration(JavaParser.FieldDeclarationContext ctx) {
	}
	@Override public void exitFieldDeclaration(JavaParser.FieldDeclarationContext ctx) {
		
		field.setName(ctx.getText());
		c.addField(field);
		modifiers = new ArrayList<String>();
		
	}

	@Override public void enterNormalInterfaceDeclaration(JavaParser.NormalInterfaceDeclarationContext ctx) { }
	@Override public void exitNormalInterfaceDeclaration(JavaParser.NormalInterfaceDeclarationContext ctx) { 
		c.setName(ctx.Identifier().toString());

		
		String declaration = ctx.getText();

		int i = declaration.indexOf(ctx.interfaceBody().getText());
		declaration = declaration.substring(0, i);

		getParentClass(declaration);
	}

	@Override public void enterModifiers(JavaParser.ModifiersContext ctx) {
		field = new Field();
		method = new Method();
	}
	@Override public void exitModifiers(JavaParser.ModifiersContext ctx) { 
		
		
	}

	@Override public void enterExplicitGenericInvocation(JavaParser.ExplicitGenericInvocationContext ctx) { }
	@Override public void exitExplicitGenericInvocation(JavaParser.ExplicitGenericInvocationContext ctx) { }

	@Override public void enterParExpression(JavaParser.ParExpressionContext ctx) { }
	@Override public void exitParExpression(JavaParser.ParExpressionContext ctx) { }

	@Override public void enterCatches(JavaParser.CatchesContext ctx) { }
	@Override public void exitCatches(JavaParser.CatchesContext ctx) {	}

	@Override public void enterSwitchLabel(JavaParser.SwitchLabelContext ctx) { }
	@Override public void exitSwitchLabel(JavaParser.SwitchLabelContext ctx) { }

	@Override public void enterTypeParameters(JavaParser.TypeParametersContext ctx) { }
	@Override public void exitTypeParameters(JavaParser.TypeParametersContext ctx) { }

	@Override public void enterQualifiedName(JavaParser.QualifiedNameContext ctx) { }
	@Override public void exitQualifiedName(JavaParser.QualifiedNameContext ctx) {
	}

	@Override public void enterClassDeclaration(JavaParser.ClassDeclarationContext ctx) { }
	@Override public void exitClassDeclaration(JavaParser.ClassDeclarationContext ctx) {}

	@Override public void enterGenericMethodOrConstructorDecl(JavaParser.GenericMethodOrConstructorDeclContext ctx) { }
	@Override public void exitGenericMethodOrConstructorDecl(JavaParser.GenericMethodOrConstructorDeclContext ctx) { }

	@Override public void enterBooleanLiteral(JavaParser.BooleanLiteralContext ctx) { }
	@Override public void exitBooleanLiteral(JavaParser.BooleanLiteralContext ctx) { }

	@Override public void enterAnnotationConstantRest(JavaParser.AnnotationConstantRestContext ctx) { }
	@Override public void exitAnnotationConstantRest(JavaParser.AnnotationConstantRestContext ctx) { }

	@Override public void enterTypeName(JavaParser.TypeNameContext ctx) { }
	@Override public void exitTypeName(JavaParser.TypeNameContext ctx) {

	}

	@Override public void enterArguments(JavaParser.ArgumentsContext ctx) { }
	@Override public void exitArguments(JavaParser.ArgumentsContext ctx) { 
	}

	@Override public void enterConstructorBody(JavaParser.ConstructorBodyContext ctx) { }
	@Override public void exitConstructorBody(JavaParser.ConstructorBodyContext ctx) { }

	@Override public void enterFormalParameters(JavaParser.FormalParametersContext ctx) { }
	@Override public void exitFormalParameters(JavaParser.FormalParametersContext ctx) {
	}

	@Override public void enterTypeArgument(JavaParser.TypeArgumentContext ctx) { }
	@Override public void exitTypeArgument(JavaParser.TypeArgumentContext ctx) { 
	}

	@Override public void enterForInit(JavaParser.ForInitContext ctx) { }
	@Override public void exitForInit(JavaParser.ForInitContext ctx) {
	}

	@Override public void enterConstructorDeclaratorRest(JavaParser.ConstructorDeclaratorRestContext ctx) { }
	@Override public void exitConstructorDeclaratorRest(JavaParser.ConstructorDeclaratorRestContext ctx) { }

	@Override public void enterAnnotations(JavaParser.AnnotationsContext ctx) { }
	@Override public void exitAnnotations(JavaParser.AnnotationsContext ctx) { }

	@Override public void enterExpression(JavaParser.ExpressionContext ctx) { }
	@Override public void exitExpression(JavaParser.ExpressionContext ctx) {}

	@Override public void enterVariableDeclarator(JavaParser.VariableDeclaratorContext ctx) { }
	@Override public void exitVariableDeclarator(JavaParser.VariableDeclaratorContext ctx) {}

	@Override public void enterAnnotationTypeDeclaration(JavaParser.AnnotationTypeDeclarationContext ctx) { }
	@Override public void exitAnnotationTypeDeclaration(JavaParser.AnnotationTypeDeclarationContext ctx) { }

	@Override public void enterFormalParameter(JavaParser.FormalParameterContext ctx) { }
	@Override public void exitFormalParameter(JavaParser.FormalParameterContext ctx) {
	}

	@Override public void enterType(JavaParser.TypeContext ctx) { }
	@Override public void exitType(JavaParser.TypeContext ctx) {
		if(field != null && field.getType() == null){
			field.setType(ctx.getText());
		}
		if(method != null && method.getReturnType() == null){
			method.setReturnType(ctx.getText());
		}
		if(type== null){
			type = ctx.getText();
		}

		
	}

	@Override public void enterMemberDecl(JavaParser.MemberDeclContext ctx) { }
	@Override public void exitMemberDecl(JavaParser.MemberDeclContext ctx) {
	}

	@Override public void enterElementValueArrayInitializer(JavaParser.ElementValueArrayInitializerContext ctx) { }
	@Override public void exitElementValueArrayInitializer(JavaParser.ElementValueArrayInitializerContext ctx) { }

	@Override public void enterAnnotationName(JavaParser.AnnotationNameContext ctx) { }
	@Override public void exitAnnotationName(JavaParser.AnnotationNameContext ctx) { }

	@Override public void enterEnhancedForControl(JavaParser.EnhancedForControlContext ctx) { }
	@Override public void exitEnhancedForControl(JavaParser.EnhancedForControlContext ctx) {
	}

	@Override public void enterFormalParameterDeclsRest(JavaParser.FormalParameterDeclsRestContext ctx) { }
	@Override public void exitFormalParameterDeclsRest(JavaParser.FormalParameterDeclsRestContext ctx) {
	}

	@Override public void enterAnnotationMethodRest(JavaParser.AnnotationMethodRestContext ctx) { }
	@Override public void exitAnnotationMethodRest(JavaParser.AnnotationMethodRestContext ctx) { 
	}

	@Override public void enterPrimary(JavaParser.PrimaryContext ctx) { }
	@Override public void exitPrimary(JavaParser.PrimaryContext ctx) {}

	@Override public void enterClassBody(JavaParser.ClassBodyContext ctx) { }
	@Override public void exitClassBody(JavaParser.ClassBodyContext ctx) { 
		//System.out.println("class body" + ctx.getText());
		String body = ctx.getText();
		if( body.indexOf("void") != -1){
			String[] parts = body.split("void");
			for(int i=0; i< parts.length-1; i++){
				if(parts[i+1].indexOf("(") != -1){
					int j = parts[i+1].indexOf("(");
					Method method = new Method();
					method.setName(parts[1].substring(0,j));
					method.setReturnType("void");
					method.setModifier(modifiers);
					modifiers = new ArrayList<String>();
					c.addMethod(method);
				}
			}

			
		}
	}

	@Override public void enterClassOrInterfaceModifier(JavaParser.ClassOrInterfaceModifierContext ctx) { }
	@Override public void exitClassOrInterfaceModifier(JavaParser.ClassOrInterfaceModifierContext ctx) {
		c.setModifier(ctx.getText());
	}

	@Override public void enterDefaultValue(JavaParser.DefaultValueContext ctx) { }
	@Override public void exitDefaultValue(JavaParser.DefaultValueContext ctx) {
	}

	@Override public void enterVariableModifier(JavaParser.VariableModifierContext ctx) { }
	@Override public void exitVariableModifier(JavaParser.VariableModifierContext ctx) {
	}

	@Override public void enterCreatedName(JavaParser.CreatedNameContext ctx) { }
	@Override public void exitCreatedName(JavaParser.CreatedNameContext ctx) {
	}

	@Override public void enterInterfaceDeclaration(JavaParser.InterfaceDeclarationContext ctx) { }
	@Override public void exitInterfaceDeclaration(JavaParser.InterfaceDeclarationContext ctx) { }

	@Override public void enterPackageDeclaration(JavaParser.PackageDeclarationContext ctx) { }
	@Override public void exitPackageDeclaration(JavaParser.PackageDeclarationContext ctx) { }

	@Override public void enterConstantDeclaratorRest(JavaParser.ConstantDeclaratorRestContext ctx) { }
	@Override public void exitConstantDeclaratorRest(JavaParser.ConstantDeclaratorRestContext ctx) { }

	@Override public void enterConstantDeclarator(JavaParser.ConstantDeclaratorContext ctx) { }
	@Override public void exitConstantDeclarator(JavaParser.ConstantDeclaratorContext ctx) { }

	@Override public void enterTypeArguments(JavaParser.TypeArgumentsContext ctx) { }
	@Override public void exitTypeArguments(JavaParser.TypeArgumentsContext ctx) {
	}

	@Override public void enterClassCreatorRest(JavaParser.ClassCreatorRestContext ctx) { }
	@Override public void exitClassCreatorRest(JavaParser.ClassCreatorRestContext ctx) { }

	@Override public void enterModifier(JavaParser.ModifierContext ctx) { }
	@Override public void exitModifier(JavaParser.ModifierContext ctx) {
		if(field != null){
			field.addModifier(ctx.getText());
		}
		if(method != null){
			method.addModifier(ctx.getText());
		}if(modifiers != null){
			modifiers.add(ctx.getText());
		}
		
	}

	@Override public void enterStatement(JavaParser.StatementContext ctx) { }
	@Override public void exitStatement(JavaParser.StatementContext ctx) { 
	}

	@Override public void enterInterfaceBody(JavaParser.InterfaceBodyContext ctx) { }
	@Override public void exitInterfaceBody(JavaParser.InterfaceBodyContext ctx) { }

	@Override public void enterClassBodyDeclaration(JavaParser.ClassBodyDeclarationContext ctx) { }
	@Override public void exitClassBodyDeclaration(JavaParser.ClassBodyDeclarationContext ctx) { }

	@Override public void enterPackageOrTypeName(JavaParser.PackageOrTypeNameContext ctx) { }
	@Override public void exitPackageOrTypeName(JavaParser.PackageOrTypeNameContext ctx) { }

	@Override public void enterForControl(JavaParser.ForControlContext ctx) { }
	@Override public void exitForControl(JavaParser.ForControlContext ctx) {
	}

	@Override public void enterClassOrInterfaceModifiers(JavaParser.ClassOrInterfaceModifiersContext ctx) { }
	@Override public void exitClassOrInterfaceModifiers(JavaParser.ClassOrInterfaceModifiersContext ctx) { }

	@Override public void enterTypeList(JavaParser.TypeListContext ctx) { }
	@Override public void exitTypeList(JavaParser.TypeListContext ctx) { 
	}

	@Override public void enterLocalVariableDeclaration(JavaParser.LocalVariableDeclarationContext ctx) { }
	@Override public void exitLocalVariableDeclaration(JavaParser.LocalVariableDeclarationContext ctx) {
	}

	@Override public void enterVariableDeclaratorId(JavaParser.VariableDeclaratorIdContext ctx) { }
	@Override public void exitVariableDeclaratorId(JavaParser.VariableDeclaratorIdContext ctx) { }

	@Override public void enterCompilationUnit(JavaParser.CompilationUnitContext ctx) { }
	@Override public void exitCompilationUnit(JavaParser.CompilationUnitContext ctx) {

	}

	@Override public void enterElementValue(JavaParser.ElementValueContext ctx) { }
	@Override public void exitElementValue(JavaParser.ElementValueContext ctx) {

	}

	@Override public void enterClassOrInterfaceType(JavaParser.ClassOrInterfaceTypeContext ctx) { }
	@Override public void exitClassOrInterfaceType(JavaParser.ClassOrInterfaceTypeContext ctx) {
	}

	@Override public void enterAnnotationTypeElementDeclaration(JavaParser.AnnotationTypeElementDeclarationContext ctx) { }
	@Override public void exitAnnotationTypeElementDeclaration(JavaParser.AnnotationTypeElementDeclarationContext ctx) { }

	@Override public void enterBlockStatement(JavaParser.BlockStatementContext ctx) { }
	@Override public void exitBlockStatement(JavaParser.BlockStatementContext ctx) {

	}

	@Override public void enterAnnotationTypeBody(JavaParser.AnnotationTypeBodyContext ctx) { }
	@Override public void exitAnnotationTypeBody(JavaParser.AnnotationTypeBodyContext ctx) { }

	@Override public void enterInterfaceMemberDecl(JavaParser.InterfaceMemberDeclContext ctx) {
	}
	@Override public void exitInterfaceMemberDecl(JavaParser.InterfaceMemberDeclContext ctx) {

		String declaration = ctx.getText();
		if(declaration.indexOf("=") != -1){
			int i = declaration.indexOf("=");
			String name = declaration.substring(type.length(), i);
			//System.out.println(name);
			field = new Field();
			field.setName(name);
			field.setType(type);
			c.addField(field);	
			modifiers = new ArrayList<String>();
			type=null;
		}else{
			int i = declaration.indexOf("(");
			String name = declaration.substring(type.length(), i);
			//System.out.println(name);
			method = new Method();
			method.setName(name);
			method.setReturnType(type);
			c.addMethod(method);
			modifiers = new ArrayList<String>();
			type=null;
		}


	}

	@Override public void enterIntegerLiteral(JavaParser.IntegerLiteralContext ctx) { }
	@Override public void exitIntegerLiteral(JavaParser.IntegerLiteralContext ctx) { }

	@Override public void enterCreator(JavaParser.CreatorContext ctx) { }
	@Override public void exitCreator(JavaParser.CreatorContext ctx) { 
	}

	@Override public void enterQualifiedNameList(JavaParser.QualifiedNameListContext ctx) { }
	@Override public void exitQualifiedNameList(JavaParser.QualifiedNameListContext ctx) { 
	}

	@Override public void enterInterfaceGenericMethodDecl(JavaParser.InterfaceGenericMethodDeclContext ctx) { }
	@Override public void exitInterfaceGenericMethodDecl(JavaParser.InterfaceGenericMethodDeclContext ctx) {	}

	@Override public void enterMemberDeclaration(JavaParser.MemberDeclarationContext ctx) { }
	@Override public void exitMemberDeclaration(JavaParser.MemberDeclarationContext ctx) {
		//System.out.println("member Declaration" + ctx.getText());
	}

	@Override public void enterFormalParameterDecls(JavaParser.FormalParameterDeclsContext ctx) { }
	@Override public void exitFormalParameterDecls(JavaParser.FormalParameterDeclsContext ctx) {

	}

	@Override public void enterVoidMethodDeclaratorRest(JavaParser.VoidMethodDeclaratorRestContext ctx) { }
	@Override public void exitVoidMethodDeclaratorRest(JavaParser.VoidMethodDeclaratorRestContext ctx) {
	}

	@Override public void enterMethodDeclaration(JavaParser.MethodDeclarationContext ctx) {
	}
	@Override public void exitMethodDeclaration(JavaParser.MethodDeclarationContext ctx) {
		method.setName(ctx.Identifier().toString());
		c.addMethod(method);
		modifiers = new ArrayList<String>();
		
	}

	@Override public void enterAnnotationTypeElementRest(JavaParser.AnnotationTypeElementRestContext ctx) { }
	@Override public void exitAnnotationTypeElementRest(JavaParser.AnnotationTypeElementRestContext ctx) { }

	@Override public void enterVoidInterfaceMethodDeclaratorRest(JavaParser.VoidInterfaceMethodDeclaratorRestContext ctx) { }
	@Override public void exitVoidInterfaceMethodDeclaratorRest(JavaParser.VoidInterfaceMethodDeclaratorRestContext ctx) {
		type = "void";
	}

	@Override public void enterElementValuePair(JavaParser.ElementValuePairContext ctx) { }
	@Override public void exitElementValuePair(JavaParser.ElementValuePairContext ctx) { }

	@Override public void enterGenericMethodOrConstructorRest(JavaParser.GenericMethodOrConstructorRestContext ctx) { }
	@Override public void exitGenericMethodOrConstructorRest(JavaParser.GenericMethodOrConstructorRestContext ctx) {
	}

	@Override public void enterInterfaceMethodOrFieldRest(JavaParser.InterfaceMethodOrFieldRestContext ctx) { }
	@Override public void exitInterfaceMethodOrFieldRest(JavaParser.InterfaceMethodOrFieldRestContext ctx) { 
	}

	@Override public void enterMethodBody(JavaParser.MethodBodyContext ctx) { }
	@Override public void exitMethodBody(JavaParser.MethodBodyContext ctx) {
		//System.out.println("MethodBody: "+ctx.toString());
	}

	@Override public void enterArrayInitializer(JavaParser.ArrayInitializerContext ctx) { }
	@Override public void exitArrayInitializer(JavaParser.ArrayInitializerContext ctx) { }

	@Override public void enterPrimitiveType(JavaParser.PrimitiveTypeContext ctx) { }
	@Override public void exitPrimitiveType(JavaParser.PrimitiveTypeContext ctx) { }

	@Override public void enterVariableModifiers(JavaParser.VariableModifiersContext ctx) { }
	@Override public void exitVariableModifiers(JavaParser.VariableModifiersContext ctx) {
		
	}

	@Override public void enterNonWildcardTypeArguments(JavaParser.NonWildcardTypeArgumentsContext ctx) { }
	@Override public void exitNonWildcardTypeArguments(JavaParser.NonWildcardTypeArgumentsContext ctx) { }

	@Override public void enterClassOrInterfaceDeclaration(JavaParser.ClassOrInterfaceDeclarationContext ctx) { }
	@Override public void exitClassOrInterfaceDeclaration(JavaParser.ClassOrInterfaceDeclarationContext ctx) { 
	}

	@Override public void enterArrayCreatorRest(JavaParser.ArrayCreatorRestContext ctx) { }
	@Override public void exitArrayCreatorRest(JavaParser.ArrayCreatorRestContext ctx) { }

	@Override public void enterLiteral(JavaParser.LiteralContext ctx) { }
	@Override public void exitLiteral(JavaParser.LiteralContext ctx) { }

	@Override public void enterSwitchBlockStatementGroup(JavaParser.SwitchBlockStatementGroupContext ctx) { }
	@Override public void exitSwitchBlockStatementGroup(JavaParser.SwitchBlockStatementGroupContext ctx) { }

	@Override public void enterEveryRule(ParserRuleContext ctx) { }
	@Override public void exitEveryRule(ParserRuleContext ctx) { }
	@Override public void visitTerminal(TerminalNode node) { }
	@Override public void visitErrorNode(ErrorNode node) { }
}
