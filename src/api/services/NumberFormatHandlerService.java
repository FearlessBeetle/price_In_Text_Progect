package api.services;

public interface NumberFormatHandlerService {
    String formatNumberSequence (String numberSequence);

    String removeExtraZero (String numberSequence);

    String removeExtraNumbers (String numberSequence);
}
