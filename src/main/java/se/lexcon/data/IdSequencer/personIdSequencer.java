package se.lexcon.data.IdSequencer;

public class personIdSequencer {
    private static int sequencer = 100;

    public static int nextId() {
            return ++sequencer;
        }

    }

