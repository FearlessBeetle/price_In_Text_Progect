package api.services;

public interface NumberParserService {
    String[] parseNumberSequence();

    short[] get99_0();

    short[] get0_999();

    short[] get1000x_x999_999();

    short[] get1_000_000x_x999_999_999();

    short[] get1_000_000_000x_x999_999_999_999();
}
