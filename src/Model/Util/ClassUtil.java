package Model.Util;

import Model.Entity.Questionnaire.Questionnaire;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.IOException;

public class ClassUtil {
    public static void main(String[] args) throws URISyntaxException {
        try {
            System.out.println("所有子类：");
            for (Class<?> c : getAllAssignedClass(Questionnaire.class)) {
                System.out.println(c.getName());
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取同一路径下所有子类或接口实现类
     */
    public static List<Class<?>> getAllAssignedClass(Class<?> superClass) throws IOException,
            ClassNotFoundException, URISyntaxException {
        List<Class<?>> classes = new ArrayList<Class<?>>();
        for (Class<?> c : getClasses(superClass)) {
            if (superClass.isAssignableFrom(c) && !superClass.equals(c)) {
                classes.add(c);
            }
        }
        return classes;
    }

    /**
     * 取得当前类路径下的所有类
     */
    public static List<Class<?>> getClasses(Class<?> cls) throws IOException,
            ClassNotFoundException, URISyntaxException {
        String pk = cls.getPackage().getName();
        String path = pk.replace('.', '/');
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        String resourcePath = classloader.getResource(path).toURI().getPath();

        return getClasses(new File(resourcePath), pk);
    }

    /**
     * 迭代查找
     */
    private static List<Class<?>> getClasses(File dir, String pk) throws ClassNotFoundException {
        List<Class<?>> classes = new ArrayList<Class<?>>();
        if (!dir.exists()) {
            return classes;
        }

        for (File f : dir.listFiles()) {
            if (f.isDirectory()) {
                classes.addAll(getClasses(f, pk + "." + f.getName()));
            }
            String name = f.getName();
            if (name.endsWith(".class")) {
                classes.add(Class.forName(pk + "." + name.substring(0, name.length() - 6)));
            }
        }
        return classes;
    }
}