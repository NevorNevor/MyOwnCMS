package com.nevorinc.myowncms.db.inject;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtField;
import javassist.bytecode.AnnotationsAttribute;
import javassist.bytecode.ClassFile;
import javassist.bytecode.ConstPool;
import javassist.bytecode.annotation.Annotation;
import javassist.bytecode.annotation.StringMemberValue;

/**
 *
 * @author SpyPC
 */
public abstract class FieldInjector<T> {

    Class T;

    /**
     * Add field fieldName to T class
     * 
     * injectField(Accesses.PUBLIC, String.class, "name", "user_name");
     * result: 
     * 
     * @Column(name = "user_name")
     * public String name;
     * 
     * @param access field access (PUBLIC, PRIVATE, PROTECTED, DEFAULT)
     * @param fieldType type of appending field
     * @param fieldName name of appending field
     * @param column_name @Column(name = "?") of appending field
     * @throws Exception 
     */
    public void injectField(Accesses access, Class fieldType, String fieldName, String column_name) throws Exception {
        CtClass injectableClass = ClassPool.getDefault().get(T.getName());
        CtField field = CtField.make(createFieldString(access, fieldType, fieldName), injectableClass);       
        injectableClass.addField(addAnnotation(injectableClass, field, column_name));
    }

    private String createFieldString(Accesses access, Class fieldType, String fieldName) {
        return access + " " + fieldType.getName() + " " + fieldName + ";";
    }
    
    private CtField addAnnotation(CtClass injectableClass ,CtField field, String column_name){
        ConstPool constPool = getConstPool(injectableClass);
        Annotation annotation = new Annotation("Column", constPool);
        annotation.addMemberValue("name", new StringMemberValue(column_name, constPool));
        AnnotationsAttribute attribute = new AnnotationsAttribute(constPool, AnnotationsAttribute.visibleTag);
        attribute.addAnnotation(annotation);
        field.getFieldInfo().addAttribute(attribute);
        return field;
    }
    
    private ConstPool getConstPool(CtClass injectableClass){
        ClassFile ccFile = injectableClass.getClassFile();
        return ccFile.getConstPool();
    }
}
