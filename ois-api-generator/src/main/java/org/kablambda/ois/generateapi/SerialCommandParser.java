package org.kablambda.ois.generateapi;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

public class SerialCommandParser {
    SerialCommands parse(BufferedReader text) {
        SerialCommands serialCommands = new SerialCommands();
        serialCommands.setVersion(parseVersion(text));
        readNumericalCommands(serialCommands, text);
        readBooleanFunctions(serialCommands, text);
        readShipCommands(serialCommands, text);
        return serialCommands;
    }

    private void readShipCommands(SerialCommands serialCommands, BufferedReader text) {
        String s = nextLine(text);
        while (s != null) {
            serialCommands.getShipCommands().add(
                    new ShipCommand(
                            extract("^COMMAND:\\s+(\\S.*\\S)\\s*$", s)
                    )
            );
            s = nextLine(text);
        }

    }

    private void readBooleanFunctions(SerialCommands serialCommands, BufferedReader text) {
        String s = nextLine(text);
        while (!s.equals("Ship commands:")) {
            String description = nextLine(text);
            serialCommands.getBooleanFunctions().add(
                    new BooleanFunction(
                            extract("^FUNCTION:\\s+(\\S.*\\S)\\s*$", s),
                            extract("^DESCRIPTION:\\s+(\\S.*\\S)\\s*$", description)
                    )
            );
            s = nextLine(text);
        }
    }

    private void readNumericalCommands(SerialCommands serialCommands, BufferedReader text) {
        match("Numerical commands:", nextLine(text));
        String s = nextLine(text);
        while (!s.equals("Boolean check functions:")) {
            String description = nextLine(text);
            serialCommands.getNumericalCommands().add(
                    new NumericalCommand(
                            extract("^COMMAND:\\s+(\\S.*\\S)\\s*$", s),
                            extract("^DESCRIPTION:\\s+(\\S.*\\S)\\s*$", description)
                    )
            );
            s = nextLine(text);
        }
    }

    private void match(String pattern, String text) {
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(text);
        if (!m.matches()) {
            throw new RuntimeException("Failed to match '" + text + "' against '" + pattern + "'");
        }
    }

    private String parseVersion(BufferedReader text) {
        return extract("^SERIAL OUTPUT COMMAND LIST -\\s+(\\S+)\\s*$", nextLine(text));
    }

    private String extract(String pattern, String text) {
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(text);
        if (!m.matches()) {
            throw new RuntimeException("Failed to match '" + text + "' against '" + pattern + "'");
        }
        return m.group(1);
    }

    private String nextLine(BufferedReader text) {
        try {
            String s;
            do {
                s = text.readLine();
            } while (s != null && StringUtils.isBlank(s));
            return s;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
