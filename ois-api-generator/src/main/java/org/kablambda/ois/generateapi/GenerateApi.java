package org.kablambda.ois.generateapi;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Function;
import java.util.stream.Stream;

import org.jboss.forge.roaster.Roaster;
import org.jboss.forge.roaster.model.source.JavaEnumSource;
import org.jboss.forge.roaster.model.source.JavaInterfaceSource;
import org.jboss.forge.roaster.model.source.JavaSource;

public class GenerateApi {
    private static final File API_SRC = new File("/Users/tdavies/dev/other/oisproject/ois-api/src/main/java");
    private static final String API_PKG = "org.kablambda.ois.api";

    public static void main(String... args) {
        SerialCommands serialCommands =
                new SerialCommandParser()
                        .parse(
                                new BufferedReader(
                                        new InputStreamReader(
                                                GenerateApi.class.getResourceAsStream("/serial_commands.txt")
                                        )
                                )
                        );
        createEnumWithDescription(
                "NumericalCommand",
                serialCommands.getNumericalCommands().stream(),
                NumericalCommand::getName,
                NumericalCommand::getDescription
        );

        createEnumWithDescription(
                "BooleanFunction",
                serialCommands.getBooleanFunctions().stream(),
                BooleanFunction::getName,
                BooleanFunction::getDescription
        );

        createShipCommandEnum(serialCommands);

        JavaInterfaceSource apiVersion = Roaster.create(JavaInterfaceSource.class);
        apiVersion.setPackage(API_PKG);
        apiVersion.setName("ApiVersion");
        apiVersion.addField("String VERSION = \"" + serialCommands.getVersion() + "\"");
        writeJava(apiVersion);
    }

    private static void createShipCommandEnum(SerialCommands serialCommands) {
        JavaEnumSource enumSource = createJavaEnumSource("ShipCommand");
        serialCommands.getShipCommands().forEach(c -> enumSource.addEnumConstant().setName(c.getName()));
        writeJava(enumSource);
    }

    private static JavaEnumSource createJavaEnumSource(String name) {
        JavaEnumSource enumSource = Roaster.create(JavaEnumSource.class);
        enumSource.setPackage(API_PKG);
        enumSource.setName(name);
        return enumSource;
    }

    private static <T> void createEnumWithDescription(
            String enumName,
            Stream<T> values,
            Function<T, String> nameFn,
            Function<T, String> descriptionFn
    ) {
        JavaEnumSource enumSource = createJavaEnumSource(enumName);
        enumSource.addField().setFinal(true).setPrivate().setName("description").setType(String.class);
        enumSource.addMethod()
                  .setConstructor(true)
                  .setBody("this.description = description;")
                  .addParameter(String.class, "description");
        enumSource.addMethod()
                  .setReturnType(String.class)
                  .setName("getDescription")
                  .setPublic()
                  .setBody("return description;");
        values.forEach(
                c -> enumSource.addEnumConstant()
                               .setName(nameFn.apply(c))
                               .setConstructorArguments("\"" + descriptionFn.apply(c) + "\""));

        writeJava(enumSource);
    }

    private static void writeJava(JavaSource javaClass) {
        String packageName = javaClass.getPackage();
        String className = javaClass.getName();
        File classFile = new File(
                API_SRC,
                packageName.replaceAll("\\.", File.separator) + File.separator + className + ".java"
        );
        if (!classFile.getParentFile().exists() && !classFile.getParentFile().mkdirs()) {
            throw new RuntimeException("Failed to create directories for " + classFile.toString());
        }
        try (FileWriter writer = new FileWriter(classFile)) {
            writer.write(javaClass.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
