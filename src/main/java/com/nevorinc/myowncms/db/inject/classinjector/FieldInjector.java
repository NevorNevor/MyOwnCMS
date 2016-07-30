package com.nevorinc.myowncms.db.inject.classinjector;

import java.util.List;
import java.util.Set;
import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtField;
import javassist.NotFoundException;
import javassist.bytecode.AnnotationsAttribute;
import javassist.bytecode.ClassFile;
import javassist.bytecode.ConstPool;
import javassist.bytecode.annotation.Annotation;
import javassist.bytecode.annotation.StringMemberValue;

public abstract class FieldInjector {

    /**
     * Method have to return full Class name
     *
     * example: "com.nevorinc.myowncms.db.model.UserDetails"
     *
     * @return full Class name
     */
    protected abstract String getClassString();

    /**
     * Add field fieldName to getClassString() class
     *
     * injectField(String.class, "name", "user_name"); result:
     *
     * @Column(name = "user_name") public String name;
     *
     * @param fieldType type of appending field
     * @param fieldName name of appending field
     * @param column_name @Column(name = "?") of appending field
     * @throws Exception
     */
    public final Class injectField(Class fieldType, String fieldName) {
        Accesses access = Accesses.PUBLIC;
        String columnName = createColumnName(fieldName);
        CtClass injectableClass = null;
        try {
            injectableClass = ClassPool.getDefault().get(getClassString());
            CtField field = CtField.make(createFieldString(access, fieldType, fieldName), injectableClass);
            injectableClass.addField(addAnnotation(injectableClass, field, columnName));
            return injectableClass.toClass();
        } catch (NotFoundException notFoundException) {
            throw new RuntimeException("Class not found");
        } catch (CannotCompileException cannotCompileException) {
            throw new RuntimeException("Compile exception");
        }       
    }

    public final Class injectFields(Set<FieldProperties> fieldsProperties) {
        Accesses access = Accesses.PUBLIC;
        CtClass injectableClass = null;
        try {
            injectableClass = ClassPool.getDefault().get(getClassString());
            for (FieldProperties properties : fieldsProperties) {
                String columnName = createColumnName(properties.getFieldName());
                CtField field = CtField.make(createFieldString(access, properties.getFieldType(), properties.getFieldName()), injectableClass);
                injectableClass.addField(addAnnotation(injectableClass, field, columnName));
            }
            return injectableClass.toClass();
        } catch (NotFoundException notFoundException) {
            throw new RuntimeException("Class not found");
        } catch (CannotCompileException cannotCompileException) {
            throw new RuntimeException("Compile exception");
        }        
    }

    private String createFieldString(Accesses access, Class fieldType, String fieldName) {
        return access + " " + fieldType.getName() + " " + fieldName + ";";
    }

    private CtField addAnnotation(CtClass injectableClass, CtField field, String column_name) {
        ConstPool constPool = getConstPool(injectableClass);
        field.getFieldInfo().addAttribute(getColumnedAttribute(constPool, column_name));
        return field;
    }

    private AnnotationsAttribute getColumnedAttribute(ConstPool constPool, String column_name) {
        AnnotationsAttribute attribute = new AnnotationsAttribute(constPool, AnnotationsAttribute.visibleTag);
        Annotation annotation = new Annotation("javax.persistence.Column", constPool);
        annotation.addMemberValue("name", new StringMemberValue(column_name, constPool));
        attribute.addAnnotation(annotation);
        return attribute;
    }

    private ConstPool getConstPool(CtClass injectableClass) {
        ClassFile ccFile = injectableClass.getClassFile();
        return ccFile.getConstPool();
    }

    private String createColumnName(String fieldName) {
        String regex = "([a-z])([A-Z]+)";
        String replacement = "$1_$2";
        return fieldName.replaceAll(regex, replacement).toLowerCase();
    }
}
