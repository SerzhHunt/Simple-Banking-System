package banking;

import terminal.Terminal;

public class Main {
    public static void main(String[] args) {
        /*
        *Used once,
        *to create a database and table,
        *named from the command line arguments
        *
        CreateDB db = new CreateDB();
        db.createNewDatabase(args[0]);
        db.createNewTable(args[0], args[1]);*/
        Terminal terminal = new Terminal();
        terminal.getTerminal();
    }
}
