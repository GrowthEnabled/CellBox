package cellbox.model.arena.util;

import cellbox.model.element.Movable;
import cellbox.model.element.SimpleCell;
import com.sun.javaws.util.JavawsDialogListener;

import javax.tools.*;
import java.io.*;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Iterator;
import java.util.concurrent.Callable;

/**
 * Created by luca on 19.09.17.
 */
public class Loader {

    private static final File CLASSES_DIR = new File("src/main/java/cellbox/model/element");
    private static final String CELL_PACKAGE = "package cellbox.model.element;";

    public Loader() {

    }

    public Class<? extends Movable> load(File file) throws IOException, ClassNotFoundException {

        //Move class to element dir.
        FileReader reader = new FileReader(file);
        BufferedReader reader1 = new BufferedReader(reader);

        //Make new file in target dir
        File newFile = new File(CLASSES_DIR.toString().concat("/" + file.getName()));
        newFile.createNewFile();

        //Write code to file
        PrintWriter writer = new PrintWriter(newFile);
        Iterator iterator = reader1.lines().iterator();
        writer.println("package cellbox.model.element;");
        while(iterator.hasNext()) {
            writer.println(iterator.next());
        }
        writer.close();

        //Compile new java file
        DiagnosticCollector<JavaFileObject> diagnostics = new DiagnosticCollector<JavaFileObject>();
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        StandardJavaFileManager fileManager = compiler.getStandardFileManager(diagnostics, null, null);
        Iterable<? extends JavaFileObject> compilationUnit = fileManager.getJavaFileObjects(newFile);

        JavaCompiler.CompilationTask cTask = compiler.getTask(
                null,
                fileManager,
                diagnostics,
                null,
                null,
                compilationUnit);

        if (cTask.call()) {
            URLClassLoader classLoader = new URLClassLoader(new URL[]{new File("./").toURI().toURL()});
            System.out.println(newFile.toString());
            return (Class<? extends Movable>) classLoader.loadClass("cellbox.model.element.SimpleCell");
        } else {
            System.out.println("Error occurred while compiling class");
        }

        return null;
    }

    public void generateCellTemplate(File saveTo) throws FileNotFoundException {
        PrintWriter fileWriter = new PrintWriter(saveTo);
        String className = saveTo.getName().substring(0, saveTo.getName().indexOf("."));
        fileWriter.println(template(className));
        fileWriter.close();
    }

    private String template(String className) {
        return CELL_PACKAGE + "\n\n" +
                "public class " + className + " extends Movable {\n\n" +
                "    public " + className + "() {\n" +
                "        \n" +
                "    }\n\n" +
                "    //This method gets invoked every time the world timer ticks.\n" +
                "    public void tick() {\n" +
                "       //ToDo: Implement cell behaviour\n" +
                "    }\n\n" +
                "}";
    }

}
